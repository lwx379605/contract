package com.lmc.shopleasing.service;
import com.lmc.shopleasing.entity.Regional;

import java.util.List;
import java.util.Map;

import com.lmc.shopleasing.core.Service;


/**
 * Created by lmc on 2019/11/09.
 */
public interface RegionalService extends Service<Regional> {

	/**
	 * 查询分区列表
	 * @param map
	 * @return
	 */
	List<Regional> findByCondition(Map<String, Object> map);

}
