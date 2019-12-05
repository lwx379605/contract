package com.lmc.shopleasing.security;

import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.util.JwtTokenUtil;
import com.lmc.shopleasing.util.ResolveIpUtil;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RestLogoutSuccessHandler implements LogoutSuccessHandler {

    protected Logger logger=LoggerFactory.getLogger(getClass());

    @Value("${jwt.header}")
    private String tokenHeader;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CacheManager cacheManager;


    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                Authentication authentication) throws IOException,
                                                               ServletException {
        String ipAddress = ResolveIpUtil.getIpAddress(request);
        String token = response.getHeader(this.tokenHeader);
        if(token != null){
            String username = jwtTokenUtil.getUserNameFromToken(token);
            Cache jwtCache = cacheManager.getCache("jwt");
            if(username!=null ){
                if(jwtCache.isKeyInCache(username)){
                    jwtCache.remove(username);
                }
                logger.info("用户【"+username+"】退出登录成功，注销地址为："+ipAddress);
            }
        }
        Results.ok(response,"退出登录成功");
        response.flushBuffer();
    }

}
