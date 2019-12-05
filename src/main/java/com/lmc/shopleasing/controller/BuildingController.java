package com.lmc.shopleasing.controller;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.entity.Building;
import com.lmc.shopleasing.entity.Regional;
import com.lmc.shopleasing.service.BuildingService;
import com.lmc.shopleasing.service.RegionalService;
import com.mchange.lang.ObjectUtils;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by lmc on 2019/11/09.
*/
@RestController
@RequestMapping("/building")
public class BuildingController {
    @Resource
    private BuildingService buildingService;
    @Resource
    private RegionalService regionalService;

    @PostMapping("/add")
    public ResponseEntity add(Building building) {
    	if (StringUtils.isBlank(building.getName())) {
    		return Results.badRequest("建筑名称不能为空");
    	}
    	if (StringUtils.isBlank(building.getRegionalId())) {
    		return Results.badRequest("所属分区id不能为空");
    	}
    	if (StringUtils.isBlank(building.getBuildingNumber())) {
    		return Results.badRequest("楼幢号不能为空");
    	}
    	if (StringUtils.isBlank(building.getLocationNumber())) {
    		return Results.badRequest("区位编号不能为空");
    	}
    	if (building.getRoomQuantity()==null) {
    		return Results.badRequest("房间数不能为空");
    	}
    	if (building.getArea()==null) {
    		return Results.badRequest("面积不能为空");
    	}
    	if (StringUtils.isBlank(building.getBusinessFormat())) {
    		return Results.badRequest("经营业态不能为空");
    	}
    	if (StringUtils.isBlank(building.getPropertyFormat())) {
    		return Results.badRequest("物业业态不能为空");
    	}
    	Regional regional = regionalService.findById(Integer.valueOf(building.getRegionalId()));
    	if (regional==null) {
    		return Results.badRequest("所属分区不存在");
    	}
    	building.setRegionalId(regional.getId()+"");
    	building.setDelFlag(false);//默认未删除
    	building.setCreateTime(new Date());
    	building.setCreateBy("1");
        buildingService.save(building);
        return Results.OK;
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestParam Integer id) {
    	Building building = new Building();
    	building.setId(id);
    	building.setDelFlag(true);
        buildingService.update(building);
        return Results.OK;
    }

    @PostMapping("/update")
    public ResponseEntity update(Building building) {
    	if (building.getId()==null) {
    		return Results.badRequest("建筑id不能为空");
    	}
    	building.setDelFlag(null);
    	building.setCreateTime(null);
    	building.setCreateBy(null);
    	building.setUpdateTime(new Date());
    	building.setUpdateBy("1");
        buildingService.update(building);
        return Results.OK;
    }

    @PostMapping("/detail")
    public ResponseEntity detail(@RequestParam Integer id) {
        Building building = buildingService.findById(id);
        return Results.success(building);
    }

    @PostMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, Building building) {
        PageHelper.startPage(page, size);
        PageHelper.orderBy("b.create_time DESC");
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(building.getName())) {
        	map.put("name", building.getName()+"%");
        }
        if (StringUtils.isNotBlank(building.getRegionalId())) {
        	map.put("regionalId", building.getRegionalId());
        }
        if (StringUtils.isNotBlank(building.getRegionalName())) {
        	map.put("regionalName", building.getRegionalName());
        }
        map.put("delFlag", "0");
        List<Building> list = buildingService.findByCondition(map);
        PageInfo<Building> pageInfo = new PageInfo<Building>(list);
        return Results.success(pageInfo);
    }
    
    @PostMapping("/findBuildingList")
    public ResponseEntity findBuildingList(Building building) {
        PageHelper.orderBy("b.create_time DESC");
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(building.getName())) {
        	map.put("name", building.getName()+"%");
        }
        if (StringUtils.isNotBlank(building.getRegionalId())) {
        	map.put("regionalId", building.getRegionalId());
        }
        if (StringUtils.isNotBlank(building.getRegionalName())) {
        	map.put("regionalName", building.getRegionalName());
        }
        map.put("delFlag", "0");
        List<Building> list = buildingService.findByCondition(map);
        return Results.success(list);
    }
}
