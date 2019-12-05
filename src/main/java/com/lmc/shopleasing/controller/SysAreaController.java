package com.lmc.shopleasing.controller;

import com.github.pagehelper.PageHelper;
import com.lmc.shopleasing.entity.SysArea;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.service.SysAreaService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
* Created by lmc on 2019/11/07.
*/
@RestController
@RequestMapping("/sys/area")
public class SysAreaController {

    @Resource
    private SysAreaService sysAreaService;

    /**
     * 地区
     */
    @Secured("abc")
    @GetMapping
    public ResponseEntity index(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, Integer parentId) {
        PageHelper.startPage(page, size);
        List<Map<String, Object>> data = new ArrayList<>();
        SysArea parent = sysAreaService.findById(parentId);
        Collection<SysArea> areas = parent != null ? sysAreaService.findChildren(parent,false) : sysAreaService.findRoots();
        for (SysArea area : areas) {
            Map<String, Object> item = new HashMap<>();
            item.put("name", area.getName());
            item.put("id", area.getId());
            data.add(item);
        }
        return Results.success(data);
    }
}
