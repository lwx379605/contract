package com.lmc.shopleasing.plugin.localStorage;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import com.lmc.shopleasing.global.Setting;
import com.lmc.shopleasing.plugin.StoragePlugin;
import com.lmc.shopleasing.util.SystemUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Plugin - 本地文件存储
 * 
 * @author lmc
 */
@Component("localStoragePlugin")
public class LocalStoragePlugin extends StoragePlugin {

	@Autowired
	private ServletContext servletContext;

	@Override
	public String getName() {
		return "本地文件存储";
	}

	@Override
	public void upload(String path, File file, String contentType) {
		File destFile = new File(servletContext.getRealPath(path));
		try {
			FileUtils.moveFile(file, destFile);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public String getUrl(String path) {
		Setting setting = SystemUtils.getSetting();
		return setting.getSiteUrl() + path;
	}

}