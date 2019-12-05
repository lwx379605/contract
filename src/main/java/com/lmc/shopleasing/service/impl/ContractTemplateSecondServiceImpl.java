package com.lmc.shopleasing.service.impl;

import com.lmc.shopleasing.dao.ContractTemplateSecondMapper;
import com.lmc.shopleasing.entity.ContractTemplateSecond;
import com.lmc.shopleasing.service.ContractTemplateSecondService;
import com.lmc.shopleasing.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by lmc on 2019/11/24.
 */
@Service
@Transactional
public class ContractTemplateSecondServiceImpl extends AbstractService<ContractTemplateSecond> implements ContractTemplateSecondService {
    @Resource
    private ContractTemplateSecondMapper sContractTemplateSecondMapper;

}
