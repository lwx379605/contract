package com.lmc.shopleasing.util;

import com.lmc.shopleasing.entity.CustomUserDetails;
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

    public static CustomUserDetails getUserDetail(){
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        if(auth==null){
            return null;
        }
        CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
        return user;
    }
}