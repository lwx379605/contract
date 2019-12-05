package com.lmc.shopleasing.controller;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.entity.SysMenu;
import com.lmc.shopleasing.service.SysMenuService;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
* Created by lmc on 2019/11/02.
*/
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends BaseController{

    @Resource
    private SysMenuService sysMenuService;

    @PostMapping(value={"/",""})
    public ResponseEntity index(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysMenu> list = sysMenuService.findByUser(false);
        PageInfo pageInfo = new PageInfo(list);
        return Results.success(pageInfo);
    }

    @PostMapping("/add")
    public ResponseEntity add(SysMenu sysMenu) {
        sysMenuService.save(sysMenu);
        return Results.OK;
    }

//    @PostMapping("/delete")
//    public ResponseEntity delete(@RequestParam Integer id) {
//        sysMenuService.deleteById(id);
//        return Results.OK;
//    }

    @PostMapping("/update")
    public ResponseEntity update(SysMenu sysMenu) {
        sysMenuService.update(sysMenu);
        return Results.OK;
    }

    @PostMapping("/detail")
    public ResponseEntity detail(@RequestParam Integer id) {
        SysMenu sysMenu = sysMenuService.findById(id);
        return Results.success(sysMenu);
    }


    @PostMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysMenu> list = sysMenuService.findChildren(null,true);
        PageInfo pageInfo = new PageInfo(list);
        return Results.success(pageInfo);
    }



//    /**
//     * isShowHide是否显示隐藏菜单
//     * @param extId
//     * @param isShowHidden
//     * @param response
//     * @return
//     */
//    @RequiresPermissions("user")
//    @ResponseBody
//    @RequestMapping(value = "treeData")
//    public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, @RequestParam(required=false) String isShowHide, HttpServletResponse response) {
//        List<Map<String, Object>> mapList = Lists.newArrayList();
//        List<Menu> list = systemService.findAllMenu();
//        for (int i=0; i<list.size(); i++){
//            Menu e = list.get(i);
//            if (StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1)){
//                if(isShowHide != null && isShowHide.equals("0") && e.getIsShow().equals("0")){
//                    continue;
//                }
//                Map<String, Object> map = Maps.newHashMap();
//                map.put("id", e.getId());
//                map.put("pId", e.getParentId());
//                map.put("name", e.getName());
//                mapList.add(map);
//            }
//        }
//        return mapList;
//    }
}
