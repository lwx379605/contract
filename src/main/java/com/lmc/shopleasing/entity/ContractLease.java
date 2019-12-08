package com.lmc.shopleasing.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "s_contract_lease")
public class ContractLease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 合同编码
     */
    @Column(name = "contract_code")
    private String contractCode;

    /**
     * 合同金额
     */
    @Column(name = "contract_amount")
    private Double contractAmount;

    /**
     * 合同类型（1:解除合同，2:转租协议，3:早市解除合同，4:二层以上，5:冷库，6:商铺，7:仓库）
     */
    @Column(name = "contract_type")
    private String contractType;

    /**
     * 付款时间
     */
    @Column(name = "payment_time")
    private Date paymentTime;

    /**
     * 付款金额
     */
    @Column(name = "payment_amount")
    private Double paymentAmount;

    /**
     * 承租人
     */
    @Column(name = "lessee_id")
    private Integer lesseeId;

    /**
     * 承租摊位
     */
    @Column(name = "booth_id")
    private Integer boothId;

    /**
     * 附件（多个以逗号分隔）
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

    @Transient
    private String lesseeName;
    
    @Transient
    private String boothName;
    
    
    public String getLesseeName() {
		return lesseeName;
	}

	public void setLesseeName(String lesseeName) {
		this.lesseeName = lesseeName;
	}

	public String getBoothName() {
		return boothName;
	}

	public void setBoothName(String boothName) {
		this.boothName = boothName;
	}

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
     * 获取合同编码
     *
     * @return contract_code - 合同编码
     */
    public String getContractCode() {
        return contractCode;
    }

    /**
     * 设置合同编码
     *
     * @param contractCode 合同编码
     */
    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    /**
     * 获取合同金额
     *
     * @return contract_amount - 合同金额
     */
    public Double getContractAmount() {
        return contractAmount;
    }

    /**
     * 设置合同金额
     *
     * @param contractAmount 合同金额
     */
    public void setContractAmount(Double contractAmount) {
        this.contractAmount = contractAmount;
    }

    /**
     * 获取合同类型（1:解除合同，2:转租协议，3:早市解除合同，4:二层以上，5:冷库，6:商铺，7:仓库）
     *
     * @return contract_type - 合同类型（1:解除合同，2:转租协议，3:早市解除合同，4:二层以上，5:冷库，6:商铺，7:仓库）
     */
    public String getContractType() {
        return contractType;
    }

    /**
     * 设置合同类型（1:解除合同，2:转租协议，3:早市解除合同，4:二层以上，5:冷库，6:商铺，7:仓库）
     *
     * @param contractType 合同类型（1:解除合同，2:转租协议，3:早市解除合同，4:二层以上，5:冷库，6:商铺，7:仓库）
     */
    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    /**
     * 获取付款时间
     *
     * @return payment_time - 付款时间
     */
    public Date getPaymentTime() {
        return paymentTime;
    }

    /**
     * 设置付款时间
     *
     * @param paymentTime 付款时间
     */
    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    /**
     * 获取付款金额
     *
     * @return payment_amount - 付款金额
     */
    public Double getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * 设置付款金额
     *
     * @param paymentAmount 付款金额
     */
    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    /**
     * 获取承租人
     *
     * @return lessee_id - 承租人
     */
    public Integer getLesseeId() {
        return lesseeId;
    }

    /**
     * 设置承租人
     *
     * @param lesseeId 承租人
     */
    public void setLesseeId(Integer lesseeId) {
        this.lesseeId = lesseeId;
    }

    /**
     * 获取承租摊位
     *
     * @return booth_id - 承租摊位
     */
    public Integer getBoothId() {
        return boothId;
    }

    /**
     * 设置承租摊位
     *
     * @param boothId 承租摊位
     */
    public void setBoothId(Integer boothId) {
        this.boothId = boothId;
    }

    /**
     * 获取附件（多个以逗号分隔）
     *
     * @return osskey - 附件（多个以逗号分隔）
     */
    public String getOsskey() {
        return osskey;
    }

    /**
     * 设置附件（多个以逗号分隔）
     *
     * @param osskey 附件（多个以逗号分隔）
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
}