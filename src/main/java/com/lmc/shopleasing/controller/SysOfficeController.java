package com.lmc.shopleasing.controller;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.entity.SysArea;
import com.lmc.shopleasing.entity.SysOffice;
import com.lmc.shopleasing.service.SysOfficeService;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example.Criteria;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by lmc on 2019/11/02.
*/
@RestController
@RequestMapping("/sys/office")
public class SysOfficeController extends BaseController{
    @Resource
    private SysOfficeService sysOfficeService;

    @PostMapping("/add")
    public ResponseEntity add(SysOffice sysOffice) {
    	if (sysOffice.getParentId()==null) {
    		return Results.badRequest("父级id不能为空");
    	}
    	if (StringUtils.isBlank(sysOffice.getName())) {
    		return Results.badRequest("名称不能为空");
    	}
    	if (sysOffice.getOrder()==null) {
    		return Results.badRequest("排序不能为空");
    	}
    	if (StringUtils.isBlank(sysOffice.getType())) {
    		return Results.badRequest("类型不能为空");
    	}
    	if (StringUtils.isBlank(sysOffice.getGrade())) {
    		return Results.badRequest("等级不能为空");
    	}
    	SysOffice officeParent = sysOfficeService.findById(sysOffice.getParentId());
    	if (officeParent==null) {
    		return Results.badRequest("父级部门不存在");
    	}
    	String parentIds = officeParent.getParentIds() + officeParent.getId();
    	sysOffice.setParentIds(parentIds);
    	sysOffice.setCreatedDate(new Date());
        sysOfficeService.save(sysOffice);
        return Results.OK;
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestParam Integer id) {
    	SysOffice model = new SysOffice();
    	model.setId(id);
    	model.setDelFlag(true);
    	sysOfficeService.update(model);
        return Results.OK;
    }

    @PostMapping("/update")
    public ResponseEntity update(SysOffice sysOffice) {
    	if (sysOffice.getId()==null) {
    		return Results.badRequest("部门id不能为空");
    	}
    	if (sysOffice.getParentId()!=null) {
    		SysOffice officeParent = sysOfficeService.findBy("parenId", sysOffice.getParentId());
        	if (officeParent==null) {
        		return Results.badRequest("父级部门不存在");
        	}
        	String parentIds = officeParent.getParentIds() + officeParent.getId();
        	sysOffice.setParentIds(parentIds);
    	}
        sysOfficeService.update(sysOffice);
        return Results.OK;
    }

    @PostMapping("/detail")
    public ResponseEntity detail(@RequestParam Integer id) {
        SysOffice sysOffice = sysOfficeService.findById(id);
        return Results.success(sysOffice);
    }

    @PostMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, SysOffice sysOffice) {
        PageHelper.startPage(page, size);
        Condition condition = new Condition(SysOffice.class);
        Criteria criteria = condition.createCriteria();
        if (StringUtils.isNotBlank(sysOffice.getName())) {
        	criteria.andLike("name", sysOffice.getName()+"%");
        }
        criteria.andEqualTo("delFlag", "0");
        List<SysOffice> list = sysOfficeService.findByCondition(condition);
        PageInfo<SysOffice> pageInfo = new PageInfo<SysOffice>(list);
        return Results.success(pageInfo);
    }
    
    @PostMapping("/findOfficeParentId")
    public ResponseEntity findOfficeParentId(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, Integer parentId) {
        PageHelper.startPage(page, size);
        List<Map<String, Object>> data = new ArrayList<>();
        SysOffice parent = sysOfficeService.findById(parentId);
        Collection<SysOffice> offices = parent != null ? sysOfficeService.findChildren(parent,false) : sysOfficeService.findRoots();
        for (SysOffice office : offices) {
            Map<String, Object> item = new HashMap<>();
            item.put("name", office.getName());
            item.put("id", office.getId());
            data.add(item);
        }
        return Results.success(data);
    }
}