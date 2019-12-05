package com.lmc.shopleasing.dao;

import java.util.List;
import java.util.Map;

import com.lmc.shopleasing.core.Mapper;
import com.lmc.shopleasing.entity.Regional;

public interface RegionalMapper extends Mapper<Regional> {

	/**
	 * 查询分区列表
	 * @param map
	 * @return
	 */
	List<Regional> findByCondition(Map<String, Object> map);
}