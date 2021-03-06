package com.lmc.shopleasing.controller;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.entity.SysUserRole;
import com.lmc.shopleasing.service.SysUserRoleService;

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
@RequestMapping("/sys/user/role")
public class SysUserRoleController extends BaseController{
    @Resource
    private SysUserRoleService sysUserRoleService;

    @PostMapping("/add")
    public ResponseEntity add(SysUserRole sysUserRole) {
        sysUserRoleService.save(sysUserRole);
        return Results.OK;
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestParam Integer id) {
        sysUserRoleService.deleteById(id);
        return Results.OK;
    }

    @PostMapping("/update")
    public ResponseEntity update(SysUserRole sysUserRole) {
        sysUserRoleService.update(sysUserRole);
        return Results.OK;
    }

    @PostMapping("/detail")
    public ResponseEntity detail(@RequestParam Integer id) {
        SysUserRole sysUserRole = sysUserRoleService.findById(id);
        return Results.success(sysUserRole);
    }

    @PostMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysUserRole> list = sysUserRoleService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return Results.success(pageInfo);
    }
}
