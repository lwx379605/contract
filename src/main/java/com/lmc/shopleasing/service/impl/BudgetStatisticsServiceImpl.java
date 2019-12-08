package com.lmc.shopleasing.service.impl;

import com.lmc.shopleasing.dao.BudgetStatisticsMapper;
import com.lmc.shopleasing.entity.BudgetStatistics;
import com.lmc.shopleasing.service.BudgetStatisticsService;
import com.lmc.shopleasing.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by lmc on 2019/12/08.
 */
@Service
@Transactional
public class BudgetStatisticsServiceImpl extends AbstractService<BudgetStatistics> implements BudgetStatisticsService {
    @Resource
    private BudgetStatisticsMapper sBudgetStatisticsMapper;

}
