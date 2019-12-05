package com.lmc.shopleasing.entity;

import com.lmc.shopleasing.core.ServiceException;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 描述：自定义UserDetails，使UserDetails具有SysUser的实体结构
 *
 * @Author lmc
 **/
public class CustomUserDetails extends SysUser implements UserDetails {

    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(SysUser tUser){
        if(null != tUser){
            try {
                BeanUtils.copyProperties(this,tUser);
            } catch (Exception e) {
               throw new ServiceException();
            }
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return getLoginName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return getLoginFlag() && !getDelFlag();
    }

//    @Override
//    public void eraseCredentials() {
//        super.setPassword(null);
//    }
}