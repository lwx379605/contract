package com.lmc.shopleasing.controller;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.entity.ContractTemplateColdStorage;
import com.lmc.shopleasing.service.ContractTemplateColdStorageService;

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
@RequestMapping("/contract/template/cold/storage")
public class ContractTemplateColdStorageController {
    @Resource
    private ContractTemplateColdStorageService contractTemplateColdStorageService;

    @PostMapping("/add")
    public ResponseEntity add(ContractTemplateColdStorage contractTemplateColdStorage) {
    	contractTemplateColdStorage.setDelFlag(false);//默认未删除
    	contractTemplateColdStorage.setCreateTime(new Date());
    	contractTemplateColdStorage.setCreateBy("1");
        contractTemplateColdStorageService.save(contractTemplateColdStorage);
        return Results.OK;
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestParam Integer id) {
        contractTemplateColdStorageService.deleteById(id);
        return Results.OK;
    }

    @PostMapping("/update")
    public ResponseEntity update(ContractTemplateColdStorage contractTemplateColdStorage) {
    	contractTemplateColdStorage.setDelFlag(null);
    	contractTemplateColdStorage.setCreateBy(null);
    	contractTemplateColdStorage.setCreateTime(null);
    	contractTemplateColdStorage.setUpdateTime(new Date());
    	contractTemplateColdStorage.setUpdateBy("1");
        contractTemplateColdStorageService.update(contractTemplateColdStorage);
        return Results.OK;
    }

    @PostMapping("/detail")
    public ResponseEntity detail(@RequestParam Integer id) {
        ContractTemplateColdStorage contractTemplateColdStorage = contractTemplateColdStorageService.findById(id);
        return Results.success(contractTemplateColdStorage);
    }

    @PostMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,ContractTemplateColdStorage storage) {
        PageHelper.startPage(page, size);
        Condition condition = new Condition(ContractTemplateColdStorage.class);
        Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("delFlag", false);
        List<ContractTemplateColdStorage> list = contractTemplateColdStorageService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return Results.success(pageInfo);
    }
}
