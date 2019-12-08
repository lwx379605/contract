package com.lmc.shopleasing.entity;

import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "s_contract_budget_record")
public class ContractBudgetRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 合同编码
     */
    @Column(name = "contract_code")
    private String contractCode;

    /**
     * 支付类型(1:收入,2:支出)
     */
    @Column(name = "payment_type")
    private String paymentType;

    /**
     * 支付时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") 
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "payment_time")
    private Date paymentTime;

    /**
     * 金额
     */
    private Double amount;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * 获取支付类型(1:收入,2:支出)
     *
     * @return payment_type - 支付类型(1:收入,2:支出)
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * 设置支付类型(1:收入,2:支出)
     *
     * @param paymentType 支付类型(1:收入,2:支出)
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * 获取支付时间
     *
     * @return payment_time - 支付时间
     */
    public Date getPaymentTime() {
        return paymentTime;
    }

    /**
     * 设置支付时间
     *
     * @param paymentTime 支付时间
     */
    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    /**
     * 获取金额
     *
     * @return amount - 金额
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * 设置金额
     *
     * @param amount 金额
     */
    public void setAmount(Double amount) {
        this.amount = amount;
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
}