package com.lmc.shopleasing.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmc.shopleasing.entity.Booth;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.service.BoothService;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * 首页统计
 */
@RestController
@RequestMapping("/home/statistics")
public class HomeStatisticsController {
	
	@Resource
	private BoothService boothService;
	
	@PostMapping("/boothNumberstatistics")
	public ResponseEntity boothNumberstatistics() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String todayDate = dateFormat.format(new Date());
		Condition condition = new Condition(Booth.class);
		Criteria criteria = condition.createCriteria();
		criteria.andEqualTo("status", "3");//摊位状态 1正常出租 2即将到期 3可以出租
		criteria.andEqualTo("delFlag", "0");//未删除
		Integer toDaySurplus = boothService.selectCountByCondition(condition);//当日剩余
		
		Condition condition1 = new Condition(Booth.class);
		Criteria criteria1 = condition1.createCriteria();
		criteria1.andEqualTo("delFlag", "0");//未删除
		criteria1.andGreaterThanOrEqualTo("createTime", todayDate+" 00:00:00");
		Integer toDayAdd = boothService.selectCountByCondition(condition1);//当日剩余
		
		Condition condition2 = new Condition(Booth.class);
		Criteria criteria2 = condition2.createCriteria();
		criteria2.andEqualTo("delFlag", "0");//未删除
		Integer count = boothService.selectCountByCondition(condition2);//总摊位
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("toDaySurplus", toDaySurplus);
		map.put("toDayAdd", toDayAdd);
		map.put("count", count);
		return Results.success(map);
	}

}
