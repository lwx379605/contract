/*
 * Copyright 2005-2017 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lmc.shopleasing.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.groups.Default;
import java.io.Serializable;
import java.util.Date;

/**
 * Entity - 基类
 * 
 * @author lmc
 */
public abstract class BaseEntity<ID extends Serializable> implements Serializable {

	private static final long serialVersionUID = -67188388306700736L;

	/**
	 * "ID"属性名称
	 */
	public static final String ID_PROPERTY_NAME = "id";

	/**
	 * "创建日期"属性名称
	 */
	public static final String CREATED_DATE_PROPERTY_NAME = "createdDate";

	/**
	 * "最后修改日期"属性名称
	 */
	public static final String LAST_MODIFIED_DATE_PROPERTY_NAME = "lastModifiedDate";

	/**
	 * "版本"属性名称
	 */
	public static final String VERSION_PROPERTY_NAME = "version";

	/**
	 * 保存验证组
	 */
	public interface Save extends Default {

	}

	/**
	 * 更新验证组
	 */
	public interface Update extends Default {

	}

	/**
	 * 基础视图
	 */
	public interface BaseView {

	}

	/**
	 * ID
	 */
	@JsonView(BaseView.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ID id;

	/**
	 * 创建日期
	 */
	//@CreatedDate
	@JsonView(BaseView.class)
	@Column(name="create_date",nullable = false, updatable = false)
	private Date createdDate;

	/**
	 * 最后修改日期
	 */
//	@LastModifiedDate
	@Column(name="update_date",nullable = false)
	private Date updateDate;

//	/**
//	 * 版本
//	 */
//	@Version
//	@Column(nullable = false)
//	private Long version;

	/**
	 * 获取ID
	 * 
	 * @return ID
	 */
	public ID getId() {
		return id;
	}

	/**
	 * 设置ID
	 * 
	 * @param id
	 *            ID
	 */
	public void setId(ID id) {
		this.id = id;
	}

	/**
	 * 获取创建日期
	 * 
	 * @return 创建日期
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * 设置创建日期
	 * 
	 * @param createdDate
	 *            创建日期
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * 获取最后修改日期
	 * 
	 * @return 最后修改日期
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 设置最后修改日期
	 * 
	 * @param updateDate
	 *            最后修改日期
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

//	/**
//	 * 获取版本
//	 *
//	 * @return 版本
//	 */
//	public Long getVersion() {
//		return version;
//	}
//
//	/**
//	 * 设置版本
//	 *
//	 * @param version
//	 *            版本
//	 */
//	public void setVersion(Long version) {
//		this.version = version;
//	}

	/**
	 * 判断是否为新建对象
	 * 
	 * @return 是否为新建对象
	 */
	@JsonIgnore
	@Transient
	public boolean isNew() {
		return getId() == null;
	}

	/**
	 * 重写toString方法
	 * 
	 * @return 字符串
	 */
	@Override
	public String toString() {
		return String.format("Entity of type %s with id: %s", getClass().getName(), getId());
	}

	/**
	 * 重写equals方法
	 * 
	 * @param obj
	 *            对象
	 * @return 是否相等
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!BaseEntity.class.isAssignableFrom(obj.getClass())) {
			return false;
		}
		BaseEntity<?> other = (BaseEntity<?>) obj;
		return getId() != null ? getId().equals(other.getId()) : false;
	}

	/**
	 * 重写hashCode方法
	 * 
	 * @return HashCode
	 */
	@Override
	public int hashCode() {
		int hashCode = 17;
		hashCode += getId() != null ? getId().hashCode() * 31 : 0;
		return hashCode;
	}

}