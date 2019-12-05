package com.lmc.shopleasing.service.impl;

import com.lmc.shopleasing.dao.ContractTemplateWarehouseMapper;
import com.lmc.shopleasing.entity.ContractTemplateWarehouse;
import com.lmc.shopleasing.service.ContractTemplateWarehouseService;
import com.lmc.shopleasing.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by lmc on 2019/11/24.
 */
@Service
@Transactional
public class ContractTemplateWarehouseServiceImpl extends AbstractService<ContractTemplateWarehouse> implements ContractTemplateWarehouseService {
    @Resource
    private ContractTemplateWarehouseMapper sContractTemplateWarehouseMapper;

}
