package com.lmc.shopleasing.controller;
import com.lmc.shopleasing.global.Results;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmc.shopleasing.entity.Booth;
import com.lmc.shopleasing.entity.ContractBudgetRecord;
import com.lmc.shopleasing.entity.ContractLease;
import com.lmc.shopleasing.service.ContractBudgetRecordService;
import com.lmc.shopleasing.service.ContractLeaseService;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example.Criteria;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

/**
* Created by lmc on 2019/12/08.
*/
@RestController
@RequestMapping("/contract/budget/record")
public class ContractBudgetRecordController {
    @Resource
    private ContractBudgetRecordService contractBudgetRecordService;
    @Resource
    private ContractLeaseService contractLeaseService;

    @PostMapping("/contractPay")
    public ResponseEntity contractPay(String contractCode,Double amount,String paymentType,String itemType) {
    	if (StringUtils.isBlank(contractCode)) {
    		return Results.badRequest("合同编码不能为空");
    	}
    	if (amount == null) {
    		return Results.badRequest("金额不能为空");
    	}
    	if (StringUtils.isBlank(paymentType)) {//1:收入,2:支出
    		return Results.badRequest("支付类型不能为空");
    	}
		if (StringUtils.isBlank(itemType)) {//itemType 支付项类型 1、租金，2、保证金，3、物业费，4、卫生费
			return Results.badRequest("支付项类型不能为空");
		}

    	if (!StringUtils.equals(paymentType, "1") && !StringUtils.equals(paymentType, "2")) {
    		return Results.badRequest("支付类型不存在");
    	}
    	ContractLease lease = contractLeaseService.findBy("contractCode", contractCode);
    	if (lease == null) {
    		return Results.badRequest("合同不存在");
    	}
        contractBudgetRecordService.contractPay(contractCode,amount,paymentType,itemType,lease);
        return Results.OK;
    }
    
    @PostMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, ContractBudgetRecord record) {
    	PageHelper.startPage(page, size);
        PageHelper.orderBy("create_time DESC");

        Condition condition = new Condition(ContractBudgetRecord.class);
        Criteria criteria = condition.createCriteria();
        
        if (StringUtils.isNotBlank(record.getContractCode())) {
        	criteria.andEqualTo("contractCode", record.getContractCode());
        }
        if (StringUtils.isNotBlank(record.getPaymentType())) {
        	criteria.andEqualTo("paymentType", record.getPaymentType());
        }
        if (StringUtils.isNotBlank(record.getItemType())) {
        	criteria.andEqualTo("itemType", record.getItemType());
        }
        List<ContractBudgetRecord> list = contractBudgetRecordService.findByCondition(condition);
        PageInfo<ContractBudgetRecord> pageInfo = new PageInfo<ContractBudgetRecord>(list);
        return Results.success(pageInfo);
    }

}
