package com.lmc.shopleasing.dao;

import java.util.List;
import java.util.Map;

import com.lmc.shopleasing.core.Mapper;
import com.lmc.shopleasing.entity.ContractLease;

public interface ContractLeaseMapper extends Mapper<ContractLease> {

	/**
	 * 合同租期列表
	 * @param map
	 * @return
	 */
	List<ContractLease> findByCondition(Map<String, Object> map);
}