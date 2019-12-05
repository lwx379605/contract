package com.lmc.shopleasing.configurer;

import com.lmc.shopleasing.captcha.CaptchaFilter;
import com.lmc.shopleasing.filter.JwtAuthenticationFilter;
import com.lmc.shopleasing.global.Setting;
import com.lmc.shopleasing.security.*;
import com.lmc.shopleasing.service.CaptchaService;
import com.lmc.shopleasing.service.SysUserService;
import com.lmc.shopleasing.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.cache.EhCacheBasedUserCache;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.annotation.Resource;

/**
 * @author lmc
 */
@EnableGlobalAuthentication
@EnableWebSecurity
@Slf4j
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private SysUserService userDetailsService;

    @Resource
    private CaptchaService captchaService;

    @Resource
    private  JwtAuthenticationFilter jwtAuthenticationFilter;

    @Resource
    private LogoutSuccessHandler restLogoutSuccessHandler;

    @Resource
    private AuthenticationSuccessHandler successAuthenticationHandler;

    /**
     * security检验忽略的请求，比如静态资源不需要登录的可在本处配置
     * @param web
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/*.html","/*.css","/*.js","/templates/**", "/static/**","/webapi/**","/webjars/**","/v2/api-docs",//swagger api json
                "/swagger-resources/**",//用来获取支持的动作
                "/swagger-ui.html","/common/**","/druid/**");//
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
        CaptchaFilter captchaFilter = new CaptchaFilter();
        captchaFilter.setCaptchaType(Setting.CaptchaType.memberLogin);
        captchaFilter.setCaptchaService(captchaService);
        http.addFilterBefore(captchaFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginProcessingUrl("/login").successHandler(successAuthenticationHandler)
                .failureHandler(new FailureAuthenticationHandler())
                .and().logout().logoutUrl("/logout").logoutSuccessHandler(restLogoutSuccessHandler).invalidateHttpSession(true)
                .and().authorizeRequests().antMatchers("/upload/**").permitAll()
                .and().authorizeRequests().anyRequest().authenticated() //其它的请求要求必须有身份认证
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().csrf().disable().cors().disable().headers().cacheControl();
                /*requireCsrfProtectionMatcher(new RequestMatcher() {
                    @Override
                    public boolean matches(HttpServletRequest httpServletRequest) {
                        String servletPath = httpServletRequest.getServletPath();
                        if (servletPath.contains("/druid")) {
                            return false;
                        }
                        return true;
                 } );*/
        //添加自定义异常入口，处理accessdeine异常
        http.exceptionHandling().authenticationEntryPoint(new AuthenticationProcessingFilterEntryPoint())
                .accessDeniedHandler(new AccessDeniedHandlerImpl());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        auth.eraseCredentials(false);
    }

    //密码加密配置
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

    @Bean
    public  UserCache  userCache(CacheManager cacheManager){
        EhCacheBasedUserCache userCache = new EhCacheBasedUserCache();
        userCache.setCache(cacheManager.getCache("userDetails"));
        return userCache;
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}