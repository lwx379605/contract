//package com.lmc.shopleasing.configurer;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//
///**
// * 资源服务器
// */
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
//
//	private static final String RESOURCE_ID = "my_rest_api";
//
//	@Override
//	public void configure(ResourceServerSecurityConfigurer resources) {
//		resources.resourceId(RESOURCE_ID).stateless(false);
//	}
//
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.
//		anonymous().disable()
//		.requestMatchers().antMatchers("/user*/**")
//		.and().authorizeRequests()
//		.antMatchers("/user*/**").permitAll()
//		.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
//	}
//
//}