package com.lmc.shopleasing.dao;

import java.util.List;
import java.util.Map;

import com.lmc.shopleasing.core.Mapper;
import com.lmc.shopleasing.entity.Booth;

public interface BoothMapper extends Mapper<Booth> {

	/**
	 * 查询摊位列表
	 * @param map
	 * @return
	 */
	List<Booth> findByCondition(Map<String, Object> map);
}