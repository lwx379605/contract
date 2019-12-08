package com.lmc.shopleasing.controller;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.entity.ContractLease;
import com.lmc.shopleasing.service.ContractBudgetRecordService;
import com.lmc.shopleasing.service.ContractLeaseService;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity contractPay(String contractCode,Double amount,String paymentType) {
    	if (StringUtils.isBlank(contractCode)) {
    		return Results.badRequest("合同编码不能为空");
    	}
    	if (amount == null) {
    		return Results.badRequest("金额不能为空");
    	}
    	if (StringUtils.isBlank(paymentType)) {//1:收入,2:支出
    		return Results.badRequest("支付类型不能为空");
    	}
    	if (!StringUtils.equals(paymentType, "1") && !StringUtils.equals(paymentType, "2")) {
    		return Results.badRequest("支付类型不存在");
    	}
    	ContractLease lease = contractLeaseService.findBy("contractCode", contractCode);
    	if (lease == null) {
    		return Results.badRequest("合同不存在");
    	}
        contractBudgetRecordService.contractPay(contractCode,amount,paymentType,lease);
        return Results.OK;
    }

}
