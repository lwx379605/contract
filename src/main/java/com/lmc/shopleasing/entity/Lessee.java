package com.lmc.shopleasing.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "s_lessee")
public class Lessee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 承租人类型 1:个人  2:单位
     */
    private String type;

    /**
     * 承租人性别
     */
    private String sex;

    /**
     * 法定代表人
     */
    @Column(name = "legal_representative")
    private String legalRepresentative;

    /**
     * 职务
     */
    private String position;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 修改者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 删除标记  0:未删除 1:已删除
     */
    @Column(name = "del_flag")
    private Boolean delFlag;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取承租人类型 1:个人  2:单位
     *
     * @return type - 承租人类型 1:个人  2:单位
     */
    public String getType() {
        return type;
    }

    /**
     * 设置承租人类型 1:个人  2:单位
     *
     * @param type 承租人类型 1:个人  2:单位
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取承租人性别
     *
     * @return sex - 承租人性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置承租人性别
     *
     * @param sex 承租人性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取法定代表人
     *
     * @return legal_representative - 法定代表人
     */
    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    /**
     * 设置法定代表人
     *
     * @param legalRepresentative 法定代表人
     */
    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    /**
     * 获取职务
     *
     * @return position - 职务
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置职务
     *
     * @param position 职务
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取联系方式
     *
     * @return phone - 联系方式
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系方式
     *
     * @param phone 联系方式
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取修改者
     *
     * @return update_by - 修改者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置修改者
     *
     * @param updateBy 修改者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取删除标记  0:未删除 1:已删除
     *
     * @return del_flag - 删除标记  0:未删除 1:已删除
     */
    public Boolean getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记  0:未删除 1:已删除
     *
     * @param delFlag 删除标记  0:未删除 1:已删除
     */
    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}