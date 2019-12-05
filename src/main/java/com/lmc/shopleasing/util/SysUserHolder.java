package com.lmc.shopleasing.util;

import com.lmc.shopleasing.entity.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 描述：
 *
 * @Author lmc
 **/
public class SysUserHolder {

    public static SysUser getUserDetail(){
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        SysUser user = (SysUser) auth.getPrincipal();
        return user;
    }
}