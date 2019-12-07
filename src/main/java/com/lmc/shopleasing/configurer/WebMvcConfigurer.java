package com.lmc.shopleasing.configurer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import java.util.Arrays;
import java.util.List;


/**
 * @author lmc
 */
@EnableWebMvc
@Configuration
@ComponentScan(useDefaultFilters = false, basePackages = "com.lmc.shopleasing",
        includeFilters= {@ComponentScan.Filter(classes = {Controller.class, ControllerAdvice.class})})
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

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
        registry.addResourceHandler("/upload/**").addResourceLocations("/upload/");
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        jackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.valueOf(jsonContentType),MediaType.valueOf(htmlContentType)));
        converters.add(jackson2HttpMessageConverter);
    }

    //解决跨域问题
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**");
//    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "TRACE")
                .allowCredentials(true);
    }


    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //注册拦截器
        //registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/api/**").excludePathPatterns("/api/login","/api/getPublicKey","/api/getRSAEncode");
        super.addInterceptors(registry);
    }
    
    //统一异常处理
    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        super.extendHandlerExceptionResolvers(exceptionResolvers);
    }

}
