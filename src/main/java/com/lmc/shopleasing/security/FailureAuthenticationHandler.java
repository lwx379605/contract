package com.lmc.shopleasing.security;

import com.lmc.shopleasing.global.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FailureAuthenticationHandler implements AuthenticationFailureHandler {
    
    protected Logger logger=LoggerFactory.getLogger(getClass());
    
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        logger.info("登录失败："+e.getMessage());
        if (e instanceof UsernameNotFoundException ) {
            Results.unauthorized(httpServletResponse,"用户名输入错误，登录失败!");
        } else if (e instanceof BadCredentialsException) {
            Results.unauthorized(httpServletResponse,"密码输入错误，登录失败!");
        } else if (e instanceof DisabledException) {
            Results.unauthorized(httpServletResponse,"账户被禁用，登录失败，请联系管理员!");
        }else {
            Results.unauthorized(httpServletResponse,"登录异常");
        }
        httpServletResponse.flushBuffer();
    }
}