package com.lmc.shopleasing.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lmc.shopleasing.entity.Booth;
import com.lmc.shopleasing.entity.BoothStatistics;
import com.lmc.shopleasing.service.BoothService;
import com.lmc.shopleasing.service.BoothStatisticsService;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example.Criteria;

@Lazy(false)
@Component
public class BoothStatisticsJob {
	
	@Resource
	private BoothStatisticsService boothStatisticsService;
	
	@Resource
	private BoothService boothService;
	
	private static String[] weeks = {"周日","周一","周二","周三","周四","周五","周六"};
	
	@Scheduled(cron = "0 0 0 1/1 * ? ")
	public void collect() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String weekName = weeks[calendar.get(Calendar.DAY_OF_WEEK)-1];//周几
		
		Condition condition = new Condition(Booth.class);
		Criteria criteria = condition.createCriteria();
		criteria.andEqualTo("delFlag", "0");
		criteria.andEqualTo("status", "1");//摊位状态 1正常出租
		criteria.andGreaterThanOrEqualTo("createTime", format.format(calendar.getTime())+" 00:00:00");
		Integer rentingCount = boothService.selectCountByCondition(condition);
		
		Condition condition1 = new Condition(Booth.class);
		Criteria criteria1 = condition1.createCriteria();
		criteria1.andEqualTo("delFlag", "0");
		criteria1.andEqualTo("status", "1");//摊位状态  3可以出租
		criteria1.andGreaterThanOrEqualTo("createTime", format.format(calendar.getTime())+" 00:00:00");
		Integer freeCount = boothService.selectCountByCondition(condition1);
		
		Condition condition2 = new Condition(Booth.class);
		Criteria criteria2 = condition2.createCriteria();
		criteria2.andEqualTo("delFlag", "0");
		criteria2.andEqualTo("status", "1");//摊位状态  2即将到期
		criteria2.andGreaterThanOrEqualTo("createTime", format.format(calendar.getTime())+" 00:00:00");
		Integer expiringCount = boothService.selectCountByCondition(condition2);
		
		BoothStatistics statistics = new BoothStatistics(calendar.getTime(), weekName, rentingCount, freeCount, expiringCount);
		boothStatisticsService.save(statistics);
	}
	
}
