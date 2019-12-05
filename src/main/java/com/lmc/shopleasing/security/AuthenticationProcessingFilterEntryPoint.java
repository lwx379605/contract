package com.lmc.shopleasing.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.lmc.shopleasing.global.Results;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class AuthenticationProcessingFilterEntryPoint implements AuthenticationEntryPoint, InitializingBean {

    protected Logger logger=LoggerFactory.getLogger(getClass());

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException,
            ServletException {
        logger.warn("没有登录权限",authException.getMessage());
        if (!response.isCommitted()) {
            Results.unauthorized(response,"没有访问权限,请登录!");
            response.flushBuffer();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}