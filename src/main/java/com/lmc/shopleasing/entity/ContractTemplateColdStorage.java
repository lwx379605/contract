package com.lmc.shopleasing.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "s_contract_template_cold_storage")
public class ContractTemplateColdStorage {
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
     * 联系电话
     */
    private String phone;

    /**
     * 层数
     */
    @Column(name = "layer_number")
    private String layerNumber;

    /**
     * 库房号
     */
    @Column(name = "storeroom_number")
    private String storeroomNumber;

    /**
     * 面积
     */
    @Column(name = "area_square")
    private String areaSquare;

    /**
     * 储存品种
     */
    @Column(name = "storage_variety")
    private String storageVariety;

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
     * 租金总额
     */
    private String rent;

    /**
     * 租金总额大写
     */
    @Column(name = "rent_capital")
    private String rentCapital;

    /**
     * 管理费总额
     */
    @Column(name = "management_fee")
    private String managementFee;

    /**
     * 管理费总额大写
     */
    @Column(name = "management_fee_capital")
    private String managementFeeCapital;

    /**
     * 租金管理费总额
     */
    private String total;

    /**
     * 租金管理费总额大写
     */
    @Column(name = "total_capital")
    private String totalCapital;

    /**
     * 首年开始年
     */
    @Column(name = "first_start_year")
    private String firstStartYear;

    /**
     * 首年开始月
     */
    @Column(name = "first_start_month")
    private String firstStartMonth;

    /**
     * 首年开始日
     */
    @Column(name = "first_start_day")
    private String firstStartDay;

    /**
     * 首年结束年
     */
    @Column(name = "first_end_year")
    private String firstEndYear;

    /**
     * 首年结束月
     */
    @Column(name = "first_end_month")
    private String firstEndMonth;

    /**
     * 首年结束日
     */
    @Column(name = "first_end_day")
    private String firstEndDay;

    /**
     * 首年租金
     */
    @Column(name = "first_rent")
    private String firstRent;

    /**
     * 首年租金大写
     */
    @Column(name = "first_rent_capital")
    private String firstRentCapital;

    /**
     * 首年管理费
     */
    @Column(name = "first_management_fee")
    private String firstManagementFee;

    /**
     * 首年管理费大写
     */
    @Column(name = "first_management_fee_capital")
    private String firstManagementFeeCapital;

    /**
     * 首年租金管理费总计
     */
    @Column(name = "first_total")
    private String firstTotal;

    /**
     * 第二年开始年
     */
    @Column(name = "two_start_year")
    private String twoStartYear;

    /**
     * 第二年开始月
     */
    @Column(name = "two_start_month")
    private String twoStartMonth;

    /**
     * 第二年开始日
     */
    @Column(name = "two_start_day")
    private String twoStartDay;

    /**
     * 第二年结束年
     */
    @Column(name = "two_end_year")
    private String twoEndYear;

    /**
     * 第二年结束月
     */
    @Column(name = "two_end_month")
    private String twoEndMonth;

    /**
     * 第二年结束日
     */
    @Column(name = "two_end_day")
    private String twoEndDay;

    /**
     * 首年租期结束年
     */
    @Column(name = "first_lease_period_end_year")
    private String firstLeasePeriodEndYear;

    /**
     * 首年租期结束月
     */
    @Column(name = "first_lease_period_end_month")
    private String firstLeasePeriodEndMonth;

    /**
     * 首年租期结束日
     */
    @Column(name = "first_lease_period_end_day")
    private String firstLeasePeriodEndDay;

    /**
     * 第二年租金
     */
    @Column(name = "two_rent")
    private String twoRent;

    /**
     * 第二年租金大写
     */
    @Column(name = "two_rent_capital")
    private String twoRentCapital;

    /**
     * 第二年管理费
     */
    @Column(name = "two_managementfee")
    private String twoManagementfee;

    /**
     * 第二年管理费大写
     */
    @Column(name = "two_managementfee_capital")
    private String twoManagementfeeCapital;

    /**
     * 第二年租金管理费总计
     */
    @Column(name = "two_total")
    private String twoTotal;

    /**
     * 第三年开始年
     */
    @Column(name = "three_start_year")
    private String threeStartYear;

    /**
     * 第三年开始月
     */
    @Column(name = "three_start_month")
    private String threeStartMonth;

    /**
     * 第三年开始日
     */
    @Column(name = "three_start_day")
    private String threeStartDay;

    /**
     * 第三年结束年
     */
    @Column(name = "three_end_year")
    private String threeEndYear;

    /**
     * 第三年结束月
     */
    @Column(name = "three_end_month")
    private String threeEndMonth;

    /**
     * 第三年结束日
     */
    @Column(name = "three_end_day")
    private String threeEndDay;

    /**
     * 第二年租期结束年
     */
    @Column(name = "two_leaseperiod_end_year")
    private String twoLeaseperiodEndYear;

    /**
     * 第二年租期结束月
     */
    @Column(name = "two_leaseperiod_end_month")
    private String twoLeaseperiodEndMonth;

    /**
     * 第二年租期结束日
     */
    @Column(name = "two_leaseperiod_end_day")
    private String twoLeaseperiodEndDay;

    /**
     * 第三年租金
     */
    @Column(name = "three_rent")
    private String threeRent;

    /**
     * 第三年租金大写
     */
    @Column(name = "three_rent_capital")
    private String threeRentCapital;

    /**
     * 第三年管理费
     */
    @Column(name = "three_management_fee")
    private String threeManagementFee;

    /**
     * 第三年管理费大写
     */
    @Column(name = "three_management_fee_capital")
    private String threeManagementFeeCapital;

    /**
     * 第三年租金管理费总计
     */
    @Column(name = "three_total")
    private String threeTotal;

    /**
     * 保证金
     */
    @Column(name = "security_deposit")
    private String securityDeposit;

    /**
     * 保证金大写
     */
    @Column(name = "security_deposit_capital")
    private String securityDepositCapital;

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
    @Column(name = "party_a_uthorizedmanager")
    private String partyAUthorizedmanager;

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
    @Column(name = "party_b_legalrepresentative")
    private String partyBLegalrepresentative;

    /**
     * 授权经办人
     */
    @Column(name = "party_b_uthorizedmanager")
    private String partyBUthorizedmanager;

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
     * 甲方负责人
     */
    @Column(name = "party_a_principal")
    private String partyAPrincipal;

    /**
     * 甲方签名日期年
     */
    @Column(name = "party_a_year")
    private String partyAYear;

    /**
     * 甲方签名日期月
     */
    @Column(name = "party_a_month")
    private String partyAMonth;

    /**
     * 甲方签名日期日
     */
    @Column(name = "party_a_day")
    private String partyADay;

    /**
     * 乙方负责人
     */
    @Column(name = "party_b_principal")
    private String partyBPrincipal;

    /**
     * 乙方签名日期年
     */
    @Column(name = "party_b_year")
    private String partyBYear;

    /**
     * 乙方签名日期月
     */
    @Column(name = "party_b_month")
    private String partyBMonth;

    /**
     * 乙方签名日期日
     */
    @Column(name = "party_b_day")
    private String partyBDay;

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
     * 获取库房号
     *
     * @return storeroom_number - 库房号
     */
    public String getStoreroomNumber() {
        return storeroomNumber;
    }

    /**
     * 设置库房号
     *
     * @param storeroomNumber 库房号
     */
    public void setStoreroomNumber(String storeroomNumber) {
        this.storeroomNumber = storeroomNumber;
    }

    /**
     * 获取面积
     *
     * @return area_square - 面积
     */
    public String getAreaSquare() {
        return areaSquare;
    }

    /**
     * 设置面积
     *
     * @param areaSquare 面积
     */
    public void setAreaSquare(String areaSquare) {
        this.areaSquare = areaSquare;
    }

    /**
     * 获取储存品种
     *
     * @return storage_variety - 储存品种
     */
    public String getStorageVariety() {
        return storageVariety;
    }

    /**
     * 设置储存品种
     *
     * @param storageVariety 储存品种
     */
    public void setStorageVariety(String storageVariety) {
        this.storageVariety = storageVariety;
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
     * @return rent_capital - 租金总额大写
     */
    public String getRentCapital() {
        return rentCapital;
    }

    /**
     * 设置租金总额大写
     *
     * @param rentCapital 租金总额大写
     */
    public void setRentCapital(String rentCapital) {
        this.rentCapital = rentCapital;
    }

    /**
     * 获取管理费总额
     *
     * @return management_fee - 管理费总额
     */
    public String getManagementFee() {
        return managementFee;
    }

    /**
     * 设置管理费总额
     *
     * @param managementFee 管理费总额
     */
    public void setManagementFee(String managementFee) {
        this.managementFee = managementFee;
    }

    /**
     * 获取管理费总额大写
     *
     * @return management_fee_capital - 管理费总额大写
     */
    public String getManagementFeeCapital() {
        return managementFeeCapital;
    }

    /**
     * 设置管理费总额大写
     *
     * @param managementFeeCapital 管理费总额大写
     */
    public void setManagementFeeCapital(String managementFeeCapital) {
        this.managementFeeCapital = managementFeeCapital;
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
     * @return total_capital - 租金管理费总额大写
     */
    public String getTotalCapital() {
        return totalCapital;
    }

    /**
     * 设置租金管理费总额大写
     *
     * @param totalCapital 租金管理费总额大写
     */
    public void setTotalCapital(String totalCapital) {
        this.totalCapital = totalCapital;
    }

    /**
     * 获取首年开始年
     *
     * @return first_start_year - 首年开始年
     */
    public String getFirstStartYear() {
        return firstStartYear;
    }

    /**
     * 设置首年开始年
     *
     * @param firstStartYear 首年开始年
     */
    public void setFirstStartYear(String firstStartYear) {
        this.firstStartYear = firstStartYear;
    }

    /**
     * 获取首年开始月
     *
     * @return first_start_month - 首年开始月
     */
    public String getFirstStartMonth() {
        return firstStartMonth;
    }

    /**
     * 设置首年开始月
     *
     * @param firstStartMonth 首年开始月
     */
    public void setFirstStartMonth(String firstStartMonth) {
        this.firstStartMonth = firstStartMonth;
    }

    /**
     * 获取首年开始日
     *
     * @return first_start_day - 首年开始日
     */
    public String getFirstStartDay() {
        return firstStartDay;
    }

    /**
     * 设置首年开始日
     *
     * @param firstStartDay 首年开始日
     */
    public void setFirstStartDay(String firstStartDay) {
        this.firstStartDay = firstStartDay;
    }

    /**
     * 获取首年结束年
     *
     * @return first_end_year - 首年结束年
     */
    public String getFirstEndYear() {
        return firstEndYear;
    }

    /**
     * 设置首年结束年
     *
     * @param firstEndYear 首年结束年
     */
    public void setFirstEndYear(String firstEndYear) {
        this.firstEndYear = firstEndYear;
    }

    /**
     * 获取首年结束月
     *
     * @return first_end_month - 首年结束月
     */
    public String getFirstEndMonth() {
        return firstEndMonth;
    }

    /**
     * 设置首年结束月
     *
     * @param firstEndMonth 首年结束月
     */
    public void setFirstEndMonth(String firstEndMonth) {
        this.firstEndMonth = firstEndMonth;
    }

    /**
     * 获取首年结束日
     *
     * @return first_end_day - 首年结束日
     */
    public String getFirstEndDay() {
        return firstEndDay;
    }

    /**
     * 设置首年结束日
     *
     * @param firstEndDay 首年结束日
     */
    public void setFirstEndDay(String firstEndDay) {
        this.firstEndDay = firstEndDay;
    }

    /**
     * 获取首年租金
     *
     * @return first_rent - 首年租金
     */
    public String getFirstRent() {
        return firstRent;
    }

    /**
     * 设置首年租金
     *
     * @param firstRent 首年租金
     */
    public void setFirstRent(String firstRent) {
        this.firstRent = firstRent;
    }

    /**
     * 获取首年租金大写
     *
     * @return first_rent_capital - 首年租金大写
     */
    public String getFirstRentCapital() {
        return firstRentCapital;
    }

    /**
     * 设置首年租金大写
     *
     * @param firstRentCapital 首年租金大写
     */
    public void setFirstRentCapital(String firstRentCapital) {
        this.firstRentCapital = firstRentCapital;
    }

    /**
     * 获取首年管理费
     *
     * @return first_management_fee - 首年管理费
     */
    public String getFirstManagementFee() {
        return firstManagementFee;
    }

    /**
     * 设置首年管理费
     *
     * @param firstManagementFee 首年管理费
     */
    public void setFirstManagementFee(String firstManagementFee) {
        this.firstManagementFee = firstManagementFee;
    }

    /**
     * 获取首年管理费大写
     *
     * @return first_management_fee_capital - 首年管理费大写
     */
    public String getFirstManagementFeeCapital() {
        return firstManagementFeeCapital;
    }

    /**
     * 设置首年管理费大写
     *
     * @param firstManagementFeeCapital 首年管理费大写
     */
    public void setFirstManagementFeeCapital(String firstManagementFeeCapital) {
        this.firstManagementFeeCapital = firstManagementFeeCapital;
    }

    /**
     * 获取首年租金管理费总计
     *
     * @return first_total - 首年租金管理费总计
     */
    public String getFirstTotal() {
        return firstTotal;
    }

    /**
     * 设置首年租金管理费总计
     *
     * @param firstTotal 首年租金管理费总计
     */
    public void setFirstTotal(String firstTotal) {
        this.firstTotal = firstTotal;
    }

    /**
     * 获取第二年开始年
     *
     * @return two_start_year - 第二年开始年
     */
    public String getTwoStartYear() {
        return twoStartYear;
    }

    /**
     * 设置第二年开始年
     *
     * @param twoStartYear 第二年开始年
     */
    public void setTwoStartYear(String twoStartYear) {
        this.twoStartYear = twoStartYear;
    }

    /**
     * 获取第二年开始月
     *
     * @return two_start_month - 第二年开始月
     */
    public String getTwoStartMonth() {
        return twoStartMonth;
    }

    /**
     * 设置第二年开始月
     *
     * @param twoStartMonth 第二年开始月
     */
    public void setTwoStartMonth(String twoStartMonth) {
        this.twoStartMonth = twoStartMonth;
    }

    /**
     * 获取第二年开始日
     *
     * @return two_start_day - 第二年开始日
     */
    public String getTwoStartDay() {
        return twoStartDay;
    }

    /**
     * 设置第二年开始日
     *
     * @param twoStartDay 第二年开始日
     */
    public void setTwoStartDay(String twoStartDay) {
        this.twoStartDay = twoStartDay;
    }

    /**
     * 获取第二年结束年
     *
     * @return two_end_year - 第二年结束年
     */
    public String getTwoEndYear() {
        return twoEndYear;
    }

    /**
     * 设置第二年结束年
     *
     * @param twoEndYear 第二年结束年
     */
    public void setTwoEndYear(String twoEndYear) {
        this.twoEndYear = twoEndYear;
    }

    /**
     * 获取第二年结束月
     *
     * @return two_end_month - 第二年结束月
     */
    public String getTwoEndMonth() {
        return twoEndMonth;
    }

    /**
     * 设置第二年结束月
     *
     * @param twoEndMonth 第二年结束月
     */
    public void setTwoEndMonth(String twoEndMonth) {
        this.twoEndMonth = twoEndMonth;
    }

    /**
     * 获取第二年结束日
     *
     * @return two_end_day - 第二年结束日
     */
    public String getTwoEndDay() {
        return twoEndDay;
    }

    /**
     * 设置第二年结束日
     *
     * @param twoEndDay 第二年结束日
     */
    public void setTwoEndDay(String twoEndDay) {
        this.twoEndDay = twoEndDay;
    }

    /**
     * 获取首年租期结束年
     *
     * @return first_lease_period_end_year - 首年租期结束年
     */
    public String getFirstLeasePeriodEndYear() {
        return firstLeasePeriodEndYear;
    }

    /**
     * 设置首年租期结束年
     *
     * @param firstLeasePeriodEndYear 首年租期结束年
     */
    public void setFirstLeasePeriodEndYear(String firstLeasePeriodEndYear) {
        this.firstLeasePeriodEndYear = firstLeasePeriodEndYear;
    }

    /**
     * 获取首年租期结束月
     *
     * @return first_lease_period_end_month - 首年租期结束月
     */
    public String getFirstLeasePeriodEndMonth() {
        return firstLeasePeriodEndMonth;
    }

    /**
     * 设置首年租期结束月
     *
     * @param firstLeasePeriodEndMonth 首年租期结束月
     */
    public void setFirstLeasePeriodEndMonth(String firstLeasePeriodEndMonth) {
        this.firstLeasePeriodEndMonth = firstLeasePeriodEndMonth;
    }

    /**
     * 获取首年租期结束日
     *
     * @return first_lease_period_end_day - 首年租期结束日
     */
    public String getFirstLeasePeriodEndDay() {
        return firstLeasePeriodEndDay;
    }

    /**
     * 设置首年租期结束日
     *
     * @param firstLeasePeriodEndDay 首年租期结束日
     */
    public void setFirstLeasePeriodEndDay(String firstLeasePeriodEndDay) {
        this.firstLeasePeriodEndDay = firstLeasePeriodEndDay;
    }

    /**
     * 获取第二年租金
     *
     * @return two_rent - 第二年租金
     */
    public String getTwoRent() {
        return twoRent;
    }

    /**
     * 设置第二年租金
     *
     * @param twoRent 第二年租金
     */
    public void setTwoRent(String twoRent) {
        this.twoRent = twoRent;
    }

    /**
     * 获取第二年租金大写
     *
     * @return two_rent_capital - 第二年租金大写
     */
    public String getTwoRentCapital() {
        return twoRentCapital;
    }

    /**
     * 设置第二年租金大写
     *
     * @param twoRentCapital 第二年租金大写
     */
    public void setTwoRentCapital(String twoRentCapital) {
        this.twoRentCapital = twoRentCapital;
    }

    /**
     * 获取第二年管理费
     *
     * @return two_managementfee - 第二年管理费
     */
    public String getTwoManagementfee() {
        return twoManagementfee;
    }

    /**
     * 设置第二年管理费
     *
     * @param twoManagementfee 第二年管理费
     */
    public void setTwoManagementfee(String twoManagementfee) {
        this.twoManagementfee = twoManagementfee;
    }

    /**
     * 获取第二年管理费大写
     *
     * @return two_managementfee_capital - 第二年管理费大写
     */
    public String getTwoManagementfeeCapital() {
        return twoManagementfeeCapital;
    }

    /**
     * 设置第二年管理费大写
     *
     * @param twoManagementfeeCapital 第二年管理费大写
     */
    public void setTwoManagementfeeCapital(String twoManagementfeeCapital) {
        this.twoManagementfeeCapital = twoManagementfeeCapital;
    }

    /**
     * 获取第二年租金管理费总计
     *
     * @return two_total - 第二年租金管理费总计
     */
    public String getTwoTotal() {
        return twoTotal;
    }

    /**
     * 设置第二年租金管理费总计
     *
     * @param twoTotal 第二年租金管理费总计
     */
    public void setTwoTotal(String twoTotal) {
        this.twoTotal = twoTotal;
    }

    /**
     * 获取第三年开始年
     *
     * @return three_start_year - 第三年开始年
     */
    public String getThreeStartYear() {
        return threeStartYear;
    }

    /**
     * 设置第三年开始年
     *
     * @param threeStartYear 第三年开始年
     */
    public void setThreeStartYear(String threeStartYear) {
        this.threeStartYear = threeStartYear;
    }

    /**
     * 获取第三年开始月
     *
     * @return three_start_month - 第三年开始月
     */
    public String getThreeStartMonth() {
        return threeStartMonth;
    }

    /**
     * 设置第三年开始月
     *
     * @param threeStartMonth 第三年开始月
     */
    public void setThreeStartMonth(String threeStartMonth) {
        this.threeStartMonth = threeStartMonth;
    }

    /**
     * 获取第三年开始日
     *
     * @return three_start_day - 第三年开始日
     */
    public String getThreeStartDay() {
        return threeStartDay;
    }

    /**
     * 设置第三年开始日
     *
     * @param threeStartDay 第三年开始日
     */
    public void setThreeStartDay(String threeStartDay) {
        this.threeStartDay = threeStartDay;
    }

    /**
     * 获取第三年结束年
     *
     * @return three_end_year - 第三年结束年
     */
    public String getThreeEndYear() {
        return threeEndYear;
    }

    /**
     * 设置第三年结束年
     *
     * @param threeEndYear 第三年结束年
     */
    public void setThreeEndYear(String threeEndYear) {
        this.threeEndYear = threeEndYear;
    }

    /**
     * 获取第三年结束月
     *
     * @return three_end_month - 第三年结束月
     */
    public String getThreeEndMonth() {
        return threeEndMonth;
    }

    /**
     * 设置第三年结束月
     *
     * @param threeEndMonth 第三年结束月
     */
    public void setThreeEndMonth(String threeEndMonth) {
        this.threeEndMonth = threeEndMonth;
    }

    /**
     * 获取第三年结束日
     *
     * @return three_end_day - 第三年结束日
     */
    public String getThreeEndDay() {
        return threeEndDay;
    }

    /**
     * 设置第三年结束日
     *
     * @param threeEndDay 第三年结束日
     */
    public void setThreeEndDay(String threeEndDay) {
        this.threeEndDay = threeEndDay;
    }

    /**
     * 获取第二年租期结束年
     *
     * @return two_leaseperiod_end_year - 第二年租期结束年
     */
    public String getTwoLeaseperiodEndYear() {
        return twoLeaseperiodEndYear;
    }

    /**
     * 设置第二年租期结束年
     *
     * @param twoLeaseperiodEndYear 第二年租期结束年
     */
    public void setTwoLeaseperiodEndYear(String twoLeaseperiodEndYear) {
        this.twoLeaseperiodEndYear = twoLeaseperiodEndYear;
    }

    /**
     * 获取第二年租期结束月
     *
     * @return two_leaseperiod_end_month - 第二年租期结束月
     */
    public String getTwoLeaseperiodEndMonth() {
        return twoLeaseperiodEndMonth;
    }

    /**
     * 设置第二年租期结束月
     *
     * @param twoLeaseperiodEndMonth 第二年租期结束月
     */
    public void setTwoLeaseperiodEndMonth(String twoLeaseperiodEndMonth) {
        this.twoLeaseperiodEndMonth = twoLeaseperiodEndMonth;
    }

    /**
     * 获取第二年租期结束日
     *
     * @return two_leaseperiod_end_day - 第二年租期结束日
     */
    public String getTwoLeaseperiodEndDay() {
        return twoLeaseperiodEndDay;
    }

    /**
     * 设置第二年租期结束日
     *
     * @param twoLeaseperiodEndDay 第二年租期结束日
     */
    public void setTwoLeaseperiodEndDay(String twoLeaseperiodEndDay) {
        this.twoLeaseperiodEndDay = twoLeaseperiodEndDay;
    }

    /**
     * 获取第三年租金
     *
     * @return three_rent - 第三年租金
     */
    public String getThreeRent() {
        return threeRent;
    }

    /**
     * 设置第三年租金
     *
     * @param threeRent 第三年租金
     */
    public void setThreeRent(String threeRent) {
        this.threeRent = threeRent;
    }

    /**
     * 获取第三年租金大写
     *
     * @return three_rent_capital - 第三年租金大写
     */
    public String getThreeRentCapital() {
        return threeRentCapital;
    }

    /**
     * 设置第三年租金大写
     *
     * @param threeRentCapital 第三年租金大写
     */
    public void setThreeRentCapital(String threeRentCapital) {
        this.threeRentCapital = threeRentCapital;
    }

    /**
     * 获取第三年管理费
     *
     * @return three_management_fee - 第三年管理费
     */
    public String getThreeManagementFee() {
        return threeManagementFee;
    }

    /**
     * 设置第三年管理费
     *
     * @param threeManagementFee 第三年管理费
     */
    public void setThreeManagementFee(String threeManagementFee) {
        this.threeManagementFee = threeManagementFee;
    }

    /**
     * 获取第三年管理费大写
     *
     * @return three_management_fee_capital - 第三年管理费大写
     */
    public String getThreeManagementFeeCapital() {
        return threeManagementFeeCapital;
    }

    /**
     * 设置第三年管理费大写
     *
     * @param threeManagementFeeCapital 第三年管理费大写
     */
    public void setThreeManagementFeeCapital(String threeManagementFeeCapital) {
        this.threeManagementFeeCapital = threeManagementFeeCapital;
    }

    /**
     * 获取第三年租金管理费总计
     *
     * @return three_total - 第三年租金管理费总计
     */
    public String getThreeTotal() {
        return threeTotal;
    }

    /**
     * 设置第三年租金管理费总计
     *
     * @param threeTotal 第三年租金管理费总计
     */
    public void setThreeTotal(String threeTotal) {
        this.threeTotal = threeTotal;
    }

    /**
     * 获取保证金
     *
     * @return security_deposit - 保证金
     */
    public String getSecurityDeposit() {
        return securityDeposit;
    }

    /**
     * 设置保证金
     *
     * @param securityDeposit 保证金
     */
    public void setSecurityDeposit(String securityDeposit) {
        this.securityDeposit = securityDeposit;
    }

    /**
     * 获取保证金大写
     *
     * @return security_deposit_capital - 保证金大写
     */
    public String getSecurityDepositCapital() {
        return securityDepositCapital;
    }

    /**
     * 设置保证金大写
     *
     * @param securityDepositCapital 保证金大写
     */
    public void setSecurityDepositCapital(String securityDepositCapital) {
        this.securityDepositCapital = securityDepositCapital;
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
     * @return party_a_uthorizedmanager - 授权经办人
     */
    public String getPartyAUthorizedmanager() {
        return partyAUthorizedmanager;
    }

    /**
     * 设置授权经办人
     *
     * @param partyAUthorizedmanager 授权经办人
     */
    public void setPartyAUthorizedmanager(String partyAUthorizedmanager) {
        this.partyAUthorizedmanager = partyAUthorizedmanager;
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
     * @return party_b_legalrepresentative - 法定代表人
     */
    public String getPartyBLegalrepresentative() {
        return partyBLegalrepresentative;
    }

    /**
     * 设置法定代表人
     *
     * @param partyBLegalrepresentative 法定代表人
     */
    public void setPartyBLegalrepresentative(String partyBLegalrepresentative) {
        this.partyBLegalrepresentative = partyBLegalrepresentative;
    }

    /**
     * 获取授权经办人
     *
     * @return party_b_uthorizedmanager - 授权经办人
     */
    public String getPartyBUthorizedmanager() {
        return partyBUthorizedmanager;
    }

    /**
     * 设置授权经办人
     *
     * @param partyBUthorizedmanager 授权经办人
     */
    public void setPartyBUthorizedmanager(String partyBUthorizedmanager) {
        this.partyBUthorizedmanager = partyBUthorizedmanager;
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
     * 获取甲方负责人
     *
     * @return party_a_principal - 甲方负责人
     */
    public String getPartyAPrincipal() {
        return partyAPrincipal;
    }

    /**
     * 设置甲方负责人
     *
     * @param partyAPrincipal 甲方负责人
     */
    public void setPartyAPrincipal(String partyAPrincipal) {
        this.partyAPrincipal = partyAPrincipal;
    }

    /**
     * 获取甲方签名日期年
     *
     * @return party_a_year - 甲方签名日期年
     */
    public String getPartyAYear() {
        return partyAYear;
    }

    /**
     * 设置甲方签名日期年
     *
     * @param partyAYear 甲方签名日期年
     */
    public void setPartyAYear(String partyAYear) {
        this.partyAYear = partyAYear;
    }

    /**
     * 获取甲方签名日期月
     *
     * @return party_a_month - 甲方签名日期月
     */
    public String getPartyAMonth() {
        return partyAMonth;
    }

    /**
     * 设置甲方签名日期月
     *
     * @param partyAMonth 甲方签名日期月
     */
    public void setPartyAMonth(String partyAMonth) {
        this.partyAMonth = partyAMonth;
    }

    /**
     * 获取甲方签名日期日
     *
     * @return party_a_day - 甲方签名日期日
     */
    public String getPartyADay() {
        return partyADay;
    }

    /**
     * 设置甲方签名日期日
     *
     * @param partyADay 甲方签名日期日
     */
    public void setPartyADay(String partyADay) {
        this.partyADay = partyADay;
    }

    /**
     * 获取乙方负责人
     *
     * @return party_b_principal - 乙方负责人
     */
    public String getPartyBPrincipal() {
        return partyBPrincipal;
    }

    /**
     * 设置乙方负责人
     *
     * @param partyBPrincipal 乙方负责人
     */
    public void setPartyBPrincipal(String partyBPrincipal) {
        this.partyBPrincipal = partyBPrincipal;
    }

    /**
     * 获取乙方签名日期年
     *
     * @return party_b_year - 乙方签名日期年
     */
    public String getPartyBYear() {
        return partyBYear;
    }

    /**
     * 设置乙方签名日期年
     *
     * @param partyBYear 乙方签名日期年
     */
    public void setPartyBYear(String partyBYear) {
        this.partyBYear = partyBYear;
    }

    /**
     * 获取乙方签名日期月
     *
     * @return party_b_month - 乙方签名日期月
     */
    public String getPartyBMonth() {
        return partyBMonth;
    }

    /**
     * 设置乙方签名日期月
     *
     * @param partyBMonth 乙方签名日期月
     */
    public void setPartyBMonth(String partyBMonth) {
        this.partyBMonth = partyBMonth;
    }

    /**
     * 获取乙方签名日期日
     *
     * @return party_b_day - 乙方签名日期日
     */
    public String getPartyBDay() {
        return partyBDay;
    }

    /**
     * 设置乙方签名日期日
     *
     * @param partyBDay 乙方签名日期日
     */
    public void setPartyBDay(String partyBDay) {
        this.partyBDay = partyBDay;
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