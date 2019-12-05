package com.lmc.shopleasing.service.impl;

import com.lmc.shopleasing.dao.BoothMapper;
import com.lmc.shopleasing.entity.Booth;
import com.lmc.shopleasing.service.BoothService;
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
public class BoothServiceImpl extends AbstractService<Booth> implements BoothService {
    @Resource
    private BoothMapper sBoothMapper;

	@Override
	public List<Booth> findByCondition(Map<String, Object> map) {
		return sBoothMapper.findByCondition(map);
	}

}
