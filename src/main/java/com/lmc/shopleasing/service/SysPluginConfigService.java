package com.lmc.shopleasing.service;


import com.lmc.shopleasing.core.Service;
import com.lmc.shopleasing.entity.SysPluginConfig;

/**
 * Service - 插件配置
 * 
 * @author lmc
 */
public interface SysPluginConfigService extends Service<SysPluginConfig> {

	/**
	 * 判断插件ID是否存在
	 * 
	 * @param pluginId
	 *            插件ID
	 * @return 插件ID是否存在
	 */
	boolean pluginIdExists(String pluginId);

	/**
	 * 根据插件ID查找插件配置
	 * 
	 * @param pluginId
	 *            插件ID
	 * @return 插件配置，若不存在则返回null
	 */
	SysPluginConfig findByPluginId(String pluginId);

	/**
	 * 根据插件ID删除插件配置
	 * 
	 * @param pluginId
	 *            插件ID
	 */
	void deleteByPluginId(String pluginId);

}