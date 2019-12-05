package com.lmc.shopleasing.dao;

import com.lmc.shopleasing.core.Mapper;
import com.lmc.shopleasing.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuMapper extends Mapper<SysMenu> {

   List<SysMenu>   findByLoginName(@Param("loginName") String loginName);
}