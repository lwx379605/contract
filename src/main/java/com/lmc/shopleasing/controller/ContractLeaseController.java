package com.lmc.shopleasing.controller;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.entity.Booth;
import com.lmc.shopleasing.entity.ContractLease;
import com.lmc.shopleasing.entity.Lessee;
import com.lmc.shopleasing.service.BoothService;
import com.lmc.shopleasing.service.ContractLeaseService;
import com.lmc.shopleasing.service.LesseeService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example.Criteria;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.zxing.Result;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by lmc on 2019/11/09.
*/
@RestController
@RequestMapping("/contract/lease")
public class ContractLeaseController extends  BaseController{
    @Resource
    private ContractLeaseService contractLeaseService;

    @Resource
    private BoothService boothService;

    @Resource
    private LesseeService lesseeService;

    @PostMapping("/add")
    public ResponseEntity add(ContractLease contractLease, @Valid  BoothForm boothForm) {
    	if (StringUtils.isBlank(contractLease.getOsskey())) {
    		return Results.badRequest("附件不能为空");
    	}
    	if (contractLease.getEffectiveTime()==null) {
    		return Results.badRequest("生效时间不能为空");
    	}
    	if (contractLease.getExpireTime()==null) {
    		return Results.badRequest("失效时间不能为空");
    	}
    	if (contractLease.getLesseeId()==null) {
    		return Results.badRequest("承租人id不能为空");
    	}
    	Lessee lessee = lesseeService.findById(Integer.valueOf(contractLease.getLesseeId()));
    	if (lessee==null) {
    		return Results.badRequest("承租人不存在");
    	}
    	if (contractLease.getBoothId()==null) {
    		return Results.badRequest("摊位id不能为空");
    	}
    	if (StringUtils.isBlank(contractLease.getContractCode())) {
    		return Results.badRequest("合同编码不能为空");
    	}
    	Booth booth = boothService.findById(Integer.valueOf(contractLease.getBoothId()));
    	if (booth==null) {
    		return Results.badRequest("摊位不存在");
    	}
    	if(!StringUtils.equals("3",booth.getStatus())){
			return Results.badRequest("摊位状态不是可出租状态");
		}
    	Condition condition = new Condition(ContractLease.class);
    	Criteria criteria = condition.createCriteria();
    	criteria.andEqualTo("contractCode", contractLease.getContractCode());
    	Integer count = contractLeaseService.selectCountByCondition(condition);
    	if (count>0) {
    		return Results.badRequest("合同编码重复！");
    	}
    	contractLease.setLesseeId(lessee.getId());
    	contractLease.setBoothId(booth.getId());
    	contractLease.setDelFlag(false);//默认未删除
    	contractLease.setCreateTime(new Date());
    	contractLease.setCreateBy("1");
    	contractLease.setPaymentAmount(null);
    	contractLease.setPaymentTime(null);

    	if(StringUtils.equals("1",boothForm.getLeaseMode())){
			booth.setMonthlyRent(boothForm.getAmount());
		}else{
			booth.setAnnualRent(boothForm.getAmount());
		}
		booth.setStatus("1");
		booth.setHygieneFee(boothForm.getHygieneFee());
		booth.setLeaseOverTime(boothForm.getLeaseOverTime());
		booth.setLeaseStartTime(boothForm.leaseStartTime);
		booth.setRenovationSecurityDeposit(boothForm.getRenovationSecurityDeposit());
		booth.setSecurityDeposit(boothForm.getSecurityDeposit());
        contractLeaseService.save(contractLease,booth);
        return Results.OK;
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestParam Integer id) {
    	ContractLease model = new ContractLease();
    	model.setId(id);
    	model.setDelFlag(true);
        contractLeaseService.update(model);
        return Results.OK;
    }

    @PostMapping("/update")
    public ResponseEntity update(ContractLease contractLease,BoothForm boothForm) {

    	if (contractLease.getId()==null) {
    		return Results.badRequest("id不能为空");
    	}
		ContractLease ocl = contractLeaseService.findById(contractLease.getId());
		if (ocl == null) {
			return Results.badRequest("当前操作的合同不存在");
		}
		if (StringUtils.isNotBlank(contractLease.getContractCode())) {
    		Condition condition = new Condition(ContractLease.class);
    		Criteria criteria = condition.createCriteria();
    		criteria.andEqualTo("contractCode", contractLease.getContractCode());
    		List<ContractLease> list = contractLeaseService.findByCondition(condition);
    		if (list!=null && list.size()>0) {
    			ContractLease lease = list.get(0);
    			if (!contractLease.getId().equals(lease.getId())) {
    				return Results.badRequest("合同编码重复！");
    			}
    		}
    	}

		contractLease.setDelFlag(null);
    	contractLease.setCreateTime(null);
    	contractLease.setCreateBy(null);
    	contractLease.setUpdateTime(new Date());
    	contractLease.setPaymentAmount(null);
    	contractLease.setPaymentTime(null);
    	contractLease.setUpdateBy("1");
		Booth booth = boothService.findById(ocl.getBoothId());
		Booth model =null;
		if(booth!=null){
			model = new Booth();
			model.setId(booth.getId());
			if(StringUtils.equals("1",boothForm.getLeaseMode())){
				booth.setMonthlyRent(boothForm.getAmount());
			}else{
				booth.setAnnualRent(boothForm.getAmount());
			}
			model.setHygieneFee(boothForm.getHygieneFee());
			model.setLeaseOverTime(boothForm.getLeaseOverTime());
			model.setLeaseStartTime(boothForm.getLeaseStartTime());
			model.setRenovationSecurityDeposit(boothForm.getRenovationSecurityDeposit());
			model.setSecurityDeposit(boothForm.getSecurityDeposit());
		}

        contractLeaseService.update(contractLease,model);
        return Results.OK;
    }

    @PostMapping("/detail")
    public ResponseEntity detail(@RequestParam Integer id) {
        ContractLease contractLease = contractLeaseService.findById(id);
        return Results.success(contractLease);
    }

    @PostMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, ContractLease contractLease) {
        PageHelper.startPage(page, size);
        PageHelper.orderBy("create_time DESC");
        Map<String, Object> map = new HashMap<String, Object>();
        if (contractLease.getLesseeId()!=null) {
        	map.put("lesseeId", contractLease.getLesseeId());
        }
        if (StringUtils.isNotBlank(contractLease.getLesseeName())) {
        	map.put("lesseeName", contractLease.getLesseeName());
        }
        if (contractLease.getBoothId()!=null) {
        	map.put("boothId", contractLease.getBoothId());
        }
        if (StringUtils.isNotBlank(contractLease.getBoothName())) {
			map.put("boothName", contractLease.getBoothName());
		}
        map.put("delFlag", "0");
        List<ContractLease> list = contractLeaseService.findByCondition(map);
        PageInfo<ContractLease> pageInfo = new PageInfo<ContractLease>(list);
        return Results.success(pageInfo);
    }


    public static class BoothForm{

		/**
		 * 出租起始时间
		 */
		@NotNull(message = "摊位出租起始时间不能为空")
		private Date leaseStartTime;

		/**
		 * 出租截止时间
		 */
		@NotNull(message = "摊位出租截止时间不能为空")
		private Date leaseOverTime;

		/**
		 * 租赁方式 1:月租，2:年租
		 */
		@Pattern(regexp = "^[12]$",message = "租赁方式只能为 1:月租，2:年租")
		private String leaseMode;


		/**
		 * 金额
		 */
		@NotNull(message = "金额不能为空")
		private Double amount;

		/**
		 * 装修保证金
		 */
		@NotNull(message = "装修保证金不能为空")
		private Double renovationSecurityDeposit;

		/**
		 * 保证金
		 */
		@NotNull(message = "摊位保证金不能为空")
		private Double securityDeposit;

		/**
		 * 卫生费
		 */
		@NotNull(message = "卫生费不能为空")
		private Double hygieneFee;

		public Date getLeaseStartTime() {
			return leaseStartTime;
		}

		public void setLeaseStartTime(Date leaseStartTime) {
			this.leaseStartTime = leaseStartTime;
		}

		public Date getLeaseOverTime() {
			return leaseOverTime;
		}

		public void setLeaseOverTime(Date leaseOverTime) {
			this.leaseOverTime = leaseOverTime;
		}

		public String getLeaseMode() {
			return leaseMode;
		}

		public void setLeaseMode(String leaseMode) {
			this.leaseMode = leaseMode;
		}

		public Double getAmount() {
			return amount;
		}

		public void setAmount(Double amount) {
			this.amount = amount;
		}

		public Double getRenovationSecurityDeposit() {
			return renovationSecurityDeposit;
		}

		public void setRenovationSecurityDeposit(Double renovationSecurityDeposit) {
			this.renovationSecurityDeposit = renovationSecurityDeposit;
		}

		public Double getSecurityDeposit() {
			return securityDeposit;
		}

		public void setSecurityDeposit(Double securityDeposit) {
			this.securityDeposit = securityDeposit;
		}

		public Double getHygieneFee() {
			return hygieneFee;
		}

		public void setHygieneFee(Double hygieneFee) {
			this.hygieneFee = hygieneFee;
		}
	}
}
