package com.lmc.shopleasing.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "s_contract_template_warehouse")
public class ContractTemplateWarehouse {
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
     * 联系电话
     */
    private String phone;

    /**
     * 建筑物号
     */
    @Column(name = "buildingNumber")
    private String buildingnumber;

    /**
     * 库房号
     */
    @Column(name = "storeroomNumber")
    private String storeroomnumber;

    /**
     * 面积
     */
    @Column(name = "areaSquare")
    private String areasquare;

    /**
     * 合计面积
     */
    @Column(name = "areaSquareTotal")
    private String areasquaretotal;

    /**
     * 间数总计
     */
    private String rooms;

    /**
     * 储存品种
     */
    @Column(name = "storageVariety")
    private String storagevariety;

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
     * 租金及管理费总计
     */
    private String total;

    /**
     * 租金及管理费总计大写
     */
    @Column(name = "totalCapital")
    private String totalcapital;

    /**
     * 第一年租金元/m²
     */
    @Column(name = "firstRent")
    private String firstrent;

    /**
     * 第一年租金总额
     */
    @Column(name = "firstRentTotal")
    private String firstrenttotal;

    /**
     * 第一年租金总额大写
     */
    @Column(name = "firstRentTotalCapital")
    private String firstrenttotalcapital;

    /**
     * 第一年管理费总额
     */
    @Column(name = "firstManagementFee")
    private String firstmanagementfee;

    /**
     * 第一年管理费总额大写
     */
    @Column(name = "firstManagementFeeCapital")
    private String firstmanagementfeecapital;

    /**
     * 第一年首付租金和管理费总额
     */
    @Column(name = "firstDownPayment")
    private String firstdownpayment;

    /**
     * 第一年首付租金和管理费总额大写
     */
    @Column(name = "firstDownPaymentCapital")
    private String firstdownpaymentcapital;

    /**
     * 第二年租金元/m²
     */
    @Column(name = "twoRent")
    private String tworent;

    /**
     * 第二年租金总额
     */
    @Column(name = "twoRentTotal")
    private String tworenttotal;

    /**
     * 第二年租金总额大写
     */
    @Column(name = "twoRentTotalCapital")
    private String tworenttotalcapital;

    /**
     * 第二年管理费总额
     */
    @Column(name = "twoManagementFee")
    private String twomanagementfee;

    /**
     * 第二年管理费总额大写
     */
    @Column(name = "twoManagementFeeCapital")
    private String twomanagementfeecapital;

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
     * 第二年首付租金和管理费总额
     */
    @Column(name = "twoDownPayment")
    private String twodownpayment;

    /**
     * 第二年首付租金和管理费总额大写
     */
    @Column(name = "twoDownPaymentCapital")
    private String twodownpaymentcapital;

    /**
     * 第三年租金元/m²
     */
    @Column(name = "threeRent")
    private String threerent;

    /**
     * 第三年租金总额
     */
    @Column(name = "threeRentTotal")
    private String threerenttotal;

    /**
     * 第三年租金总额大写
     */
    @Column(name = "threeRentTotalCapital")
    private String threerenttotalcapital;

    /**
     * 第三年管理费总额
     */
    @Column(name = "threeManagementFee")
    private String threemanagementfee;

    /**
     * 第三年管理费总额大写
     */
    @Column(name = "threeManagementFeeCapital")
    private String threemanagementfeecapital;

    /**
     * 第二年租期结束年
     */
    @Column(name = "twoLeasePeriodEndYear")
    private String twoleaseperiodendyear;

    /**
     * 第二年租期结束月
     */
    @Column(name = "twoLeasePeriodEndMonth")
    private String twoleaseperiodendmonth;

    /**
     * 第二年租期结束日
     */
    @Column(name = "twoLeasePeriodEndDay")
    private String twoleaseperiodendday;

    /**
     * 第三年首付租金和管理费总额
     */
    @Column(name = "threeDownPayment")
    private String threedownpayment;

    /**
     * 第三年首付租金和管理费总额大写
     */
    @Column(name = "threeDownPaymentCapital")
    private String threedownpaymentcapital;

    /**
     * 电费元/度
     */
    @Column(name = "electricityFee")
    private String electricityfee;

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
     * 获取库房号
     *
     * @return storeroomNumber - 库房号
     */
    public String getStoreroomnumber() {
        return storeroomnumber;
    }

    /**
     * 设置库房号
     *
     * @param storeroomnumber 库房号
     */
    public void setStoreroomnumber(String storeroomnumber) {
        this.storeroomnumber = storeroomnumber;
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
     * 获取合计面积
     *
     * @return areaSquareTotal - 合计面积
     */
    public String getAreasquaretotal() {
        return areasquaretotal;
    }

    /**
     * 设置合计面积
     *
     * @param areasquaretotal 合计面积
     */
    public void setAreasquaretotal(String areasquaretotal) {
        this.areasquaretotal = areasquaretotal;
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
     * 获取储存品种
     *
     * @return storageVariety - 储存品种
     */
    public String getStoragevariety() {
        return storagevariety;
    }

    /**
     * 设置储存品种
     *
     * @param storagevariety 储存品种
     */
    public void setStoragevariety(String storagevariety) {
        this.storagevariety = storagevariety;
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
     * 获取租金及管理费总计
     *
     * @return total - 租金及管理费总计
     */
    public String getTotal() {
        return total;
    }

    /**
     * 设置租金及管理费总计
     *
     * @param total 租金及管理费总计
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * 获取租金及管理费总计大写
     *
     * @return totalCapital - 租金及管理费总计大写
     */
    public String getTotalcapital() {
        return totalcapital;
    }

    /**
     * 设置租金及管理费总计大写
     *
     * @param totalcapital 租金及管理费总计大写
     */
    public void setTotalcapital(String totalcapital) {
        this.totalcapital = totalcapital;
    }

    /**
     * 获取第一年租金元/m²
     *
     * @return firstRent - 第一年租金元/m²
     */
    public String getFirstrent() {
        return firstrent;
    }

    /**
     * 设置第一年租金元/m²
     *
     * @param firstrent 第一年租金元/m²
     */
    public void setFirstrent(String firstrent) {
        this.firstrent = firstrent;
    }

    /**
     * 获取第一年租金总额
     *
     * @return firstRentTotal - 第一年租金总额
     */
    public String getFirstrenttotal() {
        return firstrenttotal;
    }

    /**
     * 设置第一年租金总额
     *
     * @param firstrenttotal 第一年租金总额
     */
    public void setFirstrenttotal(String firstrenttotal) {
        this.firstrenttotal = firstrenttotal;
    }

    /**
     * 获取第一年租金总额大写
     *
     * @return firstRentTotalCapital - 第一年租金总额大写
     */
    public String getFirstrenttotalcapital() {
        return firstrenttotalcapital;
    }

    /**
     * 设置第一年租金总额大写
     *
     * @param firstrenttotalcapital 第一年租金总额大写
     */
    public void setFirstrenttotalcapital(String firstrenttotalcapital) {
        this.firstrenttotalcapital = firstrenttotalcapital;
    }

    /**
     * 获取第一年管理费总额
     *
     * @return firstManagementFee - 第一年管理费总额
     */
    public String getFirstmanagementfee() {
        return firstmanagementfee;
    }

    /**
     * 设置第一年管理费总额
     *
     * @param firstmanagementfee 第一年管理费总额
     */
    public void setFirstmanagementfee(String firstmanagementfee) {
        this.firstmanagementfee = firstmanagementfee;
    }

    /**
     * 获取第一年管理费总额大写
     *
     * @return firstManagementFeeCapital - 第一年管理费总额大写
     */
    public String getFirstmanagementfeecapital() {
        return firstmanagementfeecapital;
    }

    /**
     * 设置第一年管理费总额大写
     *
     * @param firstmanagementfeecapital 第一年管理费总额大写
     */
    public void setFirstmanagementfeecapital(String firstmanagementfeecapital) {
        this.firstmanagementfeecapital = firstmanagementfeecapital;
    }

    /**
     * 获取第一年首付租金和管理费总额
     *
     * @return firstDownPayment - 第一年首付租金和管理费总额
     */
    public String getFirstdownpayment() {
        return firstdownpayment;
    }

    /**
     * 设置第一年首付租金和管理费总额
     *
     * @param firstdownpayment 第一年首付租金和管理费总额
     */
    public void setFirstdownpayment(String firstdownpayment) {
        this.firstdownpayment = firstdownpayment;
    }

    /**
     * 获取第一年首付租金和管理费总额大写
     *
     * @return firstDownPaymentCapital - 第一年首付租金和管理费总额大写
     */
    public String getFirstdownpaymentcapital() {
        return firstdownpaymentcapital;
    }

    /**
     * 设置第一年首付租金和管理费总额大写
     *
     * @param firstdownpaymentcapital 第一年首付租金和管理费总额大写
     */
    public void setFirstdownpaymentcapital(String firstdownpaymentcapital) {
        this.firstdownpaymentcapital = firstdownpaymentcapital;
    }

    /**
     * 获取第二年租金元/m²
     *
     * @return twoRent - 第二年租金元/m²
     */
    public String getTworent() {
        return tworent;
    }

    /**
     * 设置第二年租金元/m²
     *
     * @param tworent 第二年租金元/m²
     */
    public void setTworent(String tworent) {
        this.tworent = tworent;
    }

    /**
     * 获取第二年租金总额
     *
     * @return twoRentTotal - 第二年租金总额
     */
    public String getTworenttotal() {
        return tworenttotal;
    }

    /**
     * 设置第二年租金总额
     *
     * @param tworenttotal 第二年租金总额
     */
    public void setTworenttotal(String tworenttotal) {
        this.tworenttotal = tworenttotal;
    }

    /**
     * 获取第二年租金总额大写
     *
     * @return twoRentTotalCapital - 第二年租金总额大写
     */
    public String getTworenttotalcapital() {
        return tworenttotalcapital;
    }

    /**
     * 设置第二年租金总额大写
     *
     * @param tworenttotalcapital 第二年租金总额大写
     */
    public void setTworenttotalcapital(String tworenttotalcapital) {
        this.tworenttotalcapital = tworenttotalcapital;
    }

    /**
     * 获取第二年管理费总额
     *
     * @return twoManagementFee - 第二年管理费总额
     */
    public String getTwomanagementfee() {
        return twomanagementfee;
    }

    /**
     * 设置第二年管理费总额
     *
     * @param twomanagementfee 第二年管理费总额
     */
    public void setTwomanagementfee(String twomanagementfee) {
        this.twomanagementfee = twomanagementfee;
    }

    /**
     * 获取第二年管理费总额大写
     *
     * @return twoManagementFeeCapital - 第二年管理费总额大写
     */
    public String getTwomanagementfeecapital() {
        return twomanagementfeecapital;
    }

    /**
     * 设置第二年管理费总额大写
     *
     * @param twomanagementfeecapital 第二年管理费总额大写
     */
    public void setTwomanagementfeecapital(String twomanagementfeecapital) {
        this.twomanagementfeecapital = twomanagementfeecapital;
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
     * 获取第二年首付租金和管理费总额
     *
     * @return twoDownPayment - 第二年首付租金和管理费总额
     */
    public String getTwodownpayment() {
        return twodownpayment;
    }

    /**
     * 设置第二年首付租金和管理费总额
     *
     * @param twodownpayment 第二年首付租金和管理费总额
     */
    public void setTwodownpayment(String twodownpayment) {
        this.twodownpayment = twodownpayment;
    }

    /**
     * 获取第二年首付租金和管理费总额大写
     *
     * @return twoDownPaymentCapital - 第二年首付租金和管理费总额大写
     */
    public String getTwodownpaymentcapital() {
        return twodownpaymentcapital;
    }

    /**
     * 设置第二年首付租金和管理费总额大写
     *
     * @param twodownpaymentcapital 第二年首付租金和管理费总额大写
     */
    public void setTwodownpaymentcapital(String twodownpaymentcapital) {
        this.twodownpaymentcapital = twodownpaymentcapital;
    }

    /**
     * 获取第三年租金元/m²
     *
     * @return threeRent - 第三年租金元/m²
     */
    public String getThreerent() {
        return threerent;
    }

    /**
     * 设置第三年租金元/m²
     *
     * @param threerent 第三年租金元/m²
     */
    public void setThreerent(String threerent) {
        this.threerent = threerent;
    }

    /**
     * 获取第三年租金总额
     *
     * @return threeRentTotal - 第三年租金总额
     */
    public String getThreerenttotal() {
        return threerenttotal;
    }

    /**
     * 设置第三年租金总额
     *
     * @param threerenttotal 第三年租金总额
     */
    public void setThreerenttotal(String threerenttotal) {
        this.threerenttotal = threerenttotal;
    }

    /**
     * 获取第三年租金总额大写
     *
     * @return threeRentTotalCapital - 第三年租金总额大写
     */
    public String getThreerenttotalcapital() {
        return threerenttotalcapital;
    }

    /**
     * 设置第三年租金总额大写
     *
     * @param threerenttotalcapital 第三年租金总额大写
     */
    public void setThreerenttotalcapital(String threerenttotalcapital) {
        this.threerenttotalcapital = threerenttotalcapital;
    }

    /**
     * 获取第三年管理费总额
     *
     * @return threeManagementFee - 第三年管理费总额
     */
    public String getThreemanagementfee() {
        return threemanagementfee;
    }

    /**
     * 设置第三年管理费总额
     *
     * @param threemanagementfee 第三年管理费总额
     */
    public void setThreemanagementfee(String threemanagementfee) {
        this.threemanagementfee = threemanagementfee;
    }

    /**
     * 获取第三年管理费总额大写
     *
     * @return threeManagementFeeCapital - 第三年管理费总额大写
     */
    public String getThreemanagementfeecapital() {
        return threemanagementfeecapital;
    }

    /**
     * 设置第三年管理费总额大写
     *
     * @param threemanagementfeecapital 第三年管理费总额大写
     */
    public void setThreemanagementfeecapital(String threemanagementfeecapital) {
        this.threemanagementfeecapital = threemanagementfeecapital;
    }

    /**
     * 获取第二年租期结束年
     *
     * @return twoLeasePeriodEndYear - 第二年租期结束年
     */
    public String getTwoleaseperiodendyear() {
        return twoleaseperiodendyear;
    }

    /**
     * 设置第二年租期结束年
     *
     * @param twoleaseperiodendyear 第二年租期结束年
     */
    public void setTwoleaseperiodendyear(String twoleaseperiodendyear) {
        this.twoleaseperiodendyear = twoleaseperiodendyear;
    }

    /**
     * 获取第二年租期结束月
     *
     * @return twoLeasePeriodEndMonth - 第二年租期结束月
     */
    public String getTwoleaseperiodendmonth() {
        return twoleaseperiodendmonth;
    }

    /**
     * 设置第二年租期结束月
     *
     * @param twoleaseperiodendmonth 第二年租期结束月
     */
    public void setTwoleaseperiodendmonth(String twoleaseperiodendmonth) {
        this.twoleaseperiodendmonth = twoleaseperiodendmonth;
    }

    /**
     * 获取第二年租期结束日
     *
     * @return twoLeasePeriodEndDay - 第二年租期结束日
     */
    public String getTwoleaseperiodendday() {
        return twoleaseperiodendday;
    }

    /**
     * 设置第二年租期结束日
     *
     * @param twoleaseperiodendday 第二年租期结束日
     */
    public void setTwoleaseperiodendday(String twoleaseperiodendday) {
        this.twoleaseperiodendday = twoleaseperiodendday;
    }

    /**
     * 获取第三年首付租金和管理费总额
     *
     * @return threeDownPayment - 第三年首付租金和管理费总额
     */
    public String getThreedownpayment() {
        return threedownpayment;
    }

    /**
     * 设置第三年首付租金和管理费总额
     *
     * @param threedownpayment 第三年首付租金和管理费总额
     */
    public void setThreedownpayment(String threedownpayment) {
        this.threedownpayment = threedownpayment;
    }

    /**
     * 获取第三年首付租金和管理费总额大写
     *
     * @return threeDownPaymentCapital - 第三年首付租金和管理费总额大写
     */
    public String getThreedownpaymentcapital() {
        return threedownpaymentcapital;
    }

    /**
     * 设置第三年首付租金和管理费总额大写
     *
     * @param threedownpaymentcapital 第三年首付租金和管理费总额大写
     */
    public void setThreedownpaymentcapital(String threedownpaymentcapital) {
        this.threedownpaymentcapital = threedownpaymentcapital;
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