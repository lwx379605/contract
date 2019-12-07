package com.lmc.shopleasing.controller.common;

import com.lmc.shopleasing.service.CaptchaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller - 验证码
 * 
 * @author lmc
 */
@RestController
@RequestMapping("/common/captcha")
public class CaptchaController {

	@Resource
	private CaptchaService captchaService;

	/**
	 * 校验码
	 */
	@GetMapping(path = "/code")
	public String captcha(String captchaId, HttpServletResponse response) {
		String code = captchaService.createCode(captchaId);
		System.out.println(code);
		return code;
	}

}