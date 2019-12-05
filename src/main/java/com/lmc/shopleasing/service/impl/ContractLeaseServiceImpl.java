package com.lmc.shopleasing.service.impl;

import com.lmc.shopleasing.dao.ContractLeaseMapper;
import com.lmc.shopleasing.entity.ContractLease;
import com.lmc.shopleasing.service.ContractLeaseService;
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
public class ContractLeaseServiceImpl extends AbstractService<ContractLease> implements ContractLeaseService {
    @Resource
    private ContractLeaseMapper sContractLeaseMapper;

	@Override
	public List<ContractLease> findByCondition(Map<String, Object> map) {
		return sContractLeaseMapper.findByCondition(map);
	}

}
