package com.lmc.shopleasing.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "s_booth")
public class Booth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 所属建筑物
     */
    @Column(name = "building_id")
    private Integer buildingId;
    
    /**
     * 所属建筑物名称
     */
    @Transient
    private String buildingName;

    /**
     * 摊位名称
     */
    private String name;

    /**
     * 摊位状态 1正常出租 2即将到期 3可以出租
     */
    private String status;
    
    /**
     * 租赁方式 1:月租，2:年租
     */
    @Column(name = "lease_mode")
    private String leaseMode;

    /**
     * 年租
     */
    @Column(name = "annual_rent")
    private Double annualRent;

    /**
     * 月租
     */
    @Column(name = "monthly_rent")
    private Double monthlyRent;

    /**
     * 装修保证金
     */
    @Column(name = "renovation_security_deposit")
    private Double renovationSecurityDeposit;

    /**
     * 保证金
     */
    @Column(name = "security_deposit")
    private Double securityDeposit;

    /**
     * 出租起始时间
     */
    @Column(name = "lease_start_time")
    private Date leaseStartTime;

    /**
     * 出租截止时间
     */
    @Column(name = "lease_over_time")
    private Date leaseOverTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 修改者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 删除标记  0:未删除 1:已删除
     */
    @Column(name = "del_flag")
    private Boolean delFlag;

    public String getLeaseMode() {
		return leaseMode;
	}

	public void setLeaseMode(String leaseMode) {
		this.leaseMode = leaseMode;
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
     * 获取所属建筑物
     *
     * @return building_id - 所属建筑物
     */
    public Integer getBuildingId() {
        return buildingId;
    }

    /**
     * 设置所属建筑物
     *
     * @param buildingId 所属建筑物
     */
    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }
    
    /**
     * 获取所属建筑物名称
     * @return building_name - 所属建筑物名称
     */
    public String getBuildingName() {
		return buildingName;
	}

    /**
     * 设置所属建筑物名称
     * @param building_name - 所属建筑物名称
     */
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	/**
     * 获取摊位名称
     *
     * @return name - 摊位名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置摊位名称
     *
     * @param name 摊位名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取摊位状态 1正常出租 2即将到期 3可以出租
     *
     * @return status - 摊位状态 1正常出租 2即将到期 3可以出租
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置摊位状态 1正常出租 2即将到期 3可以出租
     *
     * @param status 摊位状态 1正常出租 2即将到期 3可以出租
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取年租
     *
     * @return annual_rent - 年租
     */
    public Double getAnnualRent() {
        return annualRent;
    }

    /**
     * 设置年租
     *
     * @param annualRent 年租
     */
    public void setAnnualRent(Double annualRent) {
        this.annualRent = annualRent;
    }

    /**
     * 获取月租
     *
     * @return monthly_rent - 月租
     */
    public Double getMonthlyRent() {
        return monthlyRent;
    }

    /**
     * 设置月租
     *
     * @param monthlyRent 月租
     */
    public void setMonthlyRent(Double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    /**
     * 获取装修保证金
     *
     * @return renovation_security_deposit - 装修保证金
     */
    public Double getRenovationSecurityDeposit() {
        return renovationSecurityDeposit;
    }

    /**
     * 设置装修保证金
     *
     * @param renovationSecurityDeposit 装修保证金
     */
    public void setRenovationSecurityDeposit(Double renovationSecurityDeposit) {
        this.renovationSecurityDeposit = renovationSecurityDeposit;
    }

    /**
     * 获取保证金
     *
     * @return security_deposit - 保证金
     */
    public Double getSecurityDeposit() {
        return securityDeposit;
    }

    /**
     * 设置保证金
     *
     * @param securityDeposit 保证金
     */
    public void setSecurityDeposit(Double securityDeposit) {
        this.securityDeposit = securityDeposit;
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

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取修改者
     *
     * @return update_by - 修改者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置修改者
     *
     * @param updateBy 修改者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取删除标记  0:未删除 1:已删除
     *
     * @return del_flag - 删除标记  0:未删除 1:已删除
     */
    public Boolean getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记  0:未删除 1:已删除
     *
     * @param delFlag 删除标记  0:未删除 1:已删除
     */
    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }


    /**
     * 出租起始时间
     */
    public Date getLeaseStartTime() {
        return leaseStartTime;
    }

    /**
     * 出租起始时间
     */
    public void setLeaseStartTime(Date leaseStartTime) {
        this.leaseStartTime = leaseStartTime;
    }

    /**
     * 出租截止时间
     */
    public Date getLeaseOverTime() {
        return leaseOverTime;
    }

    /**
     * 出租截止时间
     */
    public void setLeaseOverTime(Date leaseOverTime) {
        this.leaseOverTime = leaseOverTime;
    }
}