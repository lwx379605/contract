package com.lmc.shopleasing.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "s_regional")
public class Regional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 区名称
     */
    private String name;

    /**
     * 区类型
     */
    private String type;
    
    /**
     * 所属区域
     */
    @Column(name = "area_id")
    private String areaId;
    
    /**
     * 所属区域名称
     */
    @Transient
    private String areaName;
    
    /**
     * 可出租面积
     */
    private Double rentableArea;
    
    /**
     * 已出租面积
     */
    private Double rentedArea;

    /**
     * 出租率
     */
    private Double rentalRate;

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
     * 删除标志 0:未删除 1:已删除
     */
    @Column(name = "del_flag")
    private Boolean delFlag;

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
     * 获取区名称
     *
     * @return name - 区名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置区名称
     *
     * @param name 区名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取区类型
     *
     * @return type - 区类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置区类型
     *
     * @param type 区类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取所属区域id
     * @return areaId - 所属区域id
     */
    public String getAreaId() {
		return areaId;
	}
    
    /**
     * 设置所属区域
     * @return areaId 区域id
     */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
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
     * 获取删除标志 0:未删除 1:已删除
     *
     * @return del_flag - 删除标志 0:未删除 1:已删除
     */
    public Boolean getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标志 0:未删除 1:已删除
     *
     * @param delFlag 删除标志 0:未删除 1:已删除
     */
    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取区域名称
     * @return areaName - 获取区域名称
     */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * 设置区域名称
	 * 
	 * @param areaName - 区域名称
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * 获取可出租面积
	 * @return rentableArea - 获取可出租面积
	 */
	public Double getRentableArea() {
		return rentableArea;
	}

	/**
	 * 设置可出租面积
	 * @param rentableArea - 可出租面积
	 */
	public void setRentableArea(Double rentableArea) {
		this.rentableArea = rentableArea;
	}

	/**
	 * 获取已出租面积
	 * @return rentedArea - 获取已出租面积
	 */
	public Double getRentedArea() {
		return rentedArea;
	}

	/**
	 * 设置可出租面积
	 * @param rentedArea - 可出租面积
	 */
	public void setRentedArea(Double rentedArea) {
		this.rentedArea = rentedArea;
	}
	
	/**
	 * 获取出租率
	 * @return rentalRate 获取出租率
	 */
	public Double getRentalRate() {
		return rentalRate;
	}

	/**
	 * 设置出租率
	 * @param rentalRate 出租率
	 */
	public void setRentalRate(Double rentalRate) {
		this.rentalRate = rentalRate;
	}
	
	
    
}