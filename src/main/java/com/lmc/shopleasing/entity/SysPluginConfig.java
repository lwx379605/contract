package com.lmc.shopleasing.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;
import javax.validation.constraints.Min;

import com.lmc.shopleasing.global.MapTypeHander;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.CompareToBuilder;
import tk.mybatis.mapper.annotation.ColumnType;


/**
 * Entity - 插件配置
 * 
 * @author lmc
 */
@Table(name = "sys_plugin_config")
public class SysPluginConfig implements Comparable<SysPluginConfig> ,Serializable {

	private static final long serialVersionUID = -4357367409438384806L;

	/**
	 * 编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 插件ID
	 */
	@Column(name="plugin_id",nullable = false, updatable = false, unique = true)
	private String pluginId;

	/**
	 * 是否启用
	 */
	@Column(name="is_enabled",nullable = false)
	private Boolean isEnabled;

	/**
	 * 获取编号
	 *
	 * @return id - 编号
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置编号
	 *
	 * @param id 编号
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 属性
	 */
	@ColumnType(typeHandler= MapTypeHander.class)
	@Column(length = 4000)
	private Map<String, String> attributes = new HashMap<>();

	/**
	 * 获取插件ID
	 * 
	 * @return 插件ID
	 */
	public String getPluginId() {
		return pluginId;
	}

	/**
	 * 设置插件ID
	 * 
	 * @param pluginId
	 *            插件ID
	 */
	public void setPluginId(String pluginId) {
		this.pluginId = pluginId;
	}

	/**
	 * 获取是否启用
	 * 
	 * @return 是否启用
	 */
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	/**
	 * 设置是否启用
	 * 
	 * @param isEnabled
	 *            是否启用
	 */
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/**
	 * 获取属性
	 * 
	 * @return 属性
	 */
	public Map<String, String> getAttributes() {
		return attributes;
	}

	/**
	 * 设置属性
	 * 
	 * @param attributes
	 *            属性
	 */
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	/**
	 * 获取属性值
	 * 
	 * @param name
	 *            属性名称
	 * @return 属性值
	 */
	@Transient
	public String getAttribute(String name) {
		if (StringUtils.isEmpty(name)) {
			return null;
		}
		return getAttributes() != null ? getAttributes().get(name) : null;
	}

	/**
	 * 排序
	 */
	@Min(0)
	@Column(name = "orders")
	private Integer order;

	/**
	 * 获取排序
	 *
	 * @return 排序
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * 设置排序
	 *
	 * @param order
	 *            排序
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}

	public int compareTo(SysPluginConfig orderEntity) {
		if (orderEntity == null) {
			return 1;
		}
		return new CompareToBuilder().append(getOrder(), orderEntity.getOrder()).toComparison();
	}

}