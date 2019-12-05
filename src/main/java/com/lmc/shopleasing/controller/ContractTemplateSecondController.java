package com.lmc.shopleasing.controller;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.entity.ContractTemplateColdStorage;
import com.lmc.shopleasing.entity.ContractTemplateSecond;
import com.lmc.shopleasing.service.ContractTemplateSecondService;

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
@RequestMapping("/contract/template/second")
public class ContractTemplateSecondController {
    @Resource
    private ContractTemplateSecondService contractTemplateSecondService;

    @PostMapping("/add")
    public ResponseEntity add(ContractTemplateSecond contractTemplateSecond) {
    	contractTemplateSecond.setDelFlag(false);//默认未删除
    	contractTemplateSecond.setCreateTime(new Date());
    	contractTemplateSecond.setCreateBy("1");
        contractTemplateSecondService.save(contractTemplateSecond);
        return Results.OK;
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestParam Integer id) {
        contractTemplateSecondService.deleteById(id);
        return Results.OK;
    }

    @PostMapping("/update")
    public ResponseEntity update(ContractTemplateSecond contractTemplateSecond) {
    	contractTemplateSecond.setDelFlag(null);
    	contractTemplateSecond.setCreateBy(null);
    	contractTemplateSecond.setCreateTime(null);
    	contractTemplateSecond.setUpdateTime(new Date());
    	contractTemplateSecond.setUpdateBy("1");
        contractTemplateSecondService.update(contractTemplateSecond);
        return Results.OK;
    }

    @PostMapping("/detail")
    public ResponseEntity detail(@RequestParam Integer id) {
        ContractTemplateSecond contractTemplateSecond = contractTemplateSecondService.findById(id);
        return Results.success(contractTemplateSecond);
    }

    @PostMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        Condition condition = new Condition(ContractTemplateSecond.class);
        Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("delFlag", false);
        List<ContractTemplateSecond> list = contractTemplateSecondService.findByCondition(condition);
        PageInfo<ContractTemplateSecond> pageInfo = new PageInfo<ContractTemplateSecond>(list);
        return Results.success(pageInfo);
    }
}
