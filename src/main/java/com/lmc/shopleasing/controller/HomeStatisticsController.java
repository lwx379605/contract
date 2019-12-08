package com.lmc.shopleasing.controller;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmc.shopleasing.entity.Booth;
import com.lmc.shopleasing.entity.BoothStatistics;
import com.lmc.shopleasing.entity.BudgetStatistics;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.service.BoothService;
import com.lmc.shopleasing.service.BoothStatisticsService;
import com.lmc.shopleasing.service.BudgetStatisticsService;
import com.lmc.shopleasing.service.ContractBudgetRecordService;

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
	
	@Resource
    private BoothStatisticsService boothStatisticsService;
	
	@Resource
	private ContractBudgetRecordService budgetRecordService;
	
	@Resource
	private BudgetStatisticsService budgetStatisticsService;
	
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
    
    @PostMapping("/incomeStatistics")
    public ResponseEntity incomeStatistics() {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	Date currDate = new Date();
    	String paymentType = "1";//1:收入,2:支出
    	String toDayAmount = budgetRecordService.countAmountByPaymentTimeAndPaymentType(paymentType, dateFormat.format(currDate)+" 00:00:00", dateFormat.format(currDate)+" 23:59:59");
    	Map<String, Object> map = getThisWeek();
    	String startTime = (String) map.get("startTime");
    	String endTime = (String) map.get("endTime");
    	String weekAmount = budgetRecordService.countAmountByPaymentTimeAndPaymentType(paymentType, startTime, endTime);
    	Map<String, Object> mapResponse = new HashMap<String, Object>();
    	mapResponse.put("toDayAmount", toDayAmount==null?"0":toDayAmount);
    	mapResponse.put("weekAmount", weekAmount==null?"0":weekAmount);
    	return Results.success(mapResponse);
    }
    
    @PostMapping("/findBudgetStatistics")
    public ResponseEntity findBudgetStatistics(String type) {
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
    	
    	List<BudgetStatistics> list = budgetStatisticsService.findByCondition(condition);
    	
    	Map<String, Object> mapResponse = new HashMap<String, Object>();
    	mapResponse.put("boothLable", list.stream().map(BudgetStatistics::getWeek).collect(Collectors.toList()));
    	mapResponse.put("incomeCount", list.stream().map(BudgetStatistics::getIncome).collect(Collectors.toList()));
    	mapResponse.put("expenditureCount", list.stream().map(BudgetStatistics::getExpenditure).collect(Collectors.toList()));
        return Results.success(mapResponse);
    }
    
    @PostMapping("/statisticsBoothStatus")
    public ResponseEntity statisticsBoothStatus(String type) {
    	if (StringUtils.isBlank(type)) {//1:本月,2:上月
    		return Results.badRequest("统计类型不能为空");
    	}
    	
    	Condition condition = new Condition(Booth.class);
    	Criteria criteria = condition.createCriteria();
    	criteria.andEqualTo("delFlag", false);
    	Integer allCount = boothService.selectCountByCondition(condition);
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("allCount", StringUtils.equals(type, "2")?0:allCount);
    	
    	Condition condition1 = new Condition(Booth.class);
    	Criteria criteria1 = condition1.createCriteria();
    	criteria1.andEqualTo("status", "1");//正常
    	criteria1.andEqualTo("delFlag", false);
    	Integer leaseCount = boothService.selectCountByCondition(condition1);
    	
    	map.put("leaseCount", StringUtils.equals(type, "2")?0:leaseCount);
    	map.put("leasePercent", StringUtils.equals(type, "2")?"0%":percent(allCount, leaseCount));
    	
    	Condition condition2 = new Condition(Booth.class);
    	Criteria criteria2 = condition2.createCriteria();
    	criteria2.andEqualTo("status", "2");//即将到期
    	criteria2.andEqualTo("delFlag", false);
    	Integer expireCount = boothService.selectCountByCondition(condition2);
    	
    	map.put("expireCount", StringUtils.equals(type, "2")?0:expireCount);
    	map.put("expirePercent", StringUtils.equals(type, "2")?"0%":percent(allCount, expireCount));
    	
    	Condition condition3 = new Condition(Booth.class);
    	Criteria criteria3 = condition3.createCriteria();
    	criteria3.andEqualTo("status", "3");//可以出租
    	criteria3.andEqualTo("delFlag", false);
    	Integer freeCount = boothService.selectCountByCondition(condition3);
    	
    	map.put("freeCount", StringUtils.equals(type, "2")?0:freeCount);
    	map.put("freePercent", StringUtils.equals(type, "2")?"0%":percent(allCount, freeCount));
    	
        return Results.success(map);
    }
    
    private static String percent(Integer count,Integer value) {
 
		// 创建一个数值格式化对象
 
		NumberFormat numberFormat = NumberFormat.getInstance();
 
		// 设置精确到小数点后2位
 
		numberFormat.setMaximumFractionDigits(2);
 
		String result = numberFormat.format((float) value / (float) count * 100);
 
		return result + "%";
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
