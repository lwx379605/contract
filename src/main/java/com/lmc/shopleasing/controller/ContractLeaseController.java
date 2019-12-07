package com.lmc.shopleasing.controller;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.entity.Booth;
import com.lmc.shopleasing.entity.ContractLease;
import com.lmc.shopleasing.entity.Lessee;
import com.lmc.shopleasing.service.BoothService;
import com.lmc.shopleasing.service.ContractLeaseService;
import com.lmc.shopleasing.service.LesseeService;

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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by lmc on 2019/11/09.
*/
@RestController
@RequestMapping("/contract/lease")
public class ContractLeaseController {
    @Resource
    private ContractLeaseService contractLeaseService;
    @Resource
    private BoothService boothService;
    @Resource
    private LesseeService lesseeService;

    @PostMapping("/add")
    public ResponseEntity add(ContractLease contractLease) {
    	if (StringUtils.isBlank(contractLease.getOsskey())) {
    		return Results.badRequest("附件不能为空");
    	}
    	if (contractLease.getEffectiveTime()==null) {
    		return Results.badRequest("生效时间不能为空");
    	}
    	if (contractLease.getExpireTime()==null) {
    		return Results.badRequest("失效时间不能为空");
    	}
    	if (StringUtils.isBlank(contractLease.getLesseeId())) {
    		return Results.badRequest("承租人id不能为空");
    	}
    	Lessee lessee = lesseeService.findById(Integer.valueOf(contractLease.getLesseeId()));
    	if (lessee==null) {
    		return Results.badRequest("承租人不存在");
    	}
    	if (StringUtils.isBlank(contractLease.getBoothId())) {
    		return Results.badRequest("摊位id不能为空");
    	}
    	if (StringUtils.isBlank(contractLease.getContractCode())) {
    		return Results.badRequest("合同编码不能为空");
    	}
    	Booth booth = boothService.findById(Integer.valueOf(contractLease.getBoothId()));
    	if (booth==null) {
    		return Results.badRequest("摊位不存在");
    	}
    	Condition condition = new Condition(ContractLease.class);
    	Criteria criteria = condition.createCriteria();
    	criteria.andEqualTo("contractCode", contractLease.getContractCode());
    	Integer count = contractLeaseService.selectCountByCondition(condition);
    	if (count>0) {
    		return Results.badRequest("合同编码重复！");
    	}
    	contractLease.setLesseeId(lessee.getId()+"");
    	contractLease.setBoothId(booth.getId()+"");
    	contractLease.setDelFlag(false);//默认未删除
    	contractLease.setCreateTime(new Date());
    	contractLease.setCreateBy("1");
        contractLeaseService.save(contractLease);
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
    public ResponseEntity update(ContractLease contractLease) {
    	if (contractLease.getId()==null) {
    		return Results.badRequest("id不能为空");
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
    	contractLease.setUpdateBy("1");
        contractLeaseService.update(contractLease);
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
        if (StringUtils.isNotBlank(contractLease.getLesseeId())) {
        	map.put("lesseeId", contractLease.getLesseeId());
        }
        if (StringUtils.isNotBlank(contractLease.getLesseeName())) {
        	map.put("lesseeName", contractLease.getLesseeName());
        }
        if (StringUtils.isNotBlank(contractLease.getBoothId())) {
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
}
