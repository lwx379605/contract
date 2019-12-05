package com.lmc.shopleasing.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "s_contract_template_second")
public class ContractTemplateSecond {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 乙方
     */
    @Column(name = "party_b")
    private String partyB;

    /**
     * 住所地
     */
    private String domicile;

    /**
     * 法定代表人
     */
    @Column(name = "legal_representative")
    private String legalRepresentative;

    /**
     * 职务
     */
    private String post;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 层数
     */
    @Column(name = "layer_number")
    private String layerNumber;

    /**
     * 面积合计
     */
    @Column(name = "area_total")
    private String areaTotal;

    /**
     * 用途
     */
    private String use;

    /**
     * 开始年
     */
    @Column(name = "start_year")
    private String startYear;

    /**
     * 开始月
     */
    @Column(name = "start_month")
    private String startMonth;

    /**
     * 开始日
     */
    @Column(name = "start_day")
    private String startDay;

    /**
     * 结束年
     */
    @Column(name = "stop_year")
    private String stopYear;

    /**
     * 结束月
     */
    @Column(name = "stop_month")
    private String stopMonth;

    /**
     * 结束日
     */
    @Column(name = "stop_day")
    private String stopDay;

    /**
     * 年数
     */
    @Column(name = "year_number")
    private String yearNumber;

    /**
     * 首年总金额
     */
    @Column(name = "first_year_total_amount")
    private String firstYearTotalAmount;

    /**
     * 首年总金额大写
     */
    @Column(name = "first_year_total_amount_capital")
    private String firstYearTotalAmountCapital;

    /**
     * 第二年总金额
     */
    @Column(name = "two_year_total_amount")
    private String twoYearTotalAmount;

    /**
     * 第二年总金额大写
     */
    @Column(name = "two_year_total_amount_capital")
    private String twoYearTotalAmountCapital;

    /**
     * 第三年总金额
     */
    @Column(name = "three_year_total_amout")
    private String threeYearTotalAmout;

    /**
     * 第三年总金额大写
     */
    @Column(name = "three_year_total_amout_capital")
    private String threeYearTotalAmoutCapital;

    /**
     * 第四年总金额
     */
    @Column(name = "four_year_total_amout")
    private String fourYearTotalAmout;

    /**
     * 第四年总金额大写
     */
    @Column(name = "four_year_total_amout_capital")
    private String fourYearTotalAmoutCapital;

    /**
     * 第五年总金额
     */
    @Column(name = "fives_year_total_amout")
    private String fivesYearTotalAmout;

    /**
     * 第五年总金额大写
     */
    @Column(name = "fives_year_total_amout_capital")
    private String fivesYearTotalAmoutCapital;

    /**
     * 收取单位
     */
    @Column(name = "receiving_unit")
    private String receivingUnit;

    /**
     * 第一年物业费
     */
    @Column(name = "first_year_property_cost")
    private String firstYearPropertyCost;

    /**
     * 第一年物业费大写
     */
    @Column(name = "first_year_property_cost_capital")
    private String firstYearPropertyCostCapital;

    /**
     * 甲方签章
     */
    @Column(name = "party_a_signature")
    private String partyASignature;

    /**
     * 法定代表人
     */
    @Column(name = "party_a_legalrepresentative")
    private String partyALegalrepresentative;

    /**
     * 授权经办人
     */
    @Column(name = "party_a_uthorized_manager")
    private String partyAUthorizedManager;

    /**
     * 电话/传真
     */
    @Column(name = "party_a_fax")
    private String partyAFax;

    /**
     * 乙方签章
     */
    @Column(name = "party_b_signature")
    private String partyBSignature;

    /**
     * 法定代表人
     */
    @Column(name = "party_b_legal_representative")
    private String partyBLegalRepresentative;

    /**
     * 授权经办人
     */
    @Column(name = "party_b_uthorized_manager")
    private String partyBUthorizedManager;

    /**
     * 电话/传真
     */
    @Column(name = "party_b_fax")
    private String partyBFax;

    /**
     * 签约时间年
     */
    @Column(name = "signing_year")
    private String signingYear;

    /**
     * 签约时间月
     */
    @Column(name = "signing_month")
    private String signingMonth;

    /**
     * 签约时间日
     */
    @Column(name = "signing_day")
    private String signingDay;

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
     * 获取乙方
     *
     * @return party_b - 乙方
     */
    public String getPartyB() {
        return partyB;
    }

    /**
     * 设置乙方
     *
     * @param partyB 乙方
     */
    public void setPartyB(String partyB) {
        this.partyB = partyB;
    }

    /**
     * 获取住所地
     *
     * @return domicile - 住所地
     */
    public String getDomicile() {
        return domicile;
    }

    /**
     * 设置住所地
     *
     * @param domicile 住所地
     */
    public void setDomicile(String domicile) {
        this.domicile = domicile;
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
     * @return post - 职务
     */
    public String getPost() {
        return post;
    }

    /**
     * 设置职务
     *
     * @param post 职务
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * 获取联系电话
     *
     * @return phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取层数
     *
     * @return layer_number - 层数
     */
    public String getLayerNumber() {
        return layerNumber;
    }

    /**
     * 设置层数
     *
     * @param layerNumber 层数
     */
    public void setLayerNumber(String layerNumber) {
        this.layerNumber = layerNumber;
    }

    /**
     * 获取面积合计
     *
     * @return area_total - 面积合计
     */
    public String getAreaTotal() {
        return areaTotal;
    }

    /**
     * 设置面积合计
     *
     * @param areaTotal 面积合计
     */
    public void setAreaTotal(String areaTotal) {
        this.areaTotal = areaTotal;
    }

    /**
     * 获取用途
     *
     * @return use - 用途
     */
    public String getUse() {
        return use;
    }

    /**
     * 设置用途
     *
     * @param use 用途
     */
    public void setUse(String use) {
        this.use = use;
    }

    /**
     * 获取开始年
     *
     * @return start_year - 开始年
     */
    public String getStartYear() {
        return startYear;
    }

    /**
     * 设置开始年
     *
     * @param startYear 开始年
     */
    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    /**
     * 获取开始月
     *
     * @return start_month - 开始月
     */
    public String getStartMonth() {
        return startMonth;
    }

    /**
     * 设置开始月
     *
     * @param startMonth 开始月
     */
    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    /**
     * 获取开始日
     *
     * @return start_day - 开始日
     */
    public String getStartDay() {
        return startDay;
    }

    /**
     * 设置开始日
     *
     * @param startDay 开始日
     */
    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    /**
     * 获取结束年
     *
     * @return stop_year - 结束年
     */
    public String getStopYear() {
        return stopYear;
    }

    /**
     * 设置结束年
     *
     * @param stopYear 结束年
     */
    public void setStopYear(String stopYear) {
        this.stopYear = stopYear;
    }

    /**
     * 获取结束月
     *
     * @return stop_month - 结束月
     */
    public String getStopMonth() {
        return stopMonth;
    }

    /**
     * 设置结束月
     *
     * @param stopMonth 结束月
     */
    public void setStopMonth(String stopMonth) {
        this.stopMonth = stopMonth;
    }

    /**
     * 获取结束日
     *
     * @return stop_day - 结束日
     */
    public String getStopDay() {
        return stopDay;
    }

    /**
     * 设置结束日
     *
     * @param stopDay 结束日
     */
    public void setStopDay(String stopDay) {
        this.stopDay = stopDay;
    }

    /**
     * 获取年数
     *
     * @return year_number - 年数
     */
    public String getYearNumber() {
        return yearNumber;
    }

    /**
     * 设置年数
     *
     * @param yearNumber 年数
     */
    public void setYearNumber(String yearNumber) {
        this.yearNumber = yearNumber;
    }

    /**
     * 获取首年总金额
     *
     * @return first_year_total_amount - 首年总金额
     */
    public String getFirstYearTotalAmount() {
        return firstYearTotalAmount;
    }

    /**
     * 设置首年总金额
     *
     * @param firstYearTotalAmount 首年总金额
     */
    public void setFirstYearTotalAmount(String firstYearTotalAmount) {
        this.firstYearTotalAmount = firstYearTotalAmount;
    }

    /**
     * 获取首年总金额大写
     *
     * @return first_year_total_amount_capital - 首年总金额大写
     */
    public String getFirstYearTotalAmountCapital() {
        return firstYearTotalAmountCapital;
    }

    /**
     * 设置首年总金额大写
     *
     * @param firstYearTotalAmountCapital 首年总金额大写
     */
    public void setFirstYearTotalAmountCapital(String firstYearTotalAmountCapital) {
        this.firstYearTotalAmountCapital = firstYearTotalAmountCapital;
    }

    /**
     * 获取第二年总金额
     *
     * @return two_year_total_amount - 第二年总金额
     */
    public String getTwoYearTotalAmount() {
        return twoYearTotalAmount;
    }

    /**
     * 设置第二年总金额
     *
     * @param twoYearTotalAmount 第二年总金额
     */
    public void setTwoYearTotalAmount(String twoYearTotalAmount) {
        this.twoYearTotalAmount = twoYearTotalAmount;
    }

    /**
     * 获取第二年总金额大写
     *
     * @return two_year_total_amount_capital - 第二年总金额大写
     */
    public String getTwoYearTotalAmountCapital() {
        return twoYearTotalAmountCapital;
    }

    /**
     * 设置第二年总金额大写
     *
     * @param twoYearTotalAmountCapital 第二年总金额大写
     */
    public void setTwoYearTotalAmountCapital(String twoYearTotalAmountCapital) {
        this.twoYearTotalAmountCapital = twoYearTotalAmountCapital;
    }

    /**
     * 获取第三年总金额
     *
     * @return three_year_total_amout - 第三年总金额
     */
    public String getThreeYearTotalAmout() {
        return threeYearTotalAmout;
    }

    /**
     * 设置第三年总金额
     *
     * @param threeYearTotalAmout 第三年总金额
     */
    public void setThreeYearTotalAmout(String threeYearTotalAmout) {
        this.threeYearTotalAmout = threeYearTotalAmout;
    }

    /**
     * 获取第三年总金额大写
     *
     * @return three_year_total_amout_capital - 第三年总金额大写
     */
    public String getThreeYearTotalAmoutCapital() {
        return threeYearTotalAmoutCapital;
    }

    /**
     * 设置第三年总金额大写
     *
     * @param threeYearTotalAmoutCapital 第三年总金额大写
     */
    public void setThreeYearTotalAmoutCapital(String threeYearTotalAmoutCapital) {
        this.threeYearTotalAmoutCapital = threeYearTotalAmoutCapital;
    }

    /**
     * 获取第四年总金额
     *
     * @return four_year_total_amout - 第四年总金额
     */
    public String getFourYearTotalAmout() {
        return fourYearTotalAmout;
    }

    /**
     * 设置第四年总金额
     *
     * @param fourYearTotalAmout 第四年总金额
     */
    public void setFourYearTotalAmout(String fourYearTotalAmout) {
        this.fourYearTotalAmout = fourYearTotalAmout;
    }

    /**
     * 获取第四年总金额大写
     *
     * @return four_year_total_amout_capital - 第四年总金额大写
     */
    public String getFourYearTotalAmoutCapital() {
        return fourYearTotalAmoutCapital;
    }

    /**
     * 设置第四年总金额大写
     *
     * @param fourYearTotalAmoutCapital 第四年总金额大写
     */
    public void setFourYearTotalAmoutCapital(String fourYearTotalAmoutCapital) {
        this.fourYearTotalAmoutCapital = fourYearTotalAmoutCapital;
    }

    /**
     * 获取第五年总金额
     *
     * @return fives_year_total_amout - 第五年总金额
     */
    public String getFivesYearTotalAmout() {
        return fivesYearTotalAmout;
    }

    /**
     * 设置第五年总金额
     *
     * @param fivesYearTotalAmout 第五年总金额
     */
    public void setFivesYearTotalAmout(String fivesYearTotalAmout) {
        this.fivesYearTotalAmout = fivesYearTotalAmout;
    }

    /**
     * 获取第五年总金额大写
     *
     * @return fives_year_total_amout_capital - 第五年总金额大写
     */
    public String getFivesYearTotalAmoutCapital() {
        return fivesYearTotalAmoutCapital;
    }

    /**
     * 设置第五年总金额大写
     *
     * @param fivesYearTotalAmoutCapital 第五年总金额大写
     */
    public void setFivesYearTotalAmoutCapital(String fivesYearTotalAmoutCapital) {
        this.fivesYearTotalAmoutCapital = fivesYearTotalAmoutCapital;
    }

    /**
     * 获取收取单位
     *
     * @return receiving_unit - 收取单位
     */
    public String getReceivingUnit() {
        return receivingUnit;
    }

    /**
     * 设置收取单位
     *
     * @param receivingUnit 收取单位
     */
    public void setReceivingUnit(String receivingUnit) {
        this.receivingUnit = receivingUnit;
    }

    /**
     * 获取第一年物业费
     *
     * @return first_year_property_cost - 第一年物业费
     */
    public String getFirstYearPropertyCost() {
        return firstYearPropertyCost;
    }

    /**
     * 设置第一年物业费
     *
     * @param firstYearPropertyCost 第一年物业费
     */
    public void setFirstYearPropertyCost(String firstYearPropertyCost) {
        this.firstYearPropertyCost = firstYearPropertyCost;
    }

    /**
     * 获取第一年物业费大写
     *
     * @return first_year_property_cost_capital - 第一年物业费大写
     */
    public String getFirstYearPropertyCostCapital() {
        return firstYearPropertyCostCapital;
    }

    /**
     * 设置第一年物业费大写
     *
     * @param firstYearPropertyCostCapital 第一年物业费大写
     */
    public void setFirstYearPropertyCostCapital(String firstYearPropertyCostCapital) {
        this.firstYearPropertyCostCapital = firstYearPropertyCostCapital;
    }

    /**
     * 获取甲方签章
     *
     * @return party_a_signature - 甲方签章
     */
    public String getPartyASignature() {
        return partyASignature;
    }

    /**
     * 设置甲方签章
     *
     * @param partyASignature 甲方签章
     */
    public void setPartyASignature(String partyASignature) {
        this.partyASignature = partyASignature;
    }

    /**
     * 获取法定代表人
     *
     * @return party_a_legalrepresentative - 法定代表人
     */
    public String getPartyALegalrepresentative() {
        return partyALegalrepresentative;
    }

    /**
     * 设置法定代表人
     *
     * @param partyALegalrepresentative 法定代表人
     */
    public void setPartyALegalrepresentative(String partyALegalrepresentative) {
        this.partyALegalrepresentative = partyALegalrepresentative;
    }

    /**
     * 获取授权经办人
     *
     * @return party_a_uthorized_manager - 授权经办人
     */
    public String getPartyAUthorizedManager() {
        return partyAUthorizedManager;
    }

    /**
     * 设置授权经办人
     *
     * @param partyAUthorizedManager 授权经办人
     */
    public void setPartyAUthorizedManager(String partyAUthorizedManager) {
        this.partyAUthorizedManager = partyAUthorizedManager;
    }

    /**
     * 获取电话/传真
     *
     * @return party_a_fax - 电话/传真
     */
    public String getPartyAFax() {
        return partyAFax;
    }

    /**
     * 设置电话/传真
     *
     * @param partyAFax 电话/传真
     */
    public void setPartyAFax(String partyAFax) {
        this.partyAFax = partyAFax;
    }

    /**
     * 获取乙方签章
     *
     * @return party_b_signature - 乙方签章
     */
    public String getPartyBSignature() {
        return partyBSignature;
    }

    /**
     * 设置乙方签章
     *
     * @param partyBSignature 乙方签章
     */
    public void setPartyBSignature(String partyBSignature) {
        this.partyBSignature = partyBSignature;
    }

    /**
     * 获取法定代表人
     *
     * @return party_b_legal_representative - 法定代表人
     */
    public String getPartyBLegalRepresentative() {
        return partyBLegalRepresentative;
    }

    /**
     * 设置法定代表人
     *
     * @param partyBLegalRepresentative 法定代表人
     */
    public void setPartyBLegalRepresentative(String partyBLegalRepresentative) {
        this.partyBLegalRepresentative = partyBLegalRepresentative;
    }

    /**
     * 获取授权经办人
     *
     * @return party_b_uthorized_manager - 授权经办人
     */
    public String getPartyBUthorizedManager() {
        return partyBUthorizedManager;
    }

    /**
     * 设置授权经办人
     *
     * @param partyBUthorizedManager 授权经办人
     */
    public void setPartyBUthorizedManager(String partyBUthorizedManager) {
        this.partyBUthorizedManager = partyBUthorizedManager;
    }

    /**
     * 获取电话/传真
     *
     * @return party_b_fax - 电话/传真
     */
    public String getPartyBFax() {
        return partyBFax;
    }

    /**
     * 设置电话/传真
     *
     * @param partyBFax 电话/传真
     */
    public void setPartyBFax(String partyBFax) {
        this.partyBFax = partyBFax;
    }

    /**
     * 获取签约时间年
     *
     * @return signing_year - 签约时间年
     */
    public String getSigningYear() {
        return signingYear;
    }

    /**
     * 设置签约时间年
     *
     * @param signingYear 签约时间年
     */
    public void setSigningYear(String signingYear) {
        this.signingYear = signingYear;
    }

    /**
     * 获取签约时间月
     *
     * @return signing_month - 签约时间月
     */
    public String getSigningMonth() {
        return signingMonth;
    }

    /**
     * 设置签约时间月
     *
     * @param signingMonth 签约时间月
     */
    public void setSigningMonth(String signingMonth) {
        this.signingMonth = signingMonth;
    }

    /**
     * 获取签约时间日
     *
     * @return signing_day - 签约时间日
     */
    public String getSigningDay() {
        return signingDay;
    }

    /**
     * 设置签约时间日
     *
     * @param signingDay 签约时间日
     */
    public void setSigningDay(String signingDay) {
        this.signingDay = signingDay;
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