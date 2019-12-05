package com.lmc.shopleasing.service;
import com.lmc.shopleasing.entity.Building;

import java.util.List;
import java.util.Map;

import com.lmc.shopleasing.core.Service;


/**
 * Created by lmc on 2019/11/09.
 */
public interface BuildingService extends Service<Building> {

	/**
	 * 查询建筑列表
	 * @param map
	 * @return
	 */
	List<Building> findByCondition(Map<String, Object> map);

}
