package com.lmc.shopleasing.configurer;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.util.Properties;

@Configuration
public class BeanConfigurer{

	@Value("${captcha.imageWidth}")
	private String imageWidth;

	@Value("${captcha.imageHeight}")
	private String imageHeight;

	@Value("${captcha.charString}")
	private String charString;

	@Value("${captcha.charLength}")
	private String charLength;

	@Value("${captcha.charSpace}")
	private String charSpace;

	@Value("${captcha.fontColor}")
	private String fontColor;

	@Value("${captcha.fontSize}")
	private String fontSize;

	@Bean
	public Producer captchaProducer(){
		Properties properties = new Properties();
		properties.put("kaptcha.border","no");
		properties.put("kaptcha.image.width",imageWidth);
		properties.put("kaptcha.image.height",imageHeight);
		properties.put("kaptcha.noise.impl","com.google.code.kaptcha.impl.NoNoise");
		properties.put("kaptcha.obscurificator.impl","com.google.code.kaptcha.impl.ShadowGimpy");
		properties.put("kaptcha.background.impl","com.google.code.kaptcha.impl.NoNoise");
		properties.put("kaptcha.noise.impl","com.lmc.shopleasing.captcha.CaptchaBackground.class");
		properties.put("kaptcha.background.imagePath","classpath:captcha/");
		properties.put("kaptcha.textproducer.char.string",charString);
		properties.put("kaptcha.textproducer.char.length",charLength);
		properties.put("kaptcha.textproducer.char.space",charSpace);
		properties.put("kaptcha.textproducer.font.color",fontColor);
		properties.put("kaptcha.textproducer.font.size",fontSize);

		Config config = new Config(properties);
		DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
		defaultKaptcha.setConfig(config);
		return defaultKaptcha;
	}

}
