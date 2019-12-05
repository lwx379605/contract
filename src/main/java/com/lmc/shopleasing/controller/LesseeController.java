package com.lmc.shopleasing.controller;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.entity.Lessee;
import com.lmc.shopleasing.service.LesseeService;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example.Criteria;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

/**
* Created by lmc on 2019/11/09.
*/
@RestController
@RequestMapping("/lessee")
public class LesseeController {
    @Resource
    private LesseeService lesseeService;

    @PostMapping("/add")
    public ResponseEntity add(Lessee lessee) {
    	if(StringUtils.isBlank(lessee.getType())) {
    		return Results.badRequest("承租人类型不能为空");
    	}
    	if (StringUtils.isBlank(lessee.getSex())) {
    		return Results.badRequest("法定代表人性别不能为空");
    	}
    	if (StringUtils.isBlank(lessee.getLegalRepresentative())) {
    		return Results.badRequest("法定代表人不能为空");
    	}
    	if (StringUtils.isBlank(lessee.getPhone())) {
    		return Results.badRequest("法定代表人联系方式不能为空");
    	}
    	if (StringUtils.isBlank(lessee.getPosition())) {
    		return Results.badRequest("法定代表人职位不能为空");
    	}
    	Condition condition = new Condition(Lessee.class);
    	Criteria criteria = condition.createCriteria();
    	criteria.andEqualTo("phone", lessee.getPhone());
    	Integer count = lesseeService.selectCountByCondition(condition);
    	if (count>0) {
    		return Results.badRequest("手机号已被占用");
    	}
    	lessee.setDelFlag(false);//默认未删除
    	lessee.setCreateTime(new Date());
    	lessee.setCreateBy("1");
        lesseeService.save(lessee);
        return Results.OK;
    }

    @PostMapping("/delete")
    public ResponseEntity delete(Integer id) {
    	Lessee model = new Lessee();
    	model.setId(id);
    	model.setDelFlag(true);
    	lesseeService.update(model);
        return Results.OK;
    }

    @PostMapping("/update")
    public ResponseEntity update(Lessee lessee) {
    	if (lessee.getId()==null) {
    		return Results.badRequest("承租人id不能为空");
    	}
    	if (StringUtils.isNotBlank(lessee.getPhone())) {
    		Lessee lessee2 = lesseeService.findBy("phone", lessee.getPhone());
    		if (!lessee.getId().equals(lessee2.getId())) {
    			return Results.badRequest("手机号已被占用");
    		}
    	}
    	lessee.setDelFlag(null);
    	lessee.setCreateTime(null);
    	lessee.setCreateBy(null);
    	lessee.setUpdateTime(new Date());
    	lessee.setUpdateBy("1");
        lesseeService.update(lessee);
        return Results.OK;
    }

    @PostMapping("/detail")
    public ResponseEntity detail(@RequestParam Integer id) {
        Lessee lessee = lesseeService.findById(id);
        return Results.success(lessee);
    }

    @PostMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, Lessee lessee) {
        PageHelper.startPage(page, size);
        PageHelper.orderBy("create_time desc");
        Condition condition = new Condition(Lessee.class);
        Criteria criteria = condition.createCriteria();
        if (StringUtils.isNotBlank(lessee.getType())) {
        	criteria.andEqualTo("type", lessee.getType());
        }
        if (StringUtils.isNotBlank(lessee.getLegalRepresentative())) {
        	criteria.andLike("legalRepresentative", lessee.getLegalRepresentative()+"%");
        }
        if (StringUtils.isNotBlank(lessee.getPhone())) {
        	criteria.andLike("phone", lessee.getPhone()+"%");
        }
        criteria.andEqualTo("delFlag", false);
        List<Lessee> list = lesseeService.findByCondition(condition);
        PageInfo<Lessee> pageInfo = new PageInfo<Lessee>(list);
        return Results.success(pageInfo);
    }
    
    @PostMapping("/findLesseeList")
    public ResponseEntity list(Lessee lessee) {
        PageHelper.orderBy("create_time desc");
        Condition condition = new Condition(Lessee.class);
        Criteria criteria = condition.createCriteria();
        if (StringUtils.isNotBlank(lessee.getType())) {
        	criteria.andEqualTo("type", lessee.getType());
        }
        if (StringUtils.isNotBlank(lessee.getLegalRepresentative())) {
        	criteria.andLike("legalRepresentative", lessee.getLegalRepresentative()+"%");
        }
        if (StringUtils.isNotBlank(lessee.getPhone())) {
        	criteria.andLike("phone", lessee.getPhone()+"%");
        }
        criteria.andEqualTo("delFlag", false);
        List<Lessee> list = lesseeService.findByCondition(condition);
        return Results.success(list);
    }
}
