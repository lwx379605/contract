package com.lmc.shopleasing.controller;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.entity.SysRoleOffice;
import com.lmc.shopleasing.service.SysRoleOfficeService;

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
* Created by lmc on 2019/11/02.
*/
@RestController
@RequestMapping("/sys/role/office")
public class SysRoleOfficeController extends BaseController{
    @Resource
    private SysRoleOfficeService sysRoleOfficeService;

    @PostMapping("/add")
    public ResponseEntity add(SysRoleOffice sysRoleOffice) {
        sysRoleOfficeService.save(sysRoleOffice);
        return Results.OK;
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestParam Integer id) {
        sysRoleOfficeService.deleteById(id);
        return Results.OK;
    }

    @PostMapping("/update")
    public ResponseEntity update(SysRoleOffice sysRoleOffice) {
        sysRoleOfficeService.update(sysRoleOffice);
        return Results.OK;
    }

    @PostMapping("/detail")
    public ResponseEntity detail(@RequestParam Integer id) {
        SysRoleOffice sysRoleOffice = sysRoleOfficeService.findById(id);
        return Results.success(sysRoleOffice);
    }

    @PostMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysRoleOffice> list = sysRoleOfficeService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return Results.success(pageInfo);
    }
}
