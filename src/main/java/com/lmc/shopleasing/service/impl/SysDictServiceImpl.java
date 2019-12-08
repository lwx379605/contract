package com.lmc.shopleasing.service.impl;

import com.lmc.shopleasing.dao.SysDictMapper;
import com.lmc.shopleasing.entity.SysDict;
import com.lmc.shopleasing.service.SysDictService;
import com.lmc.shopleasing.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by lmc on 2019/12/08.
 */
@Service
@Transactional
public class SysDictServiceImpl extends AbstractService<SysDict> implements SysDictService {
    @Resource
    private SysDictMapper sysDictMapper;

}
