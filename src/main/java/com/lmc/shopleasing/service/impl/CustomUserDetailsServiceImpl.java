package com.lmc.shopleasing.service.impl;

import com.lmc.shopleasing.entity.CustomUserDetails;
import com.lmc.shopleasing.entity.SysUser;
import com.lmc.shopleasing.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：自定义UserDetailsService，从数据库读取用户信息，实现登录验证
 *
 * @Author lmc
 **/
@Component
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired(required = true)
    private UserCache userCache;

    @Resource
    private SysUserService userService;

    /**
     * 认证过程中 - 根据登录信息获取用户详细信息
     *
     * @param userName 登录用户输入的用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDetails user = this.userCache.getUserFromCache(userName);
        if (user == null) {
            //根据用户输入的用户信息，查询数据库中已注册用户信息
            SysUser sysUser = userService.findBy("loginName", userName);
            //如果用户不存在直接抛出UsernameNotFoundException异常
            if(sysUser==null){
                throw new UsernameNotFoundException("登录账号为"+userName+"的用户不存在");
            }
            CustomUserDetails userDetails = new CustomUserDetails(sysUser);
            //TODO
            List<GrantedAuthority> authorities = new ArrayList<>();
            userDetails.setAuthorities(authorities);
            this.userCache.putUserInCache(userDetails);
            return userDetails;
        }else{
            return user;
        }
    }
}