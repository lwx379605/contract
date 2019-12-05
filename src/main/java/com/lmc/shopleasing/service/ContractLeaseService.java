package com.lmc.shopleasing.service;
import com.lmc.shopleasing.entity.ContractLease;

import java.util.List;
import java.util.Map;

import com.lmc.shopleasing.core.Service;


/**
 * Created by lmc on 2019/11/09.
 */
public interface ContractLeaseService extends Service<ContractLease> {

	/**
	 * 合同租期列表
	 * @param map
	 * @return
	 */
	List<ContractLease> findByCondition(Map<String, Object> map);

}
