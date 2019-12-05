/*
 * Copyright 2005-2017 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lmc.shopleasing.captcha;

import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.global.Setting;
import com.lmc.shopleasing.service.CaptchaService;
import com.lmc.shopleasing.util.SystemUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Captcha - 验证码过滤器
 * 
 * @author lmc
 */
public class CaptchaFilter extends OncePerRequestFilter {

	public CaptchaFilter() {
		this.captchaRequestMatcher = new AntPathRequestMatcher("/login");
	}

	private RequestMatcher captchaRequestMatcher;
	/**
	 * 默认无需防护的请求方法
	 */
	private static final String[] DEFAULT_NOT_REQUIRE_PROTECTION_REQUEST_METHODS = new String[] { "GET", "HEAD", "TRACE", "OPTIONS" };

	/**
	 * "验证码ID"参数名称
	 */
	private static final String CAPTCHA_ID_PARAMETER_NAME = "captchaId";

	/**
	 * "验证码"参数名称
	 */
	private static final String CAPTCHA_PARAMETER_NAME = "captcha";

	/**
	 * 验证码类型
	 */
	private Setting.CaptchaType captchaType;

	/**
	 * 无需防护的请求方法
	 */
	private String[] notRequireProtectionRequestMethods = DEFAULT_NOT_REQUIRE_PROTECTION_REQUEST_METHODS;

	private CaptchaService captchaService;

	/**
	 * 执行
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletRequest
	 * @param filterChain
	 *            FilterChain
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		if(requiresCheckCaptcha(request,response)){
			Setting setting = SystemUtils.getSetting();
			String captchaId = request.getParameter(CAPTCHA_ID_PARAMETER_NAME);
			String captcha = request.getParameter(CAPTCHA_PARAMETER_NAME);
			if (ArrayUtils.contains(setting.getCaptchaTypes(), getCaptchaType()) && !containsIgnoreCase(getNotRequireProtectionRequestMethods(), request.getMethod()) && !captchaService.isValid(captchaId, captcha)) {
				Results.unprocessableEntity(response, "common.message.ncorrectCaptcha");
				response.flushBuffer();
				return ;
			}
		}
		filterChain.doFilter(request, response);
	}

	/**
	 * 判断数组是否包含字符串
	 * 
	 * @param array
	 *            数组
	 * @param searchStr
	 *            查找字符串(忽略大小写)
	 * @return 是否包含字符串
	 */
	private boolean containsIgnoreCase(String[] array, String searchStr) {
		if (ArrayUtils.isNotEmpty(array) && searchStr != null) {
			for (String str : array) {
				if (StringUtils.equalsIgnoreCase(str, searchStr)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 获取验证码类型
	 * 
	 * @return 验证码类型
	 */
	public Setting.CaptchaType getCaptchaType() {
		return captchaType;
	}

	/**
	 * 设置验证码类型
	 *
	 * @param captchaType
	 *            验证码类型
	 */
	public void setCaptchaType(Setting.CaptchaType captchaType) {
		this.captchaType = captchaType;
	}

	/**
	 * 获取无需防护的请求方法
	 *
	 * @return 无需防护的请求方法
	 */
	public String[] getNotRequireProtectionRequestMethods() {
		return notRequireProtectionRequestMethods;
	}

	/**
	 * 设置无需防护的请求方法
	 *
	 * @param notRequireProtectionRequestMethods
	 *            无需防护的请求方法
	 */
	public void setNotRequireProtectionRequestMethods(String[] notRequireProtectionRequestMethods) {
		this.notRequireProtectionRequestMethods = notRequireProtectionRequestMethods;
	}

	public CaptchaService getCaptchaService() {
		return captchaService;
	}

	public void setCaptchaService(CaptchaService captchaService) {
		this.captchaService = captchaService;
	}

	protected boolean requiresCheckCaptcha(HttpServletRequest request, HttpServletResponse response) {
		return this.captchaRequestMatcher.matches(request);
	}
}