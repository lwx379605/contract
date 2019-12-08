package com.lmc.shopleasing.controller;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.entity.Regional;
import com.lmc.shopleasing.entity.SysArea;
import com.lmc.shopleasing.service.RegionalService;
import com.lmc.shopleasing.service.SysAreaService;

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

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by lmc on 2019/11/09.
*/
@RestController
@RequestMapping("/regional")
public class RegionalController {
    @Resource
    private RegionalService regionalService;
    @Resource
    private SysAreaService areaService;

    @PostMapping("/add")
    public ResponseEntity add(Regional regional) {
    	if (StringUtils.isBlank(regional.getName())) {
            return Results.badRequest("分区名称不能为空");
        }
    	if (StringUtils.isBlank(regional.getType())) {
    		return Results.badRequest("分区类型不能为空");
    	}
    	if (StringUtils.isBlank(regional.getAreaId())) {
    		return Results.badRequest("所属区域id不能为空");
    	}
    	if (regional.getRentableArea()!=null && regional.getRentedArea()!=null) {
    		if (regional.getRentedArea()>regional.getRentableArea()) {
    			return Results.badRequest("可出租面积不能小于已出租面积");
    		}
    		BigDecimal rentalRate = new BigDecimal(regional.getRentedArea()).divide(new BigDecimal(regional.getRentableArea()),4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
    		regional.setRentalRate(rentalRate.doubleValue());
    	}
    	regional.setDelFlag(false);//默认未删除
    	regional.setCreateTime(new Date());
    	regional.setCreateBy("1");
        regionalService.save(regional);
        return Results.OK;
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestParam Integer id) {
    	Regional model = new Regional();
    	model.setId(id);
    	model.setDelFlag(true);
    	regionalService.update(model);
        return Results.OK;
    }

    @PostMapping("/update")
    public ResponseEntity update(Regional regional) {
    	if (regional.getId()==null) {
    		return Results.badRequest("分区id不能为空");
    	}
    	if (regional.getRentableArea()!=null && regional.getRentedArea()!=null) {
    		if (regional.getRentedArea()>regional.getRentableArea()) {
    			return Results.badRequest("可出租面积不能小于已出租面积");
    		}
    		BigDecimal rentalRate = new BigDecimal(regional.getRentedArea()).divide(new BigDecimal(regional.getRentableArea()), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
    		regional.setRentalRate(rentalRate.doubleValue());
    	}
    	regional.setDelFlag(null);
    	regional.setCreateTime(null);
    	regional.setCreateBy(null);
    	regional.setUpdateTime(new Date());
    	regional.setUpdateBy("1");
        regionalService.update(regional);
        return Results.OK;
    }

    @PostMapping("/detail")
    public ResponseEntity detail(@RequestParam Integer id) {
        Regional regional = regionalService.findById(id);
        SysArea area = areaService.findById(Integer.valueOf(regional.getAreaId()));
        if(area!=null) {
        	regional.setAreaName(area.getFullName());
        }
        return Results.success(regional);
    }

    @PostMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,Regional regional) {
        PageHelper.startPage(page, size);
        PageHelper.orderBy("create_time DESC");
        Map<String, Object> map = new HashMap<String, Object>();
        if(StringUtils.isNotBlank(regional.getName())) {
        	map.put("name", regional.getName()+"%");
        }
        if(StringUtils.isNotBlank(regional.getType())) {
        	map.put("type",regional.getType());
        }
        map.put("delFlag", "0");
        List<Regional> list = regionalService.findByCondition(map);
        PageInfo<Regional> pageInfo = new PageInfo<Regional>(list);
        return Results.success(pageInfo);
    }
    
    @PostMapping("/findRegionalList")
    public ResponseEntity findRegionalList(Regional regional) {
        PageHelper.orderBy("create_time DESC");
        Map<String, Object> map = new HashMap<String, Object>();
        if(StringUtils.isNotBlank(regional.getName())) {
        	map.put("name", regional.getName()+"%");
        }
        if(StringUtils.isNotBlank(regional.getType())) {
        	map.put("type",regional.getType());
        }
        map.put("delFlag", "0");
        List<Regional> list = regionalService.findByCondition(map);
        return Results.success(list);
    }
}
