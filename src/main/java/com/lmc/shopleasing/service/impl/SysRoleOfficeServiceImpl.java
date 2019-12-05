package com.lmc.shopleasing.service.impl;

import com.lmc.shopleasing.dao.SysRoleOfficeMapper;
import com.lmc.shopleasing.entity.SysRoleOffice;
import com.lmc.shopleasing.service.SysRoleOfficeService;
import com.lmc.shopleasing.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by lmc on 2019/11/02.
 */
@Service
@Transactional
public class SysRoleOfficeServiceImpl extends AbstractService<SysRoleOffice> implements SysRoleOfficeService {
    @Resource
    private SysRoleOfficeMapper sysRoleOfficeMapper;

}
