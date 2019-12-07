package com.lmc.shopleasing.controller;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.entity.Booth;
import com.lmc.shopleasing.entity.Building;
import com.lmc.shopleasing.service.BoothService;
import com.lmc.shopleasing.service.BuildingService;

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

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by lmc on 2019/11/09.
*/
@RestController
@RequestMapping("/booth")
public class BoothController {
    @Resource
    private BoothService boothService;
    @Resource
    private BuildingService buildingService;

    @PostMapping("/add")
    public ResponseEntity add(Booth booth) {
    	if (StringUtils.isBlank(booth.getName())) {
    		return Results.badRequest("摊位名称不能为空");
    	}
    	if (StringUtils.isBlank(booth.getStatus())) {
    		return Results.badRequest("摊位状态不能为空");
    	}
    	if (StringUtils.isBlank(booth.getBuildingId())) {
    		return Results.badRequest("所属建筑物id不能为空");
    	}
    	Building building = buildingService.findById(Integer.valueOf(booth.getBuildingId()));
    	if (building==null) {
    		return Results.badRequest("所属建筑物不存在");
    	}
    	booth.setBuildingId(building.getId()+"");
    	booth.setDelFlag(false);//默认未删除
    	booth.setCreateTime(new Date());
    	booth.setCreateBy("1");
    	booth.setStatus("3");//摊位状态 1正常出租 2即将到期 3可以出租
        boothService.save(booth);
        return Results.OK;
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestParam Integer id) {
    	Booth booth = new Booth();
    	booth.setId(id);
    	booth.setDelFlag(true);
    	boothService.update(booth);
        return Results.OK;
    }

    @PostMapping("/update")
    public ResponseEntity update(Booth booth) {
    	if (booth.getId()==null) {
    		return Results.badRequest("摊位id不能为空");
    	}
    	booth.setSecurityDeposit(null);
    	booth.setRenovationSecurityDeposit(null);
    	booth.setDelFlag(null);
    	booth.setCreateBy(null);
    	booth.setCreateTime(null);
    	booth.setUpdateTime(new Date());
    	booth.setUpdateBy("1");
        boothService.update(booth);
        return Results.OK;
    }

    @PostMapping("/detail")
    public ResponseEntity detail(@RequestParam Integer id) {
        Booth booth = boothService.findById(id);
        return Results.success(booth);
    }

    @PostMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, Booth booth) {
        PageHelper.startPage(page, size);
        PageHelper.orderBy("create_time DESC");
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(booth.getName())) {
        	map.put("name", booth.getName());
        }
        if (StringUtils.isNotBlank(booth.getBuildingId())) {
        	map.put("buildingId", booth.getBuildingId());
        }
        map.put("delFlag", "0");
        List<Booth> list = boothService.findByCondition(map);
        PageInfo<Booth> pageInfo = new PageInfo<Booth>(list);
        return Results.success(pageInfo);
    }
    
    @PostMapping("/findBoothList")
    public ResponseEntity findBoothList(Booth booth) {
        PageHelper.orderBy("create_time DESC");
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(booth.getName())) {
        	map.put("name", booth.getName());
        }
        if (StringUtils.isNotBlank(booth.getBuildingId())) {
        	map.put("buildingId", booth.getBuildingId());
        }
        map.put("delFlag", "0");
        List<Booth> list = boothService.findByCondition(map);
        return Results.success(list);
    }
    
    @PostMapping("/rent")
    public ResponseEntity rent(@RequestParam Integer id,String type, Double rent) {
    	if (StringUtils.isBlank(type)) {//1:月租,2:年租
    		return Results.badRequest("租金类型不能为空");
    	}
    	BigDecimal annualRent = null;//年租
    	BigDecimal monthlyRent = null;//月租
    	if (StringUtils.equals(type, "1")) {//月租
    		annualRent = new BigDecimal(rent).multiply(new BigDecimal(12)).setScale(2, BigDecimal.ROUND_HALF_UP);
    		monthlyRent = new BigDecimal(rent).setScale(2, BigDecimal.ROUND_HALF_UP);
    	} else if (StringUtils.equals(type, "2")) {//年租
    		annualRent = new BigDecimal(rent).setScale(2, BigDecimal.ROUND_HALF_UP);
    		monthlyRent = new BigDecimal(rent).divide(new BigDecimal(12), 2, BigDecimal.ROUND_HALF_DOWN).setScale(2, BigDecimal.ROUND_HALF_UP);
    	} else {
    		return Results.badRequest("租金类型错误");
    	}
    	Booth booth = new Booth();
    	booth.setId(id);
    	booth.setAnnualRent(annualRent.doubleValue());
    	booth.setMonthlyRent(monthlyRent.doubleValue());
    	boothService.update(booth);
        return Results.OK;
    }
    
    
}
