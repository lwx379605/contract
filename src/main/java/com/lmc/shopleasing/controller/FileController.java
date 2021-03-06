package com.lmc.shopleasing.controller;

import java.util.HashMap;
import java.util.Map;


import com.lmc.shopleasing.global.FileType;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.service.FileService;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * Controller - 文件
 * 
 * @author lmc
 */
@RestController
@RequestMapping("/file")
public class FileController extends BaseController {

	@Resource
	private FileService fileService;

	/**
	 * 上传
	 */
	@PostMapping("/upload")
	public ResponseEntity upload(FileType fileType, MultipartFile file) {
		if (fileType == null || file == null || file.isEmpty()) {
			return Results.UNPROCESSABLE_ENTITY;
		}
		if (!fileService.isValid(fileType, file)) {
			return Results.unprocessableEntity("file.upload.invalid");
		}
		String url = fileService.upload(fileType, file, false);
		if (StringUtils.isEmpty(url)) {
			return Results.unprocessableEntity("file.upload.error");
		}
		Map<String, Object> data = new HashMap<>();
		data.put("url", url);
		return Results.success(data);
	}

}