package com.lmc.shopleasing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmc.shopleasing.entity.SysRole;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.service.SysRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
* Created by lmc on 2019/11/02.
*/
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends BaseController{
    @Resource
    private SysRoleService sysRoleService;

    @PostMapping("/add")
    public ResponseEntity add(SysRole sysRole) {
        sysRole.setCreatedDate(new Date());
        sysRole.setUpdateDate(new Date());
        sysRole.setUseable(true);
        sysRole.setIsSys("0");
        sysRoleService.save(sysRole);
        return Results.OK;
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestParam Integer[] ids) {
        if (ids != null) {
            for (Integer id : ids) {
                SysRole sysRole = sysRoleService.findById(id);
                if (sysRole != null && StringUtils.equals("1",sysRole.getIsSys())) {
                    return Results.badRequest("系统角色["+sysRole.getName()+"]不允许删除");
                }
            }
            sysRoleService.deleteByIds(StringUtils.join(ids,","));
        }
        return Results.OK;
    }

    @PostMapping("/update")
    public ResponseEntity update(SysRole sysRole) {
        sysRole.setIsSys(null);
        sysRoleService.update(sysRole);
        return Results.OK;
    }

    @PostMapping("/detail")
    public ResponseEntity detail(@RequestParam Integer id) {
        SysRole sysRole = sysRoleService.findById(id);
        return Results.success(sysRole);
    }

    @PostMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysRole> list = sysRoleService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return Results.success(pageInfo);
    }
}
