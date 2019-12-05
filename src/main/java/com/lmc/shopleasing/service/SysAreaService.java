package com.lmc.shopleasing.service;
import com.lmc.shopleasing.entity.SysArea;
import com.lmc.shopleasing.core.Service;

import java.util.List;


/**
 * Created by lmc on 2019/11/07.
 */
public interface SysAreaService extends Service<SysArea> {

    /**
     * 查找顶级地区
     *
     * @return 顶级地区
     */
    List<SysArea> findRoots();

    /**
     * 查找上级地区
     *
     * @param area
     *            地区
     * @param recursive
     *            是否递归
     * @return 上级地区
     */
    List<SysArea> findParents(SysArea area, boolean recursive);

    /**
     * 查找下级地区
     *
     * @param area
     *            地区
     * @param recursive
     *            是否递归
     * @return 下级地区
     */
    List<SysArea> findChildren(SysArea area, boolean recursive);

}
