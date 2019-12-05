package com.lmc.shopleasing.entity;

import org.apache.commons.lang.StringUtils;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Table(name = "sys_area")
public class SysArea extends  OrderedEntity<Integer>{

    /**
     * 树路径分隔符
     */
    public static final String TREE_PATH_SEPARATOR = ",";


    /**
     * 父级区域
     */
    @Transient
    private SysArea parent;

    /**
     * 名称
     */
    private String name;

    /**
     *  层级
     */
    private Integer grade;

    /**
     * 层级
     */
    @Column(name = "tree_path")
    private String treePath;

    /**
     * 父级区域ID
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 获取全称
     *
     * @return 全称
     */
    @Column(name = "full_name")
    private String fullName;

    /**
     * 获取名称
     *
     * @return 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name
     *            名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取全称
     *
     * @return 全称
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 设置全称
     *
     * @param fullName
     *            全称
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
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
     *  获取父级区域ID
     *
     * @return parentId
     *          父级区域ID
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父级区域ID
     *
     * @param parentId
     *         父级区域ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取层级
     *
     * @return 层级
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * 设置层级
     *
     * @param grade
     *            层级
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * 获取上级地区
     *
     * @return 上级地区
     */
    public SysArea getParent() {
        return parent;
    }

    /**
     * 设置上级地区
     *
     * @param parent
     *            上级地区
     */
    public void setParent(SysArea parent) {
        this.parent = parent;
    }

    /**
     * 获取所有上级地区ID
     *
     * @return 所有上级地区ID
     */
    @Transient
    public Integer[] getParentIds() {
        String[] parentIds = StringUtils.split(getTreePath(), TREE_PATH_SEPARATOR);
        Integer[] result = new Integer[parentIds.length];
        for (int i = 0; i < parentIds.length; i++) {
            result[i] = Integer.valueOf(parentIds[i]);
        }
        return result;
    }

    /**
     * 获取所有上级地区
     *
     * @return 所有上级地区
     */
    @Transient
    public List<SysArea> getParents() {
        List<SysArea> parents = new ArrayList<>();
        recursiveParents(parents, this);
        return parents;
    }

    /**
     * 递归上级地区
     *
     * @param parents
     *            上级地区
     * @param area
     *            地区
     */
    private void recursiveParents(List<SysArea> parents, SysArea area) {
        if (area == null) {
            return;
        }
        SysArea parent = area.getParent();
        if (parent != null) {
            parents.add(0, parent);
            recursiveParents(parents, parent);
        }
    }

}