package com.lmc.shopleasing.dao;

import org.apache.ibatis.annotations.Param;

import com.lmc.shopleasing.core.Mapper;
import com.lmc.shopleasing.entity.ContractBudgetRecord;

public interface ContractBudgetRecordMapper extends Mapper<ContractBudgetRecord> {
	
	/**
	 * 按时间支付类型统计金额
	 * 
	 * @param paymentType 支付类型(1:收入,2:支出)
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return
	 */
	String countAmountByPaymentTimeAndPaymentType(@Param("paymentType") String paymentType,@Param("startTime") String startTime,@Param("endTime") String endTime);
}