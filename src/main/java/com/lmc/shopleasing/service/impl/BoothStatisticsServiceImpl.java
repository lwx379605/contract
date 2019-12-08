package com.lmc.shopleasing.service.impl;

import com.lmc.shopleasing.dao.BoothStatisticsMapper;
import com.lmc.shopleasing.entity.BoothStatistics;
import com.lmc.shopleasing.service.BoothStatisticsService;
import com.lmc.shopleasing.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by lmc on 2019/12/08.
 */
@Service
@Transactional
public class BoothStatisticsServiceImpl extends AbstractService<BoothStatistics> implements BoothStatisticsService {
    @Resource
    private BoothStatisticsMapper sBoothStatisticsMapper;

}
