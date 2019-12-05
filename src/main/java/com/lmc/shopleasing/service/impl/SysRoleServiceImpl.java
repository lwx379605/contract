package com.lmc.shopleasing.service.impl;

import com.lmc.shopleasing.dao.SysRoleMapper;
import com.lmc.shopleasing.entity.SysRole;
import com.lmc.shopleasing.service.SysRoleService;
import com.lmc.shopleasing.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by lmc on 2019/11/02.
 */
@Service
@Transactional
public class SysRoleServiceImpl extends AbstractService<SysRole> implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

}
