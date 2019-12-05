package com.lmc.shopleasing.service.impl;

import com.lmc.shopleasing.dao.SysUserRoleMapper;
import com.lmc.shopleasing.entity.SysUserRole;
import com.lmc.shopleasing.service.SysUserRoleService;
import com.lmc.shopleasing.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by lmc on 2019/11/05.
 */
@Service
@Transactional
public class SysUserRoleServiceImpl extends AbstractService<SysUserRole> implements SysUserRoleService {
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

}
