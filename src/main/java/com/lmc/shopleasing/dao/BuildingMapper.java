package com.lmc.shopleasing.dao;

import java.util.List;
import java.util.Map;

import com.lmc.shopleasing.core.Mapper;
import com.lmc.shopleasing.entity.Building;

public interface BuildingMapper extends Mapper<Building> {

	/**
	 * 查询建筑物列表
	 * @param map
	 * @return
	 */
	List<Building> findByCondition(Map<String, Object> map);
}