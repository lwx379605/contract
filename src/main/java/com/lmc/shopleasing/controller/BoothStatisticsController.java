package com.lmc.shopleasing.controller;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.entity.BoothStatistics;
import com.lmc.shopleasing.service.BoothStatisticsService;

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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* Created by lmc on 2019/12/08.
*/
@RestController
@RequestMapping("/booth/statistics")
public class BoothStatisticsController {
    @Resource
    private BoothStatisticsService boothStatisticsService;

    @PostMapping("/findBoothStatisticsList")
    public ResponseEntity findBoothStatisticsList(String type) {
    	if (StringUtils.isBlank(type)) {//1:本周,2:上周
    		return Results.badRequest("统计类型不能为空");
    	}
    	Map<String, Object> map = null;
    	if (StringUtils.equals(type, "1")) {
    		map = getThisWeek();
    	}else if(StringUtils.equals(type, "2")) {
    		map = getLastWeek();
    	}else {
    		return Results.badRequest("统计类型输入错误");
    	}
    	String startTime = (String) map.get("startTime");
    	String endTime = (String) map.get("endTime");
    	Condition condition = new Condition(BoothStatistics.class);
    	Criteria criteria = condition.createCriteria();
    	criteria.andBetween("statisticsDate", startTime, endTime);
    	List<BoothStatistics> list = boothStatisticsService.findByCondition(condition);
    	
    	Map<String, Object> mapResponse = new HashMap<String, Object>();
    	mapResponse.put("boothLable", list.stream().map(BoothStatistics::getWeek).collect(Collectors.toList()));
    	mapResponse.put("rentingCount", list.stream().map(BoothStatistics::getRentingCount).collect(Collectors.toList()));
    	mapResponse.put("freeCount", list.stream().map(BoothStatistics::getFreeCount).collect(Collectors.toList()));
    	mapResponse.put("expiringCount", list.stream().map(BoothStatistics::getExpiringCount).collect(Collectors.toList()));
        return Results.success(mapResponse);
    }
    
    /**
     * 本周
     * @return
     */
    private Map<String, Object> getThisWeek(){
    	Map<String, Object> map = new HashMap<String, Object>();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar thisWeek = Calendar.getInstance();
		thisWeek.setTime(new Date() );
		int n1;
		if (thisWeek.get(Calendar.DAY_OF_WEEK)==1) {
			n1 = -1;// n为推迟的周数，-1上周，0本周，1下周，2下下周，依次类推
		}else {
			n1 = 0;
		}
		thisWeek.add(Calendar.DATE, n1 * 7);
		//上周周一
		thisWeek.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		map.put("startTime", dateFormat.format(thisWeek.getTime()));
		
		Calendar lastWeek = Calendar.getInstance();
		if (lastWeek.get(Calendar.DAY_OF_WEEK)==1) {
			n1 = 0;
		}else {
			n1 = 1;// n为推迟的周数，-1上周，0本周，1下周，2下下周，依次类推
		}
		lastWeek.add(Calendar.DATE, n1 * 7);
		//上周周一
		lastWeek.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		map.put("endTime", dateFormat.format(lastWeek.getTime()));
		return map;
	}
    
    /**
     * 上周
     * @return
     */
    private Map<String, Object> getLastWeek(){
    	Map<String, Object> map = new HashMap<String, Object>();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar thisWeek = Calendar.getInstance();
		thisWeek.setTime(new Date() );
		int n1;
		if (thisWeek.get(Calendar.DAY_OF_WEEK)==1) {
			n1 = -2;// n为推迟的周数，-1上周，0本周，1下周，2下下周，依次类推
		}else {
			n1 = -1;
		}
		thisWeek.add(Calendar.DATE, n1 * 7);
		//上周周一
		thisWeek.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		map.put("startTime", dateFormat.format(thisWeek.getTime())+" 00:00:00");
		
		Calendar lastWeek = Calendar.getInstance();
		if (lastWeek.get(Calendar.DAY_OF_WEEK)==1) {
			n1 = -1;
		}else {
			n1 = 0;// n为推迟的周数，-1上周，0本周，1下周，2下下周，依次类推
		}
		lastWeek.add(Calendar.DATE, n1 * 7);
		//上周周一
		lastWeek.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		map.put("endTime", dateFormat.format(thisWeek.getTime()));
		return map;
	}
}
