package com.lmc.shopleasing.service.impl;

import com.lmc.shopleasing.dao.BoothMapper;
import com.lmc.shopleasing.dao.ContractLeaseMapper;
import com.lmc.shopleasing.entity.Booth;
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

	@Resource
	private BoothMapper  boothMapper;

	@Override
	public List<ContractLease> findByCondition(Map<String, Object> map) {
		return sContractLeaseMapper.findByCondition(map);
	}

	@Override
	public void save(ContractLease contractLease, Booth booth) {
		sContractLeaseMapper.insert(contractLease);
		boothMapper.updateByPrimaryKey(booth);
	}

	@Override
	public void update(ContractLease contractLease, Booth booth) {
		sContractLeaseMapper.updateByPrimaryKeySelective(contractLease);
		if(booth!=null){
			boothMapper.updateByPrimaryKeySelective(booth);
		}
	}

	@Override
	public ContractLease findContractById(Integer id) {
		return sContractLeaseMapper.findContractById(id);
	}
}
