package com.lmc.shopleasing.service;
import com.lmc.shopleasing.entity.ContractBudgetRecord;
import com.lmc.shopleasing.entity.ContractLease;

import java.util.List;
import java.util.Map;

import com.lmc.shopleasing.core.Service;


/**
 * Created by lmc on 2019/12/08.
 */
public interface ContractBudgetRecordService extends Service<ContractBudgetRecord> {

	/**
	 * 添加合同收支记录
	 * 
	 * @param contractCode 合同编码
	 * @param amount 金额
	 * @param paymentType 支付类型 1:收入,2:支出
	 * @param paymentType 支付项类型 1、租金，2、保证金，3、物业费，4、卫生费 5、其他
	 * @param lease 租赁合同
	 */
	void contractPay(String contractCode, Double amount, String paymentType,String itemType, ContractLease lease);
	
	/**
	 * 按时间支付类型统计金额
	 * 
	 * @param paymentType 支付类型(1:收入,2:支出)
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return
	 */
	String countAmountByPaymentTimeAndPaymentType(String paymentType,String startTime,String endTime);

}
