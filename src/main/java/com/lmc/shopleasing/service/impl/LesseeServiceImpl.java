package com.lmc.shopleasing.service.impl;

import com.lmc.shopleasing.dao.LesseeMapper;
import com.lmc.shopleasing.entity.Lessee;
import com.lmc.shopleasing.service.LesseeService;
import com.lmc.shopleasing.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


/**
 * Created by lmc on 2019/11/09.
 */
@Service
@Transactional
public class LesseeServiceImpl extends AbstractService<Lessee> implements LesseeService {
    @Resource
    private LesseeMapper sLesseeMapper;

}
