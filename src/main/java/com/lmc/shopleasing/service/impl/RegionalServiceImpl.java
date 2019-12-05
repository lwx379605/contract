package com.lmc.shopleasing.service.impl;

import com.lmc.shopleasing.dao.RegionalMapper;
import com.lmc.shopleasing.entity.Regional;
import com.lmc.shopleasing.service.RegionalService;
import com.lmc.shopleasing.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


/**
 * Created by lmc on 2019/11/09.
 */
@Service
@Transactional
public class RegionalServiceImpl extends AbstractService<Regional> implements RegionalService {
    @Resource
    private RegionalMapper sRegionalMapper;

	@Override
	public List<Regional> findByCondition(Map<String, Object> map) {
		return sRegionalMapper.findByCondition(map);
	}

}
