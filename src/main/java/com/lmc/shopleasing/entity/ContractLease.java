package com.lmc.shopleasing.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "s_contract_lease")
public class ContractLease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 承租人
     */
    @Column(name = "lessee_id")
    private String lesseeId;
    
    /**
     * 承租人名称
     */
    @Transient
    private String lesseeName;

    /**
     * 承租摊位
     */
    @Column(name = "booth_id")
    private String boothId;
    
    /**
     * 承租摊位
     */
    @Transient
    private String boothName;

    /**
     * 附件
     */
    private String osskey;

    /**
     * 生效时间
     */
    @Column(name = "effective_time")
    private Date effectiveTime;

    /**
     * 失效时间
     */
    @Column(name = "expire_time")
    private Date expireTime;

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
     * 获取承租人
     *
     * @return lessee_id - 承租人
     */
    public String getLesseeId() {
        return lesseeId;
    }

    /**
     * 设置承租人
     *
     * @param lesseeId 承租人
     */
    public void setLesseeId(String lesseeId) {
        this.lesseeId = lesseeId;
    }

    /**
     * 获取承租摊位
     *
     * @return booth_id - 承租摊位
     */
    public String getBoothId() {
        return boothId;
    }

    /**
     * 设置承租摊位
     *
     * @param boothId 承租摊位
     */
    public void setBoothId(String boothId) {
        this.boothId = boothId;
    }

    /**
     * 获取附件
     *
     * @return osskey - 附件
     */
    public String getOsskey() {
        return osskey;
    }

    /**
     * 设置附件
     *
     * @param osskey 附件
     */
    public void setOsskey(String osskey) {
        this.osskey = osskey;
    }

    /**
     * 获取生效时间
     *
     * @return effective_time - 生效时间
     */
    public Date getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * 设置生效时间
     *
     * @param effectiveTime 生效时间
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    /**
     * 获取失效时间
     *
     * @return expire_time - 失效时间
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * 设置失效时间
     *
     * @param expireTime 失效时间
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
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

    /**
     * 获取承租人名称
     * @return lesseeName - 承租人名称
     */
	public String getLesseeName() {
		return lesseeName;
	}

	/**
	 * 设置承租人名称
	 * @param lesseeName 承租人名称
	 */
	public void setLesseeName(String lesseeName) {
		this.lesseeName = lesseeName;
	}

	/**
	 * 获取摊位名称
	 * @return boothName 摊位名称
	 */
	public String getBoothName() {
		return boothName;
	}

	/**
	 * 设置摊位名称
	 * @param boothName 摊位名称
	 */
	public void setBoothName(String boothName) {
		this.boothName = boothName;
	}
    
    
}