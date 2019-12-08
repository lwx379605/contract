package com.lmc.shopleasing.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lmc.shopleasing.entity.BudgetStatistics;
import com.lmc.shopleasing.service.BudgetStatisticsService;
import com.lmc.shopleasing.service.ContractBudgetRecordService;


@Lazy(false)
@Component
public class BudgetStatisticsJob {
	
	@Resource
	private BudgetStatisticsService budgetStatisticsService;
	
	@Resource
	private ContractBudgetRecordService contractBudgetRecordService;
	
	
	private static String[] weeks = {"周日","周一","周二","周三","周四","周五","周六"};
	
	@Scheduled(cron = "0 0 0 1/1 * ? ")
	public void collect() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String weekName = weeks[calendar.get(Calendar.DAY_OF_WEEK)-1];//周几
		String startTime = format.format(calendar.getTime())+" 00:00:00";
		String endTime = format.format(calendar.getTime())+" 23:59:59";
		String income  = contractBudgetRecordService.countAmountByPaymentTimeAndPaymentType("1", startTime, endTime);
		String expenditure  = contractBudgetRecordService.countAmountByPaymentTimeAndPaymentType("2", startTime, endTime);
		
		BudgetStatistics budgetStatistics = new BudgetStatistics(calendar.getTime(), weekName, Double.valueOf(income), Double.valueOf(expenditure));
		budgetStatisticsService.save(budgetStatistics);
	}
	
}
