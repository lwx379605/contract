package com.lmc.shopleasing.service.impl;

import com.lmc.shopleasing.dao.SysOfficeMapper;
import com.lmc.shopleasing.entity.SysArea;
import com.lmc.shopleasing.entity.SysOffice;
import com.lmc.shopleasing.service.SysOfficeService;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import com.lmc.shopleasing.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;


/**
 * Created by lmc on 2019/11/02.
 */
@Service
@Transactional
public class SysOfficeServiceImpl extends AbstractService<SysOffice> implements SysOfficeService {
    @Resource
    private SysOfficeMapper sysOfficeMapper;

	@Override
	public List<SysOffice> findChildren(SysOffice office, boolean recursive) {
        if(office == null || office.getParentId() == null){
            return Collections.emptyList();
        }
        Condition condition = new Condition(SysArea.class);
        Example.Criteria criteria = condition.createCriteria();
        if(recursive){
            criteria.andIn("parentId", Arrays.asList(office.getParentIds()));
            condition.orderBy("grade").asc();
        }else {
            criteria.andEqualTo("parentId",office.getId());
        }
        return sysOfficeMapper.selectByCondition(condition);
    }

	@Override
	public List<SysOffice> findRoots() {
        Condition condition = new Condition(SysOffice.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("parentId", "0");
        condition.orderBy("order").asc();
        return  sysOfficeMapper.selectByCondition(condition);
    }

}
