package com.lmc.shopleasing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.lmc.shopleasing.entity.BaseEntity;
import com.lmc.shopleasing.entity.CustomUserDetails;
import com.lmc.shopleasing.entity.SysUser;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.service.SysRoleService;
import com.lmc.shopleasing.service.SysUserService;
import com.lmc.shopleasing.util.SysUserHolder;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
* Created by lmc on 2019/11/02.
*/
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends BaseController{
    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysRoleService sysRoleService;

    /**
     * 保存
     */
    @PostMapping("/add")
    public ResponseEntity save(SysUser sysUser, Integer[] roleIds) {
        Assert.notEmpty(roleIds,"用户未指定角色");
        sysUser.setSysRoles(new HashSet<>(sysRoleService.findByIds(StringUtils.join(roleIds,","))));
        if (sysUserService.userExists(sysUser.getLoginName())) {
            return Results.badRequest("用户名已存在");
        }
        sysUserService.createUser(new CustomUserDetails(sysUser));
        return Results.OK;
    }

    @PostMapping("/exist")
    public ResponseEntity add(String userName) {
        if(StringUtils.isNotEmpty(userName) && sysUserService.userExists(userName)){
            return Results.success(true);
        }else{
            return Results.success(false);
        }
    }


    @PostMapping("/updatePassword")
    public ResponseEntity updatePassword(String oldPassword ,String newPassword) {
        try {
            sysUserService.changePassword(oldPassword, newPassword);
        } catch (BadCredentialsException e) {
            return Results.badRequest("原密码不正确");
        }catch (Exception e) {
            return Results.badRequest("修改密码失败");
        }
        return Results.OK;
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestParam Integer[] ids) {
        sysUserService.deleteByIds(ids);
        return Results.OK;
    }

    @PostMapping("/update")
    public ResponseEntity update(SysUser sysUser, Integer[] roleIds) {
        Assert.notEmpty(roleIds,"用户未指定角色");
        sysUser.setSysRoles(new HashSet<>(sysRoleService.findByIds(StringUtils.join(roleIds,","))));
        sysUserService.updateUser(new CustomUserDetails(sysUser));
        return Results.OK;
    }

    @PostMapping("/detail")
    public ResponseEntity detail(@RequestParam Integer id) {
        SysUser sysUser = sysUserService.findById(id);
        return Results.success(sysUser);
    }

    @PostMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysUser> list = sysUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return Results.success(pageInfo);
    }

    @RequestMapping("/current")
    public ResponseEntity list() {
        return Results.success(SysUserHolder.getUserDetail());
    }
}
