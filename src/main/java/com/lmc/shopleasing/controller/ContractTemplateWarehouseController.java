package com.lmc.shopleasing.controller;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.entity.ContractTemplateShops;
import com.lmc.shopleasing.entity.ContractTemplateWarehouse;
import com.lmc.shopleasing.service.ContractTemplateWarehouseService;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example.Criteria;

import org.springframework.http.ResponseEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

/**
* Created by lmc on 2019/11/24.
*/
@RestController
@RequestMapping("/contract/template/warehouse")
public class ContractTemplateWarehouseController {
    @Resource
    private ContractTemplateWarehouseService contractTemplateWarehouseService;

    @PostMapping("/add")
    public ResponseEntity add(ContractTemplateWarehouse contractTemplateWarehouse) {
    	contractTemplateWarehouse.setDelFlag(false);//默认未删除
    	contractTemplateWarehouse.setCreateTime(new Date());
    	contractTemplateWarehouse.setCreateBy("1");
        contractTemplateWarehouseService.save(contractTemplateWarehouse);
        return Results.OK;
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestParam Integer id) {
        contractTemplateWarehouseService.deleteById(id);
        return Results.OK;
    }

    @PostMapping("/update")
    public ResponseEntity update(ContractTemplateWarehouse contractTemplateWarehouse) {
    	contractTemplateWarehouse.setDelFlag(null);
    	contractTemplateWarehouse.setCreateBy(null);
    	contractTemplateWarehouse.setCreateTime(null);
    	contractTemplateWarehouse.setUpdateTime(new Date());
    	contractTemplateWarehouse.setUpdateBy("1");
        contractTemplateWarehouseService.update(contractTemplateWarehouse);
        return Results.OK;
    }

    @PostMapping("/detail")
    public ResponseEntity detail(@RequestParam Integer id) {
        ContractTemplateWarehouse contractTemplateWarehouse = contractTemplateWarehouseService.findById(id);
        return Results.success(contractTemplateWarehouse);
    }

    @PostMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        Condition condition = new Condition(ContractTemplateWarehouse.class);
        Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("delFlag", false);
        List<ContractTemplateWarehouse> list = contractTemplateWarehouseService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return Results.success(pageInfo);
    }
}
