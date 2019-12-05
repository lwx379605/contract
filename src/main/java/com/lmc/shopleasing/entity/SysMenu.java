package com.lmc.shopleasing.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "sys_menu")
public class SysMenu extends  OrderedEntity<Integer>{

    /**
     * 树路径分隔符
     */
    public static final String TREE_PATH_SEPARATOR = ",";

    private SysMenu parent;	// 父级菜单

    /**
     * 父级编号
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 树路径
     */
    @Column(name="tree_path",nullable = false)
    private String treePath;

    /**
     * 层级
     */
    @Column(nullable = false)
    private Integer grade;

    /**
     * 名称
     */
    private String name;

    /**
     * 链接
     */
    private String href;

    /**
     * 目标
     */
    private String target;

    /**
     * 图标
     */
    private String icon;

    /**
     * 是否在菜单中显示
     */
    @Column(name = "is_show")
    private String isShow;

    /**
     * 权限标识
     */
    private String permission;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 删除标记
     */
    @Column(name = "del_flag")
    private String delFlag;


    @JsonBackReference
    @NotNull
    public SysMenu getParent() {
        return parent;
    }// 父级菜单

    public void setParent(SysMenu parent) {
        this.parent = parent;
    }// 父级菜单

    /**
     * 获取父级编号
     *
     * @return parent_id - 父级编号
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父级编号
     *
     * @param parentId 父级编号
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取链接
     *
     * @return href - 链接
     */
    public String getHref() {
        return href;
    }

    /**
     * 设置链接
     *
     * @param href 链接
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * 获取目标
     *
     * @return target - 目标
     */
    public String getTarget() {
        return target;
    }

    /**
     * 设置目标
     *
     * @param target 目标
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取是否在菜单中显示
     *
     * @return is_show - 是否在菜单中显示
     */
    public String getIsShow() {
        return isShow;
    }

    /**
     * 设置是否在菜单中显示
     *
     * @param isShow 是否在菜单中显示
     */
    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    /**
     * 获取权限标识
     *
     * @return permission - 权限标识
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 设置权限标识
     *
     * @param permission 权限标识
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * 获取备注信息
     *
     * @return remarks - 备注信息
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注信息
     *
     * @param remarks 备注信息
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取删除标记
     *
     * @return del_flag - 删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     *
     * @param delFlag 删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @JsonIgnore
    public static void sortList(List<SysMenu> list, List<SysMenu> sourcelist, Integer parentId, boolean cascade){
        for (int i=0; i<sourcelist.size(); i++){
            SysMenu e = sourcelist.get(i);
            if (e.getParent()!=null && e.getParent().getId()!=null
                    && e.getParent().getId().equals(parentId)){
                list.add(e);
                if (cascade){
                    // 判断是否还有子节点, 有则继续获取子节点
                    for (int j=0; j<sourcelist.size(); j++){
                        SysMenu child = sourcelist.get(j);
                        if (child.getParent()!=null && child.getParent().getId()!=null
                                && child.getParent().getId().equals(e.getId())){
                            sortList(list, sourcelist, e.getId(), true);
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取树路径
     *
     * @return 树路径
     */
    public String getTreePath() {
        return treePath;
    }

    /**
     * 设置树路径
     *
     * @param treePath
     *            树路径
     */
    public void setTreePath(String treePath) {
        this.treePath = treePath;
    }

    /**
     * 层级
     *
     * @return 层级
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * 层级
     *
     * @return 层级
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * 获取所有上级地区ID
     *
     * @return 所有上级地区ID
     */
    @JsonIgnore
    @Transient
    public Integer[] getParentIds() {
        String[] parentIds = StringUtils.split(getTreePath(), TREE_PATH_SEPARATOR);
        Integer[] result = new Integer[parentIds.length];
        for (int i = 0; i < parentIds.length; i++) {
            result[i] = Integer.valueOf(parentIds[i]);
        }
        return result;
    }

}