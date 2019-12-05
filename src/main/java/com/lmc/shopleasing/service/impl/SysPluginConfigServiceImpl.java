package com.lmc.shopleasing.service.impl;


import com.lmc.shopleasing.core.AbstractService;
import com.lmc.shopleasing.dao.SysPluginConfigMapper;
import com.lmc.shopleasing.entity.SysPluginConfig;
import com.lmc.shopleasing.service.SysPluginConfigService;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Service - 插件配置
 *
 * @author lmc
 */
@Service
@Transactional
public class SysPluginConfigServiceImpl extends AbstractService<SysPluginConfig> implements SysPluginConfigService {

	@Autowired
	private SysPluginConfigMapper sysPluginConfigMapper;

	@Transactional(readOnly = true)
	public boolean pluginIdExists(String pluginId) {
		return findByPluginId(pluginId) != null;
	}

	@Transactional(readOnly = true)
	@Cacheable("sysPluginConfig")
	public SysPluginConfig findByPluginId(String pluginId) {
		Condition condition = new Condition(SysPluginConfig.class);
		Example.Criteria criteria = condition.createCriteria();
		criteria.andEqualTo("pluginId", pluginId);
		List<SysPluginConfig> sysPluginConfigs = sysPluginConfigMapper.selectByCondition(condition);
		if(sysPluginConfigs==null || sysPluginConfigs.isEmpty()){
			return null;
		}else if (sysPluginConfigs.size()>1){
			throw new TooManyResultsException();
		}

		return sysPluginConfigs.get(0);
	}

	@CacheEvict(value = "sysPluginConfig", allEntries = true)
	public void deleteByPluginId(String pluginId) {
        SysPluginConfig pluginConfig = findByPluginId(pluginId);
        if(pluginConfig!=null){
			super.deleteById(pluginConfig.getId());
		}
	}

	@Transactional
	@CacheEvict(value = "sysPluginConfig", allEntries = true)
	public int save(SysPluginConfig pluginConfig) {
		return super.save(pluginConfig);
	}

	@Transactional
	@CacheEvict(value = "sysPluginConfig", allEntries = true)
	public void delete(Integer id) {
		super.deleteById(id);
	}

	@Transactional
	@CacheEvict(value = "sysPluginConfig", allEntries = true)
	public void delete(Integer... ids) {
		super.deleteByIds(StringUtils.join(ids,","));
	}

}