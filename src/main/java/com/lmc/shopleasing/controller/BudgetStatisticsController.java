package com.lmc.shopleasing.controller;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.entity.BudgetStatistics;
import com.lmc.shopleasing.service.BudgetStatisticsService;

import org.springframework.http.ResponseEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by lmc on 2019/12/08.
*/
@RestController
@RequestMapping("/budget/statistics")
public class BudgetStatisticsController {
    @Resource
    private BudgetStatisticsService budgetStatisticsService;

    @PostMapping("/add")
    public ResponseEntity add(BudgetStatistics budgetStatistics) {
        budgetStatisticsService.save(budgetStatistics);
        return Results.OK;
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestParam Integer id) {
        budgetStatisticsService.deleteById(id);
        return Results.OK;
    }

    @PostMapping("/update")
    public ResponseEntity update(BudgetStatistics budgetStatistics) {
        budgetStatisticsService.update(budgetStatistics);
        return Results.OK;
    }

    @PostMapping("/detail")
    public ResponseEntity detail(@RequestParam Integer id) {
        BudgetStatistics budgetStatistics = budgetStatisticsService.findById(id);
        return Results.success(budgetStatistics);
    }

    @PostMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<BudgetStatistics> list = budgetStatisticsService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return Results.success(pageInfo);
    }
}
