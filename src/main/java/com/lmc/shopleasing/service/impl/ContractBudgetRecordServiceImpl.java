package com.lmc.shopleasing.service.impl;

import com.lmc.shopleasing.dao.ContractBudgetRecordMapper;
import com.lmc.shopleasing.entity.ContractBudgetRecord;
import com.lmc.shopleasing.entity.ContractLease;
import com.lmc.shopleasing.service.ContractBudgetRecordService;
import com.lmc.shopleasing.service.ContractLeaseService;
import com.lmc.shopleasing.core.AbstractService;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;


/**
 * Created by lmc on 2019/12/08.
 */
@Service
@Transactional
public class ContractBudgetRecordServiceImpl extends AbstractService<ContractBudgetRecord> implements ContractBudgetRecordService {
    @Resource
    private ContractBudgetRecordMapper sContractBudgetRecordMapper;
    
    @Resource
    private ContractLeaseService contractLeaseService;

	@Override
	public void contractPay(String contractCode, Double amount, String paymentType,String itemType, ContractLease lease) {
		Date currDate = new Date();
		ContractBudgetRecord budgetRecord = new ContractBudgetRecord();
		budgetRecord.setContractCode(contractCode);
		budgetRecord.setContractName(lease.getContractName());
		budgetRecord.setAmount(amount);
		budgetRecord.setPaymentType(paymentType);
		budgetRecord.setPaymentTime(currDate);
		budgetRecord.setCreateTime(currDate);
		budgetRecord.setItemType(itemType);
		save(budgetRecord);
		Double paymentAmount = 0.0;
		if (lease.getPaymentAmount()!=null) {
			paymentAmount = lease.getPaymentAmount();
		}
		if (StringUtils.equals(paymentType, "1")) {//支付类型 1:收入,2:支出
			paymentAmount = new BigDecimal(paymentAmount).add(new BigDecimal(amount)).doubleValue();
		} else {
			paymentAmount = new BigDecimal(paymentAmount).subtract(new BigDecimal(amount)).doubleValue();
		}
		lease.setPaymentAmount(paymentAmount);
		lease.setPaymentTime(new Date());
		contractLeaseService.update(lease);
	}

	@Override
	public String countAmountByPaymentTimeAndPaymentType(String paymentType, String startTime, String endTime) {
		return sContractBudgetRecordMapper.countAmountByPaymentTimeAndPaymentType(paymentType, startTime, endTime);
	}

}
