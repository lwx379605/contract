package com.lmc.shopleasing.configurer;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import java.util.ArrayList;
import java.util.List;


/**
 * @author lmc
 */
@Configuration
@ComponentScan(useDefaultFilters = false, basePackages = "com.lmc.shopleasing",
        includeFilters= {@ComponentScan.Filter(classes = {Controller.class, ControllerAdvice.class})})
public class WebMvcConfigurer implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {

    private final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);

    @Value("${json_content_type}")
    private String jsonContentType;

    @Value("${html_content_type}")
    private String htmlContentType;
    
    @Autowired
    private  MessageSource messageSource;

    @Bean
    public LocaleResolver localeResolver() {
        return new FixedLocaleResolver();
    }


    @Override
    public Validator getValidator() {
        return validator();
    }

    
    @Bean
    public LocalValidatorFactoryBean  validator() 
    {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setValidationMessageSource(messageSource);
        return localValidatorFactoryBean;
    }
    
    @Bean
    public MethodValidationPostProcessor getMethodValidationPostProcessor() {
        MethodValidationPostProcessor processor = new MethodValidationPostProcessor();
        processor.setValidator(validator() );
        return processor;
    }
    

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/");
        registry.addResourceHandler("/*.html","/*.css","/*.js","/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
        registry.addResourceHandler("/webapi/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/webapi/");
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/META-INF/resources/webjars/");
        registry.addResourceHandler("/localStorage/**").addResourceLocations("file:C:/shopleasing/localStorage/");
    }

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 1.定义一个converters转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverterExtension();
        // 2.添加fastjson的配置信息，比如: 是否需要格式化返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        // 3.在converter中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);
        // 4.将converter赋值给HttpMessageConverter
        HttpMessageConverter<?> converter = fastConverter;
        // 5.返回HttpMessageConverters对象
        return new HttpMessageConverters(converter);
    }

    public class FastJsonHttpMessageConverterExtension extends FastJsonHttpMessageConverter {
        FastJsonHttpMessageConverterExtension() {
            List<MediaType> mediaTypes = new ArrayList<>();
            mediaTypes.add(MediaType.valueOf(htmlContentType + ";charset=UTF-8"));
            mediaTypes.add(MediaType.valueOf(jsonContentType + ";charset=UTF-8"));
            setSupportedMediaTypes(mediaTypes);
        }
    }

    //解决跨域问题
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**");
//    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*")
                .exposedHeaders("Authorization")
                .allowCredentials(true);
    }


    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //注册拦截器
        //registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/api/**").excludePathPatterns("/api/login","/api/getPublicKey","/api/getRSAEncode");
    }
    
    //统一异常处理
    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {

    }

    @Bean
    public ServletListenerRegistrationBean listenerRegist() {
        ServletListenerRegistrationBean srb = new ServletListenerRegistrationBean();
        srb.setListener(new RequestContextListener());
        return srb;
    }
}
