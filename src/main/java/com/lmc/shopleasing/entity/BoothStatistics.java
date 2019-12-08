package com.lmc.shopleasing.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "s_booth_statistics")
public class BoothStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 统计日期
     */
    @Column(name = "statistics_date")
    private Date statisticsDate;

    /**
     * 周几
     */
    private String week;

    /**
     * 正在出租数量
     */
    @Column(name = "renting_count")
    private Integer rentingCount;

    /**
     * 空闲出租数量
     */
    @Column(name = "free_count")
    private Integer freeCount;

    /**
     * 即将到期数量
     */
    @Column(name = "expiring_count")
    private Integer expiringCount;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    
    public BoothStatistics() {}
    
    public BoothStatistics(Date statisticsDate, String week, Integer rentingCount,Integer freeCount,Integer expiringCount) {
    	this.statisticsDate = statisticsDate;
    	this.week = week;
    	this.rentingCount = rentingCount;
    	this.freeCount = freeCount;
    	this.expiringCount = expiringCount;
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
     * 获取统计日期
     *
     * @return statistics_date - 统计日期
     */
    public Date getStatisticsDate() {
        return statisticsDate;
    }

    /**
     * 设置统计日期
     *
     * @param statisticsDate 统计日期
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
     * 获取正在出租数量
     *
     * @return renting_count - 正在出租数量
     */
    public Integer getRentingCount() {
        return rentingCount;
    }

    /**
     * 设置正在出租数量
     *
     * @param rentingCount 正在出租数量
     */
    public void setRentingCount(Integer rentingCount) {
        this.rentingCount = rentingCount;
    }

    /**
     * 获取空闲出租数量
     *
     * @return free_count - 空闲出租数量
     */
    public Integer getFreeCount() {
        return freeCount;
    }

    /**
     * 设置空闲出租数量
     *
     * @param freeCount 空闲出租数量
     */
    public void setFreeCount(Integer freeCount) {
        this.freeCount = freeCount;
    }

    /**
     * 获取即将到期数量
     *
     * @return expiring_count - 即将到期数量
     */
    public Integer getExpiringCount() {
        return expiringCount;
    }

    /**
     * 设置即将到期数量
     *
     * @param expiringCount 即将到期数量
     */
    public void setExpiringCount(Integer expiringCount) {
        this.expiringCount = expiringCount;
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