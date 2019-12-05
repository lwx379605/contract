package com.lmc.shopleasing.controller;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.entity.SysPluginConfig;
import com.lmc.shopleasing.service.SysPluginConfigService;

import org.springframework.http.ResponseEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by lmc on 2019/11/03.
*/
@RestController
@RequestMapping("/sys/plugin/config")
public class SysPluginConfigController {
    @Resource
    private SysPluginConfigService sysPluginConfigService;

    @PostMapping("/add")
    public ResponseEntity add(SysPluginConfig sysPluginConfig) {
        Map map = new HashMap<>();
        map.put("name","1");
        map.put("age","2");
        sysPluginConfig.setAttributes(map);
        sysPluginConfigService.save(sysPluginConfig);
        return Results.OK;
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestParam Integer id) {
        sysPluginConfigService.deleteById(id);
        return Results.OK;
    }

    @PostMapping("/update")
    public ResponseEntity update(SysPluginConfig sysPluginConfig) {
        sysPluginConfigService.update(sysPluginConfig);
        return Results.OK;
    }

    @PostMapping("/detail")
    public ResponseEntity detail(@RequestParam Integer id) {
        SysPluginConfig sysPluginConfig = sysPluginConfigService.findById(id);
        return Results.success(sysPluginConfig);
    }

    @PostMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysPluginConfig> list = sysPluginConfigService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return Results.success(pageInfo);
    }
}
