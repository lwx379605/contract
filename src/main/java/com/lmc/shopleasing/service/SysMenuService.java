package com.lmc.shopleasing.service;

import com.lmc.shopleasing.core.Service;
import com.lmc.shopleasing.entity.SysMenu;

import java.util.List;


/**
 * Created by lmc on 2019/11/02.
 */
public interface SysMenuService extends Service<SysMenu> {

    /**
     * 查找顶级菜单
     *
     *            数量
     * @return 顶级菜单
     */
    List<SysMenu> findRoots();

    /**
     * 查找上级菜单
     *
     * @param sysMenu
     *            菜单
     * @param recursive
     *            是否递归
     * @return 上级地区
     */
    List<SysMenu> findParents(SysMenu sysMenu, boolean recursive);

    /**
     * 查找下级菜单
     *
     * @param sysMenu
     *            菜单
     * @param recursive
     *            是否递归
     * @return 下级菜单
     */
    List<SysMenu> findChildren(SysMenu sysMenu, boolean recursive);

    /**
     * 查找用户拥有的菜单
     * @return 用户拥有的菜单
     */
    List<SysMenu>  findByUser(Boolean showHidden);

}
