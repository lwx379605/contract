package com.lmc.shopleasing.controller;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.entity.SysDict;
import com.lmc.shopleasing.service.SysDictService;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example.Criteria;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;

import com.ctc.wstx.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;

import java.util.List;

/**
* Created by lmc on 2019/12/08.
*/
@RestController
@RequestMapping("/sys/dict")
public class SysDictController {
    @Resource
    private SysDictService sysDictService;

    @PostMapping("/add")
    public ResponseEntity add(SysDict sysDict) {
        sysDictService.save(sysDict);
        return Results.OK;
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestParam Integer id) {
        sysDictService.deleteById(id);
        return Results.OK;
    }

    @PostMapping("/update")
    public ResponseEntity update(SysDict sysDict) {
        sysDictService.update(sysDict);
        return Results.OK;
    }

    @PostMapping("/detail")
    public ResponseEntity detail(@RequestParam Integer id) {
        SysDict sysDict = sysDictService.findById(id);
        return Results.success(sysDict);
    }

    @PostMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysDict> list = sysDictService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return Results.success(pageInfo);
    }
    
    @PostMapping("/findListByType")
    public ResponseEntity list(String type) {
    	if (StringUtils.isBlank(type)) {
    		return Results.badRequest("字典项类型不能为空");
    	}
    	Condition condition = new Condition(SysDict.class);
    	Criteria criteria = condition.createCriteria();
    	criteria.andEqualTo("type", type);
    	criteria.andEqualTo("delFlag", "0");
        List<SysDict> list = sysDictService.findByCondition(condition);
        return Results.success(list);
    }
}
