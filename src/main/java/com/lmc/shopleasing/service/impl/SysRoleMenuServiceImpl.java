package com.lmc.shopleasing.service.impl;

import com.lmc.shopleasing.dao.SysRoleMenuMapper;
import com.lmc.shopleasing.entity.SysRoleMenu;
import com.lmc.shopleasing.service.SysRoleMenuService;
import com.lmc.shopleasing.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by lmc on 2019/11/05.
 */
@Service
@Transactional
public class SysRoleMenuServiceImpl extends AbstractService<SysRoleMenu> implements SysRoleMenuService {
    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

}
