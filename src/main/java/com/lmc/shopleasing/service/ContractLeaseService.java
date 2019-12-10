package com.lmc.shopleasing.service;
import com.lmc.shopleasing.entity.Booth;
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

	/**
	 * 录入摊位出租合同信息
	 * @param contractLease
	 * @param booth
	 */
	void save(ContractLease contractLease, Booth booth);


	/**
	 * g更新摊位出租合同信息
	 * @param contractLease
	 * @param booth
	 */
	void update(ContractLease contractLease, Booth booth);
	
	/**
	 * 根据id获取租期合同
	 * @param id
	 * @return
	 */
	ContractLease findContractById(Integer id);


}
