package com.lmc.shopleasing.dao;

import com.lmc.shopleasing.core.Mapper;
import com.lmc.shopleasing.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysUserMapper extends Mapper<SysUser> {

   int  updatePassword(@Param("loginName") String loginName, @Param("password") String password) ;
}