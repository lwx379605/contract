package com.lmc.shopleasing.security;

import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.util.JwtTokenUtil;
import com.lmc.shopleasing.util.ResolveIpUtil;
import com.lmc.shopleasing.util.SpringUtils;
import lombok.extern.log4j.Log4j;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class SuccessAuthenticationHandler implements AuthenticationSuccessHandler {

    protected Logger logger=LoggerFactory.getLogger(getClass());

    @Autowired
    private  CacheManager cacheManager;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtTokenUtil.generateToken(userDetails);
        Cache cache = cacheManager.getCache("jwt");
        cache.put(new Element(userDetails.getUsername(), userDetails));
        String ipAddress = ResolveIpUtil.getIpAddress(httpServletRequest);
        logger.info("用户【"+userDetails.getUsername()+"】登录成功，登录地址为："+ipAddress);
        httpServletResponse.setHeader("Authorization",token);
        Results.ok(httpServletResponse,"登录成功");
        httpServletResponse.flushBuffer();
    }
}