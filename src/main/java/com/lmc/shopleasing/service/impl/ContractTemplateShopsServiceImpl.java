package com.lmc.shopleasing.service.impl;

import com.lmc.shopleasing.dao.ContractTemplateShopsMapper;
import com.lmc.shopleasing.entity.ContractTemplateShops;
import com.lmc.shopleasing.service.ContractTemplateShopsService;
import com.lmc.shopleasing.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by lmc on 2019/11/24.
 */
@Service
@Transactional
public class ContractTemplateShopsServiceImpl extends AbstractService<ContractTemplateShops> implements ContractTemplateShopsService {
    @Resource
    private ContractTemplateShopsMapper sContractTemplateShopsMapper;

}
