package com.lmc.shopleasing.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "s_budget_statistics")
public class BudgetStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 统计时间
     */
    @Column(name = "statistics_date")
    private Date statisticsDate;

    /**
     * 周几
     */
    private String week;

    /**
     * 收入
     */
    private Double income;

    /**
     * 支出
     */
    private Double expenditure;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    
    public BudgetStatistics() {}
    
    public BudgetStatistics(Date statisticsDate, String week, Double income, Double expenditure) {
    	this.statisticsDate = statisticsDate;
    	this.week = week;
    	this.income = income;
    	this.expenditure = expenditure;
    	this.createTime = new Date();
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取统计时间
     *
     * @return statistics_date - 统计时间
     */
    public Date getStatisticsDate() {
        return statisticsDate;
    }

    /**
     * 设置统计时间
     *
     * @param statisticsDate 统计时间
     */
    public void setStatisticsDate(Date statisticsDate) {
        this.statisticsDate = statisticsDate;
    }

    /**
     * 获取周几
     *
     * @return week - 周几
     */
    public String getWeek() {
        return week;
    }

    /**
     * 设置周几
     *
     * @param week 周几
     */
    public void setWeek(String week) {
        this.week = week;
    }

    /**
     * 获取收入
     *
     * @return income - 收入
     */
    public Double getIncome() {
        return income;
    }

    /**
     * 设置收入
     *
     * @param income 收入
     */
    public void setIncome(Double income) {
        this.income = income;
    }

    /**
     * 获取支出
     *
     * @return expenditure - 支出
     */
    public Double getExpenditure() {
        return expenditure;
    }

    /**
     * 设置支出
     *
     * @param expenditure 支出
     */
    public void setExpenditure(Double expenditure) {
        this.expenditure = expenditure;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}