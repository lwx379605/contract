package com.lmc.shopleasing.service;

/**
 * Service - 验证码
 * 
 * @author lmc
 */
public interface CaptchaService {

	/**
	 * 验证码验证
	 * 
	 * @param captchaId
	 *            验证码ID
	 * @param captcha
	 *            验证码(忽略大小写)
	 * @return 验证码验证是否通过
	 */
	boolean isValid(String captchaId, String captcha);

	/**
	 * 验证码生成
	 * @param captchaId
	 * @return
	 */
	String createCode(String captchaId);
}