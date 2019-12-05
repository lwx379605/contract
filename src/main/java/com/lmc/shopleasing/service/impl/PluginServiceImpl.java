package com.lmc.shopleasing.service.impl;

import com.lmc.shopleasing.plugin.StoragePlugin;
import com.lmc.shopleasing.service.PluginService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Service - 插件
 * 
 * @author lmc
 */
@Service
public class PluginServiceImpl implements PluginService {


	@Autowired
	private List<StoragePlugin> storagePlugins = new ArrayList<>();

	@Autowired
	private Map<String, StoragePlugin> storagePluginMap = new HashMap<>();


	public List<StoragePlugin> getStoragePlugins() {
		Collections.sort(storagePlugins);
		return storagePlugins;
	}

	public List<StoragePlugin> getStoragePlugins(final boolean isEnabled) {
		List<StoragePlugin> result = new ArrayList<>();
		CollectionUtils.select(storagePlugins, new Predicate() {
			public boolean evaluate(Object object) {
				StoragePlugin storagePlugin = (StoragePlugin) object;
				return storagePlugin.getIsEnabled() == isEnabled;
			}
		}, result);
		Collections.sort(result);
		return result;
	}

	public StoragePlugin getStoragePlugin(String id) {
		return storagePluginMap.get(id);
	}

}