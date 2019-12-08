package com.lmc.shopleasing.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "s_building")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 所属分区
     */
    @Column(name = "regional_id")
    private Integer regionalId;
    
    /**
     * 分区名称
     */
    @Transient
    private String regionalName;

    /**
     * 建筑物名称
     */
    private String name;

    /**
     * 楼幢号
     */
    @Column(name = "building_number")
    private String buildingNumber;

    /**
     * 区位编号
     */
    @Column(name = "location_number")
    private String locationNumber;

    /**
     * 间数
     */
    @Column(name = "room_quantity")
    private Integer roomQuantity;

    /**
     * 面积
     */
    private Double area;

    /**
     * 是否可出租 1:是，0:否
     */
    @Column(name = "is_rentable")
    private Boolean isRentable;

    /**
     * 是否出租 1:是，0:否
     */
    @Column(name = "is_rent")
    private Boolean isRent;

    /**
     * 经营业态 （字典项）
     */
    @Column(name = "business_format")
    private String businessFormat;

    /**
     * 物业业态
     */
    @Column(name = "property_format")
    private String propertyFormat;

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
     * 获取所属分区
     *
     * @return regional_id - 所属分区
     */
    public Integer getRegionalId() {
        return regionalId;
    }

    /**
     * 设置所属分区
     *
     * @param regionalId 所属分区
     */
    public void setRegionalId(Integer regionalId) {
        this.regionalId = regionalId;
    }
    
    /**
     * 获取所属分区名称
     * @return
     */
    public String getRegionalName() {
		return regionalName;
	}

    /**
     * 设置所属分区名称
     * @param regionalName 所属分区
     */
	public void setRegionalName(String regionalName) {
		this.regionalName = regionalName;
	}

	/**
     * 获取建筑物名称
     *
     * @return name - 建筑物名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置建筑物名称
     *
     * @param name 建筑物名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取楼幢号
     *
     * @return building_number - 楼幢号
     */
    public String getBuildingNumber() {
        return buildingNumber;
    }

    /**
     * 设置楼幢号
     *
     * @param buildingNumber 楼幢号
     */
    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    /**
     * 获取区位编号
     *
     * @return location_number - 区位编号
     */
    public String getLocationNumber() {
        return locationNumber;
    }

    /**
     * 设置区位编号
     *
     * @param locationNumber 区位编号
     */
    public void setLocationNumber(String locationNumber) {
        this.locationNumber = locationNumber;
    }

    /**
     * 获取间数
     *
     * @return room_quantity - 间数
     */
    public Integer getRoomQuantity() {
        return roomQuantity;
    }

    /**
     * 设置间数
     *
     * @param roomQuantity 间数
     */
    public void setRoomQuantity(Integer roomQuantity) {
        this.roomQuantity = roomQuantity;
    }

    /**
     * 获取面积
     *
     * @return area - 面积
     */
    public Double getArea() {
        return area;
    }

    /**
     * 设置面积
     *
     * @param area 面积
     */
    public void setArea(Double area) {
        this.area = area;
    }

    /**
     * 获取是否可出租 1:是，0:否
     *
     * @return is_rentable - 是否可出租 1:是，0:否
     */
    public Boolean getIsRentable() {
        return isRentable;
    }

    /**
     * 设置是否可出租 1:是，0:否
     *
     * @param isRentable 是否可出租 1:是，0:否
     */
    public void setIsRentable(Boolean isRentable) {
        this.isRentable = isRentable;
    }

    /**
     * 获取是否出租 1:是，0:否
     *
     * @return is_rent - 是否出租 1:是，0:否
     */
    public Boolean getIsRent() {
        return isRent;
    }

    /**
     * 设置是否出租 1:是，0:否
     *
     * @param isRent 是否出租 1:是，0:否
     */
    public void setIsRent(Boolean isRent) {
        this.isRent = isRent;
    }

    /**
     * 获取经营业态 （字典项）
     *
     * @return business_format - 经营业态 （字典项）
     */
    public String getBusinessFormat() {
        return businessFormat;
    }

    /**
     * 设置经营业态 （字典项）
     *
     * @param businessFormat 经营业态 （字典项）
     */
    public void setBusinessFormat(String businessFormat) {
        this.businessFormat = businessFormat;
    }

    /**
     * 获取物业业态
     *
     * @return property_format - 物业业态
     */
    public String getPropertyFormat() {
        return propertyFormat;
    }

    /**
     * 设置物业业态
     *
     * @param propertyFormat 物业业态
     */
    public void setPropertyFormat(String propertyFormat) {
        this.propertyFormat = propertyFormat;
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
}