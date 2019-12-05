package com.lmc.shopleasing.service.impl;

import com.lmc.shopleasing.dao.ContractTemplateColdStorageMapper;
import com.lmc.shopleasing.entity.ContractTemplateColdStorage;
import com.lmc.shopleasing.service.ContractTemplateColdStorageService;
import com.lmc.shopleasing.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by lmc on 2019/11/24.
 */
@Service
@Transactional
public class ContractTemplateColdStorageServiceImpl extends AbstractService<ContractTemplateColdStorage> implements ContractTemplateColdStorageService {
    @Resource
    private ContractTemplateColdStorageMapper sContractTemplateColdStorageMapper;

}
