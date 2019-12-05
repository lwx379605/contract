package com.lmc.shopleasing.service.impl;

import com.lmc.shopleasing.dao.BuildingMapper;
import com.lmc.shopleasing.entity.Building;
import com.lmc.shopleasing.service.BuildingService;
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
public class BuildingServiceImpl extends AbstractService<Building> implements BuildingService {
    @Resource
    private BuildingMapper sBuildingMapper;

	@Override
	public List<Building> findByCondition(Map<String, Object> map) {
		return sBuildingMapper.findByCondition(map);
	}

}
