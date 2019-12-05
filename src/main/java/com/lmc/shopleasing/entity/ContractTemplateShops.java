package com.lmc.shopleasing.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "s_contract_template_shops")
public class ContractTemplateShops {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 乙方
     */
    @Column(name = "partyB")
    private String partyb;

    /**
     * 住所地
     */
    private String domicile;

    /**
     * 法定代表人
     */
    @Column(name = "legalRepresentative")
    private String legalrepresentative;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 建筑物号
     */
    @Column(name = "buildingNumber")
    private String buildingnumber;

    /**
     * 商铺号
     */
    @Column(name = "boothNumber")
    private String boothnumber;

    /**
     * 层数
     */
    @Column(name = "layerNumber")
    private String layernumber;

    /**
     * 面积
     */
    @Column(name = "areaSquare")
    private String areasquare;

    /**
     * 间数总计
     */
    private String rooms;

    /**
     * 用途
     */
    private String use;

    /**
     * 开始年
     */
    @Column(name = "startYear")
    private String startyear;

    /**
     * 开始月
     */
    @Column(name = "startMonth")
    private String startmonth;

    /**
     * 开始日
     */
    @Column(name = "startDay")
    private String startday;

    /**
     * 结束年
     */
    @Column(name = "stopYear")
    private String stopyear;

    /**
     * 结束月
     */
    @Column(name = "stopMonth")
    private String stopmonth;

    /**
     * 结束日
     */
    @Column(name = "stopDay")
    private String stopday;

    /**
     * 年数
     */
    @Column(name = "yearNumber")
    private String yearnumber;

    /**
     * 租金总额
     */
    private String rent;

    /**
     * 租金总额大写
     */
    @Column(name = "rentCapital")
    private String rentcapital;

    /**
     * 管理费总额
     */
    @Column(name = "managementFee")
    private String managementfee;

    /**
     * 管理费总额大写
     */
    @Column(name = "managementFeeCapital")
    private String managementfeecapital;

    /**
     * 租金管理费总额
     */
    private String total;

    /**
     * 租金管理费总额大写
     */
    @Column(name = "totalCapital")
    private String totalcapital;

    /**
     * 首付租金
     */
    @Column(name = "downPaymentRent")
    private String downpaymentrent;

    /**
     * 首付租金大写
     */
    @Column(name = "downPaymentRentCapital")
    private String downpaymentrentcapital;

    /**
     * 首付管理费
     */
    @Column(name = "downPaymentManagementFee")
    private String downpaymentmanagementfee;

    /**
     * 首付管理费大写
     */
    @Column(name = "downPaymentManagementFeeCapital")
    private String downpaymentmanagementfeecapital;

    /**
     * 首付共计
     */
    @Column(name = "downPaymentTotal")
    private String downpaymenttotal;

    /**
     * 首付共计大写
     */
    @Column(name = "downPaymentTotalCapital")
    private String downpaymenttotalcapital;

    /**
     * 首年租期结束年
     */
    @Column(name = "firstLeasePeriodEndYear")
    private String firstleaseperiodendyear;

    /**
     * 首年租期结束月
     */
    @Column(name = "firstLeasePeriodEndMonth")
    private String firstleaseperiodendmonth;

    /**
     * 首年租期结束日
     */
    @Column(name = "firstLeasePeriodEndDay")
    private String firstleaseperiodendday;

    /**
     * 剩余租金
     */
    @Column(name = "remainingRent")
    private String remainingrent;

    /**
     * 剩余租金大写
     */
    @Column(name = "remainingRentCapital")
    private String remainingrentcapital;

    /**
     * 剩余管理费
     */
    @Column(name = "remainingManagementFee")
    private String remainingmanagementfee;

    /**
     * 剩余管理费大写
     */
    @Column(name = "remainingManagementFeeCapital")
    private String remainingmanagementfeecapital;

    /**
     * 剩余总计
     */
    @Column(name = "remainingTotal")
    private String remainingtotal;

    /**
     * 剩余总计大写
     */
    @Column(name = "remainingTotalCapital")
    private String remainingtotalcapital;

    /**
     * 卫生费
     */
    @Column(name = "hygieneFee")
    private String hygienefee;

    /**
     * 卫生费大写
     */
    @Column(name = "hygieneFeeCapital")
    private String hygienefeecapital;

    /**
     * 电费元/度
     */
    @Column(name = "electricityFee")
    private String electricityfee;

    /**
     * 水费元/吨
     */
    @Column(name = "waterFee")
    private String waterfee;

    /**
     * 装修保证金元/间
     */
    @Column(name = "decorationDeposit")
    private String decorationdeposit;

    /**
     * 装修保证金大写
     */
    @Column(name = "decorationDepositCapital")
    private String decorationdepositcapital;

    /**
     * 装修保证金共计
     */
    @Column(name = "decorationDepositTotal")
    private String decorationdeposittotal;

    /**
     * 装修保证金共计大写
     */
    @Column(name = "decorationDepositTotalCapital")
    private String decorationdeposittotalcapital;

    /**
     * 保证金元/间
     */
    @Column(name = "securityDeposit")
    private String securitydeposit;

    /**
     * 保证金大写
     */
    @Column(name = "securityDepositCapital")
    private String securitydepositcapital;

    /**
     * 保证金统计
     */
    @Column(name = "securityDepositTotal")
    private String securitydeposittotal;

    /**
     * 保证金统计大写
     */
    @Column(name = "securityDepositTotalCapital")
    private String securitydeposittotalcapital;

    /**
     * 甲方签章
     */
    @Column(name = "partyASignature")
    private String partyasignature;

    /**
     * 法定代表人
     */
    @Column(name = "partyALegalRepresentative")
    private String partyalegalrepresentative;

    /**
     * 授权经办人
     */
    @Column(name = "partyAuthorizedManager")
    private String partyauthorizedmanager;

    /**
     * 电话/传真
     */
    @Column(name = "partyAFax")
    private String partyafax;

    /**
     * 乙方签章
     */
    @Column(name = "partyBSignature")
    private String partybsignature;

    /**
     * 法定代表人
     */
    @Column(name = "partyBLegalRepresentative")
    private String partyblegalrepresentative;

    /**
     * 授权经办人
     */
    @Column(name = "partyButhorizedManager")
    private String partybuthorizedmanager;

    /**
     * 电话/传真
     */
    @Column(name = "partyBFax")
    private String partybfax;

    /**
     * 签约时间年
     */
    @Column(name = "signingYear")
    private String signingyear;

    /**
     * 签约时间月
     */
    @Column(name = "signingMonth")
    private String signingmonth;

    /**
     * 签约时间日
     */
    @Column(name = "signingDay")
    private String signingday;

    /**
     * 甲方负责人
     */
    @Column(name = "partyAPrincipal")
    private String partyaprincipal;

    /**
     * 甲方签名日期年
     */
    @Column(name = "partyAYear")
    private String partyayear;

    /**
     * 甲方签名日期月
     */
    @Column(name = "partyAMonth")
    private String partyamonth;

    /**
     * 甲方签名日期日
     */
    @Column(name = "partyADay")
    private String partyaday;

    /**
     * 乙方负责人
     */
    @Column(name = "partyBPrincipal")
    private String partybprincipal;

    /**
     * 乙方签名日期年
     */
    @Column(name = "partyBYear")
    private String partybyear;

    /**
     * 乙方签名日期月
     */
    @Column(name = "partyBMonth")
    private String partybmonth;

    /**
     * 乙方签名日期日
     */
    @Column(name = "partyBDay")
    private String partybday;

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
     * @return partyB - 乙方
     */
    public String getPartyb() {
        return partyb;
    }

    /**
     * 设置乙方
     *
     * @param partyb 乙方
     */
    public void setPartyb(String partyb) {
        this.partyb = partyb;
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
     * @return legalRepresentative - 法定代表人
     */
    public String getLegalrepresentative() {
        return legalrepresentative;
    }

    /**
     * 设置法定代表人
     *
     * @param legalrepresentative 法定代表人
     */
    public void setLegalrepresentative(String legalrepresentative) {
        this.legalrepresentative = legalrepresentative;
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
     * 获取建筑物号
     *
     * @return buildingNumber - 建筑物号
     */
    public String getBuildingnumber() {
        return buildingnumber;
    }

    /**
     * 设置建筑物号
     *
     * @param buildingnumber 建筑物号
     */
    public void setBuildingnumber(String buildingnumber) {
        this.buildingnumber = buildingnumber;
    }

    /**
     * 获取商铺号
     *
     * @return boothNumber - 商铺号
     */
    public String getBoothnumber() {
        return boothnumber;
    }

    /**
     * 设置商铺号
     *
     * @param boothnumber 商铺号
     */
    public void setBoothnumber(String boothnumber) {
        this.boothnumber = boothnumber;
    }

    /**
     * 获取层数
     *
     * @return layerNumber - 层数
     */
    public String getLayernumber() {
        return layernumber;
    }

    /**
     * 设置层数
     *
     * @param layernumber 层数
     */
    public void setLayernumber(String layernumber) {
        this.layernumber = layernumber;
    }

    /**
     * 获取面积
     *
     * @return areaSquare - 面积
     */
    public String getAreasquare() {
        return areasquare;
    }

    /**
     * 设置面积
     *
     * @param areasquare 面积
     */
    public void setAreasquare(String areasquare) {
        this.areasquare = areasquare;
    }

    /**
     * 获取间数总计
     *
     * @return rooms - 间数总计
     */
    public String getRooms() {
        return rooms;
    }

    /**
     * 设置间数总计
     *
     * @param rooms 间数总计
     */
    public void setRooms(String rooms) {
        this.rooms = rooms;
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
     * @return startYear - 开始年
     */
    public String getStartyear() {
        return startyear;
    }

    /**
     * 设置开始年
     *
     * @param startyear 开始年
     */
    public void setStartyear(String startyear) {
        this.startyear = startyear;
    }

    /**
     * 获取开始月
     *
     * @return startMonth - 开始月
     */
    public String getStartmonth() {
        return startmonth;
    }

    /**
     * 设置开始月
     *
     * @param startmonth 开始月
     */
    public void setStartmonth(String startmonth) {
        this.startmonth = startmonth;
    }

    /**
     * 获取开始日
     *
     * @return startDay - 开始日
     */
    public String getStartday() {
        return startday;
    }

    /**
     * 设置开始日
     *
     * @param startday 开始日
     */
    public void setStartday(String startday) {
        this.startday = startday;
    }

    /**
     * 获取结束年
     *
     * @return stopYear - 结束年
     */
    public String getStopyear() {
        return stopyear;
    }

    /**
     * 设置结束年
     *
     * @param stopyear 结束年
     */
    public void setStopyear(String stopyear) {
        this.stopyear = stopyear;
    }

    /**
     * 获取结束月
     *
     * @return stopMonth - 结束月
     */
    public String getStopmonth() {
        return stopmonth;
    }

    /**
     * 设置结束月
     *
     * @param stopmonth 结束月
     */
    public void setStopmonth(String stopmonth) {
        this.stopmonth = stopmonth;
    }

    /**
     * 获取结束日
     *
     * @return stopDay - 结束日
     */
    public String getStopday() {
        return stopday;
    }

    /**
     * 设置结束日
     *
     * @param stopday 结束日
     */
    public void setStopday(String stopday) {
        this.stopday = stopday;
    }

    /**
     * 获取年数
     *
     * @return yearNumber - 年数
     */
    public String getYearnumber() {
        return yearnumber;
    }

    /**
     * 设置年数
     *
     * @param yearnumber 年数
     */
    public void setYearnumber(String yearnumber) {
        this.yearnumber = yearnumber;
    }

    /**
     * 获取租金总额
     *
     * @return rent - 租金总额
     */
    public String getRent() {
        return rent;
    }

    /**
     * 设置租金总额
     *
     * @param rent 租金总额
     */
    public void setRent(String rent) {
        this.rent = rent;
    }

    /**
     * 获取租金总额大写
     *
     * @return rentCapital - 租金总额大写
     */
    public String getRentcapital() {
        return rentcapital;
    }

    /**
     * 设置租金总额大写
     *
     * @param rentcapital 租金总额大写
     */
    public void setRentcapital(String rentcapital) {
        this.rentcapital = rentcapital;
    }

    /**
     * 获取管理费总额
     *
     * @return managementFee - 管理费总额
     */
    public String getManagementfee() {
        return managementfee;
    }

    /**
     * 设置管理费总额
     *
     * @param managementfee 管理费总额
     */
    public void setManagementfee(String managementfee) {
        this.managementfee = managementfee;
    }

    /**
     * 获取管理费总额大写
     *
     * @return managementFeeCapital - 管理费总额大写
     */
    public String getManagementfeecapital() {
        return managementfeecapital;
    }

    /**
     * 设置管理费总额大写
     *
     * @param managementfeecapital 管理费总额大写
     */
    public void setManagementfeecapital(String managementfeecapital) {
        this.managementfeecapital = managementfeecapital;
    }

    /**
     * 获取租金管理费总额
     *
     * @return total - 租金管理费总额
     */
    public String getTotal() {
        return total;
    }

    /**
     * 设置租金管理费总额
     *
     * @param total 租金管理费总额
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * 获取租金管理费总额大写
     *
     * @return totalCapital - 租金管理费总额大写
     */
    public String getTotalcapital() {
        return totalcapital;
    }

    /**
     * 设置租金管理费总额大写
     *
     * @param totalcapital 租金管理费总额大写
     */
    public void setTotalcapital(String totalcapital) {
        this.totalcapital = totalcapital;
    }

    /**
     * 获取首付租金
     *
     * @return downPaymentRent - 首付租金
     */
    public String getDownpaymentrent() {
        return downpaymentrent;
    }

    /**
     * 设置首付租金
     *
     * @param downpaymentrent 首付租金
     */
    public void setDownpaymentrent(String downpaymentrent) {
        this.downpaymentrent = downpaymentrent;
    }

    /**
     * 获取首付租金大写
     *
     * @return downPaymentRentCapital - 首付租金大写
     */
    public String getDownpaymentrentcapital() {
        return downpaymentrentcapital;
    }

    /**
     * 设置首付租金大写
     *
     * @param downpaymentrentcapital 首付租金大写
     */
    public void setDownpaymentrentcapital(String downpaymentrentcapital) {
        this.downpaymentrentcapital = downpaymentrentcapital;
    }

    /**
     * 获取首付管理费
     *
     * @return downPaymentManagementFee - 首付管理费
     */
    public String getDownpaymentmanagementfee() {
        return downpaymentmanagementfee;
    }

    /**
     * 设置首付管理费
     *
     * @param downpaymentmanagementfee 首付管理费
     */
    public void setDownpaymentmanagementfee(String downpaymentmanagementfee) {
        this.downpaymentmanagementfee = downpaymentmanagementfee;
    }

    /**
     * 获取首付管理费大写
     *
     * @return downPaymentManagementFeeCapital - 首付管理费大写
     */
    public String getDownpaymentmanagementfeecapital() {
        return downpaymentmanagementfeecapital;
    }

    /**
     * 设置首付管理费大写
     *
     * @param downpaymentmanagementfeecapital 首付管理费大写
     */
    public void setDownpaymentmanagementfeecapital(String downpaymentmanagementfeecapital) {
        this.downpaymentmanagementfeecapital = downpaymentmanagementfeecapital;
    }

    /**
     * 获取首付共计
     *
     * @return downPaymentTotal - 首付共计
     */
    public String getDownpaymenttotal() {
        return downpaymenttotal;
    }

    /**
     * 设置首付共计
     *
     * @param downpaymenttotal 首付共计
     */
    public void setDownpaymenttotal(String downpaymenttotal) {
        this.downpaymenttotal = downpaymenttotal;
    }

    /**
     * 获取首付共计大写
     *
     * @return downPaymentTotalCapital - 首付共计大写
     */
    public String getDownpaymenttotalcapital() {
        return downpaymenttotalcapital;
    }

    /**
     * 设置首付共计大写
     *
     * @param downpaymenttotalcapital 首付共计大写
     */
    public void setDownpaymenttotalcapital(String downpaymenttotalcapital) {
        this.downpaymenttotalcapital = downpaymenttotalcapital;
    }

    /**
     * 获取首年租期结束年
     *
     * @return firstLeasePeriodEndYear - 首年租期结束年
     */
    public String getFirstleaseperiodendyear() {
        return firstleaseperiodendyear;
    }

    /**
     * 设置首年租期结束年
     *
     * @param firstleaseperiodendyear 首年租期结束年
     */
    public void setFirstleaseperiodendyear(String firstleaseperiodendyear) {
        this.firstleaseperiodendyear = firstleaseperiodendyear;
    }

    /**
     * 获取首年租期结束月
     *
     * @return firstLeasePeriodEndMonth - 首年租期结束月
     */
    public String getFirstleaseperiodendmonth() {
        return firstleaseperiodendmonth;
    }

    /**
     * 设置首年租期结束月
     *
     * @param firstleaseperiodendmonth 首年租期结束月
     */
    public void setFirstleaseperiodendmonth(String firstleaseperiodendmonth) {
        this.firstleaseperiodendmonth = firstleaseperiodendmonth;
    }

    /**
     * 获取首年租期结束日
     *
     * @return firstLeasePeriodEndDay - 首年租期结束日
     */
    public String getFirstleaseperiodendday() {
        return firstleaseperiodendday;
    }

    /**
     * 设置首年租期结束日
     *
     * @param firstleaseperiodendday 首年租期结束日
     */
    public void setFirstleaseperiodendday(String firstleaseperiodendday) {
        this.firstleaseperiodendday = firstleaseperiodendday;
    }

    /**
     * 获取剩余租金
     *
     * @return remainingRent - 剩余租金
     */
    public String getRemainingrent() {
        return remainingrent;
    }

    /**
     * 设置剩余租金
     *
     * @param remainingrent 剩余租金
     */
    public void setRemainingrent(String remainingrent) {
        this.remainingrent = remainingrent;
    }

    /**
     * 获取剩余租金大写
     *
     * @return remainingRentCapital - 剩余租金大写
     */
    public String getRemainingrentcapital() {
        return remainingrentcapital;
    }

    /**
     * 设置剩余租金大写
     *
     * @param remainingrentcapital 剩余租金大写
     */
    public void setRemainingrentcapital(String remainingrentcapital) {
        this.remainingrentcapital = remainingrentcapital;
    }

    /**
     * 获取剩余管理费
     *
     * @return remainingManagementFee - 剩余管理费
     */
    public String getRemainingmanagementfee() {
        return remainingmanagementfee;
    }

    /**
     * 设置剩余管理费
     *
     * @param remainingmanagementfee 剩余管理费
     */
    public void setRemainingmanagementfee(String remainingmanagementfee) {
        this.remainingmanagementfee = remainingmanagementfee;
    }

    /**
     * 获取剩余管理费大写
     *
     * @return remainingManagementFeeCapital - 剩余管理费大写
     */
    public String getRemainingmanagementfeecapital() {
        return remainingmanagementfeecapital;
    }

    /**
     * 设置剩余管理费大写
     *
     * @param remainingmanagementfeecapital 剩余管理费大写
     */
    public void setRemainingmanagementfeecapital(String remainingmanagementfeecapital) {
        this.remainingmanagementfeecapital = remainingmanagementfeecapital;
    }

    /**
     * 获取剩余总计
     *
     * @return remainingTotal - 剩余总计
     */
    public String getRemainingtotal() {
        return remainingtotal;
    }

    /**
     * 设置剩余总计
     *
     * @param remainingtotal 剩余总计
     */
    public void setRemainingtotal(String remainingtotal) {
        this.remainingtotal = remainingtotal;
    }

    /**
     * 获取剩余总计大写
     *
     * @return remainingTotalCapital - 剩余总计大写
     */
    public String getRemainingtotalcapital() {
        return remainingtotalcapital;
    }

    /**
     * 设置剩余总计大写
     *
     * @param remainingtotalcapital 剩余总计大写
     */
    public void setRemainingtotalcapital(String remainingtotalcapital) {
        this.remainingtotalcapital = remainingtotalcapital;
    }

    /**
     * 获取卫生费
     *
     * @return hygieneFee - 卫生费
     */
    public String getHygienefee() {
        return hygienefee;
    }

    /**
     * 设置卫生费
     *
     * @param hygienefee 卫生费
     */
    public void setHygienefee(String hygienefee) {
        this.hygienefee = hygienefee;
    }

    /**
     * 获取卫生费大写
     *
     * @return hygieneFeeCapital - 卫生费大写
     */
    public String getHygienefeecapital() {
        return hygienefeecapital;
    }

    /**
     * 设置卫生费大写
     *
     * @param hygienefeecapital 卫生费大写
     */
    public void setHygienefeecapital(String hygienefeecapital) {
        this.hygienefeecapital = hygienefeecapital;
    }

    /**
     * 获取电费元/度
     *
     * @return electricityFee - 电费元/度
     */
    public String getElectricityfee() {
        return electricityfee;
    }

    /**
     * 设置电费元/度
     *
     * @param electricityfee 电费元/度
     */
    public void setElectricityfee(String electricityfee) {
        this.electricityfee = electricityfee;
    }

    /**
     * 获取水费元/吨
     *
     * @return waterFee - 水费元/吨
     */
    public String getWaterfee() {
        return waterfee;
    }

    /**
     * 设置水费元/吨
     *
     * @param waterfee 水费元/吨
     */
    public void setWaterfee(String waterfee) {
        this.waterfee = waterfee;
    }

    /**
     * 获取装修保证金元/间
     *
     * @return decorationDeposit - 装修保证金元/间
     */
    public String getDecorationdeposit() {
        return decorationdeposit;
    }

    /**
     * 设置装修保证金元/间
     *
     * @param decorationdeposit 装修保证金元/间
     */
    public void setDecorationdeposit(String decorationdeposit) {
        this.decorationdeposit = decorationdeposit;
    }

    /**
     * 获取装修保证金大写
     *
     * @return decorationDepositCapital - 装修保证金大写
     */
    public String getDecorationdepositcapital() {
        return decorationdepositcapital;
    }

    /**
     * 设置装修保证金大写
     *
     * @param decorationdepositcapital 装修保证金大写
     */
    public void setDecorationdepositcapital(String decorationdepositcapital) {
        this.decorationdepositcapital = decorationdepositcapital;
    }

    /**
     * 获取装修保证金共计
     *
     * @return decorationDepositTotal - 装修保证金共计
     */
    public String getDecorationdeposittotal() {
        return decorationdeposittotal;
    }

    /**
     * 设置装修保证金共计
     *
     * @param decorationdeposittotal 装修保证金共计
     */
    public void setDecorationdeposittotal(String decorationdeposittotal) {
        this.decorationdeposittotal = decorationdeposittotal;
    }

    /**
     * 获取装修保证金共计大写
     *
     * @return decorationDepositTotalCapital - 装修保证金共计大写
     */
    public String getDecorationdeposittotalcapital() {
        return decorationdeposittotalcapital;
    }

    /**
     * 设置装修保证金共计大写
     *
     * @param decorationdeposittotalcapital 装修保证金共计大写
     */
    public void setDecorationdeposittotalcapital(String decorationdeposittotalcapital) {
        this.decorationdeposittotalcapital = decorationdeposittotalcapital;
    }

    /**
     * 获取保证金元/间
     *
     * @return securityDeposit - 保证金元/间
     */
    public String getSecuritydeposit() {
        return securitydeposit;
    }

    /**
     * 设置保证金元/间
     *
     * @param securitydeposit 保证金元/间
     */
    public void setSecuritydeposit(String securitydeposit) {
        this.securitydeposit = securitydeposit;
    }

    /**
     * 获取保证金大写
     *
     * @return securityDepositCapital - 保证金大写
     */
    public String getSecuritydepositcapital() {
        return securitydepositcapital;
    }

    /**
     * 设置保证金大写
     *
     * @param securitydepositcapital 保证金大写
     */
    public void setSecuritydepositcapital(String securitydepositcapital) {
        this.securitydepositcapital = securitydepositcapital;
    }

    /**
     * 获取保证金统计
     *
     * @return securityDepositTotal - 保证金统计
     */
    public String getSecuritydeposittotal() {
        return securitydeposittotal;
    }

    /**
     * 设置保证金统计
     *
     * @param securitydeposittotal 保证金统计
     */
    public void setSecuritydeposittotal(String securitydeposittotal) {
        this.securitydeposittotal = securitydeposittotal;
    }

    /**
     * 获取保证金统计大写
     *
     * @return securityDepositTotalCapital - 保证金统计大写
     */
    public String getSecuritydeposittotalcapital() {
        return securitydeposittotalcapital;
    }

    /**
     * 设置保证金统计大写
     *
     * @param securitydeposittotalcapital 保证金统计大写
     */
    public void setSecuritydeposittotalcapital(String securitydeposittotalcapital) {
        this.securitydeposittotalcapital = securitydeposittotalcapital;
    }

    /**
     * 获取甲方签章
     *
     * @return partyASignature - 甲方签章
     */
    public String getPartyasignature() {
        return partyasignature;
    }

    /**
     * 设置甲方签章
     *
     * @param partyasignature 甲方签章
     */
    public void setPartyasignature(String partyasignature) {
        this.partyasignature = partyasignature;
    }

    /**
     * 获取法定代表人
     *
     * @return partyALegalRepresentative - 法定代表人
     */
    public String getPartyalegalrepresentative() {
        return partyalegalrepresentative;
    }

    /**
     * 设置法定代表人
     *
     * @param partyalegalrepresentative 法定代表人
     */
    public void setPartyalegalrepresentative(String partyalegalrepresentative) {
        this.partyalegalrepresentative = partyalegalrepresentative;
    }

    /**
     * 获取授权经办人
     *
     * @return partyAuthorizedManager - 授权经办人
     */
    public String getPartyauthorizedmanager() {
        return partyauthorizedmanager;
    }

    /**
     * 设置授权经办人
     *
     * @param partyauthorizedmanager 授权经办人
     */
    public void setPartyauthorizedmanager(String partyauthorizedmanager) {
        this.partyauthorizedmanager = partyauthorizedmanager;
    }

    /**
     * 获取电话/传真
     *
     * @return partyAFax - 电话/传真
     */
    public String getPartyafax() {
        return partyafax;
    }

    /**
     * 设置电话/传真
     *
     * @param partyafax 电话/传真
     */
    public void setPartyafax(String partyafax) {
        this.partyafax = partyafax;
    }

    /**
     * 获取乙方签章
     *
     * @return partyBSignature - 乙方签章
     */
    public String getPartybsignature() {
        return partybsignature;
    }

    /**
     * 设置乙方签章
     *
     * @param partybsignature 乙方签章
     */
    public void setPartybsignature(String partybsignature) {
        this.partybsignature = partybsignature;
    }

    /**
     * 获取法定代表人
     *
     * @return partyBLegalRepresentative - 法定代表人
     */
    public String getPartyblegalrepresentative() {
        return partyblegalrepresentative;
    }

    /**
     * 设置法定代表人
     *
     * @param partyblegalrepresentative 法定代表人
     */
    public void setPartyblegalrepresentative(String partyblegalrepresentative) {
        this.partyblegalrepresentative = partyblegalrepresentative;
    }

    /**
     * 获取授权经办人
     *
     * @return partyButhorizedManager - 授权经办人
     */
    public String getPartybuthorizedmanager() {
        return partybuthorizedmanager;
    }

    /**
     * 设置授权经办人
     *
     * @param partybuthorizedmanager 授权经办人
     */
    public void setPartybuthorizedmanager(String partybuthorizedmanager) {
        this.partybuthorizedmanager = partybuthorizedmanager;
    }

    /**
     * 获取电话/传真
     *
     * @return partyBFax - 电话/传真
     */
    public String getPartybfax() {
        return partybfax;
    }

    /**
     * 设置电话/传真
     *
     * @param partybfax 电话/传真
     */
    public void setPartybfax(String partybfax) {
        this.partybfax = partybfax;
    }

    /**
     * 获取签约时间年
     *
     * @return signingYear - 签约时间年
     */
    public String getSigningyear() {
        return signingyear;
    }

    /**
     * 设置签约时间年
     *
     * @param signingyear 签约时间年
     */
    public void setSigningyear(String signingyear) {
        this.signingyear = signingyear;
    }

    /**
     * 获取签约时间月
     *
     * @return signingMonth - 签约时间月
     */
    public String getSigningmonth() {
        return signingmonth;
    }

    /**
     * 设置签约时间月
     *
     * @param signingmonth 签约时间月
     */
    public void setSigningmonth(String signingmonth) {
        this.signingmonth = signingmonth;
    }

    /**
     * 获取签约时间日
     *
     * @return signingDay - 签约时间日
     */
    public String getSigningday() {
        return signingday;
    }

    /**
     * 设置签约时间日
     *
     * @param signingday 签约时间日
     */
    public void setSigningday(String signingday) {
        this.signingday = signingday;
    }

    /**
     * 获取甲方负责人
     *
     * @return partyAPrincipal - 甲方负责人
     */
    public String getPartyaprincipal() {
        return partyaprincipal;
    }

    /**
     * 设置甲方负责人
     *
     * @param partyaprincipal 甲方负责人
     */
    public void setPartyaprincipal(String partyaprincipal) {
        this.partyaprincipal = partyaprincipal;
    }

    /**
     * 获取甲方签名日期年
     *
     * @return partyAYear - 甲方签名日期年
     */
    public String getPartyayear() {
        return partyayear;
    }

    /**
     * 设置甲方签名日期年
     *
     * @param partyayear 甲方签名日期年
     */
    public void setPartyayear(String partyayear) {
        this.partyayear = partyayear;
    }

    /**
     * 获取甲方签名日期月
     *
     * @return partyAMonth - 甲方签名日期月
     */
    public String getPartyamonth() {
        return partyamonth;
    }

    /**
     * 设置甲方签名日期月
     *
     * @param partyamonth 甲方签名日期月
     */
    public void setPartyamonth(String partyamonth) {
        this.partyamonth = partyamonth;
    }

    /**
     * 获取甲方签名日期日
     *
     * @return partyADay - 甲方签名日期日
     */
    public String getPartyaday() {
        return partyaday;
    }

    /**
     * 设置甲方签名日期日
     *
     * @param partyaday 甲方签名日期日
     */
    public void setPartyaday(String partyaday) {
        this.partyaday = partyaday;
    }

    /**
     * 获取乙方负责人
     *
     * @return partyBPrincipal - 乙方负责人
     */
    public String getPartybprincipal() {
        return partybprincipal;
    }

    /**
     * 设置乙方负责人
     *
     * @param partybprincipal 乙方负责人
     */
    public void setPartybprincipal(String partybprincipal) {
        this.partybprincipal = partybprincipal;
    }

    /**
     * 获取乙方签名日期年
     *
     * @return partyBYear - 乙方签名日期年
     */
    public String getPartybyear() {
        return partybyear;
    }

    /**
     * 设置乙方签名日期年
     *
     * @param partybyear 乙方签名日期年
     */
    public void setPartybyear(String partybyear) {
        this.partybyear = partybyear;
    }

    /**
     * 获取乙方签名日期月
     *
     * @return partyBMonth - 乙方签名日期月
     */
    public String getPartybmonth() {
        return partybmonth;
    }

    /**
     * 设置乙方签名日期月
     *
     * @param partybmonth 乙方签名日期月
     */
    public void setPartybmonth(String partybmonth) {
        this.partybmonth = partybmonth;
    }

    /**
     * 获取乙方签名日期日
     *
     * @return partyBDay - 乙方签名日期日
     */
    public String getPartybday() {
        return partybday;
    }

    /**
     * 设置乙方签名日期日
     *
     * @param partybday 乙方签名日期日
     */
    public void setPartybday(String partybday) {
        this.partybday = partybday;
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