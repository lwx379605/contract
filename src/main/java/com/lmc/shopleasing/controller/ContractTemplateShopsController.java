package com.lmc.shopleasing.controller;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.entity.ContractTemplateSecond;
import com.lmc.shopleasing.entity.ContractTemplateShops;
import com.lmc.shopleasing.service.ContractTemplateShopsService;

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
@RequestMapping("/contract/template/shops")
public class ContractTemplateShopsController {
    @Resource
    private ContractTemplateShopsService contractTemplateShopsService;

    @PostMapping("/add")
    public ResponseEntity add(ContractTemplateShops contractTemplateShops) {
    	contractTemplateShops.setDelFlag(false);//默认未删除
    	contractTemplateShops.setCreateTime(new Date());
    	contractTemplateShops.setCreateBy("1");
        contractTemplateShopsService.save(contractTemplateShops);
        return Results.OK;
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestParam Integer id) {
        contractTemplateShopsService.deleteById(id);
        return Results.OK;
    }

    @PostMapping("/update")
    public ResponseEntity update(ContractTemplateShops contractTemplateShops) {
    	contractTemplateShops.setDelFlag(null);
    	contractTemplateShops.setCreateBy(null);
    	contractTemplateShops.setCreateTime(null);
    	contractTemplateShops.setUpdateTime(new Date());
    	contractTemplateShops.setUpdateBy("1");
        contractTemplateShopsService.update(contractTemplateShops);
        return Results.OK;
    }

    @PostMapping("/detail")
    public ResponseEntity detail(@RequestParam Integer id) {
        ContractTemplateShops contractTemplateShops = contractTemplateShopsService.findById(id);
        return Results.success(contractTemplateShops);
    }

    @PostMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        Condition condition = new Condition(ContractTemplateShops.class);
        Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("delFlag", false);
        List<ContractTemplateShops> list = contractTemplateShopsService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return Results.success(pageInfo);
    }
}
