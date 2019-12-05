package com.lmc.shopleasing.service;
import com.lmc.shopleasing.entity.Booth;

import java.util.List;
import java.util.Map;

import com.lmc.shopleasing.core.Service;


/**
 * Created by lmc on 2019/11/09.
 */
public interface BoothService extends Service<Booth> {

	/**
	 * 查询摊位列表
	 * @param map
	 * @return
	 */
	List<Booth> findByCondition(Map<String, Object> map);

}
