package com.xmu.wowoto.wowomall.domain.po;

import java.time.LocalDateTime;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:地址
 * @Data:Created in 14:50 2019/12/11
 **/
public class AddressPo {

    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 城市id
     */
    private Integer cityId;
    /**
     * 省份id
     */
    private Integer provinceId;
    /**
     * 县区id
     */
    private Integer countyId;
    /**
     * 地址详情
     */
    private String addressDetail;
    /**
     * 联系电话
     */
    private String mobile;
    /**
     * 邮政编码
     */
    private String postalCode;
    /**
     * 收件人
     */
    private String consignee;
    /**
     * 是否是默认地址
     */
    private boolean beDefault;


    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
    private Boolean beDeleted;

    public Integer getId() {
        return this.id;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public Integer getCityId() {
        return this.cityId;
    }

    public Integer getProvinceId() {
        return this.provinceId;
    }

    public Integer getCountyId() {
        return this.countyId;
    }

    public String getAddressDetail() {
        return this.addressDetail;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getConsignee() {
        return this.consignee;
    }

    public boolean isBeDefault() {
        return this.beDefault;
    }

    public LocalDateTime getGmtCreate() {
        return this.gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return this.gmtModified;
    }

    public Boolean getBeDeleted() {
        return this.beDeleted;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public void setCountyId(Integer countyId) {
        this.countyId = countyId;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public void setBeDefault(boolean beDefault) {
        this.beDefault = beDefault;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    public void setBeDeleted(Boolean beDeleted) {
        this.beDeleted = beDeleted;
    }

    @Override
    public boolean equals(final Object o) {

        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AddressPo;
    }

    @Override
    public int hashCode() {

        return 0;
    }

    @Override
    public String toString() {
        return "AddressPo(id=" + this.getId() + ", userId=" + this.getUserId() + ", cityId=" + this.getCityId() + ", provinceId=" + this.getProvinceId() + ", countyId=" + this.getCountyId() + ", addressDetail=" + this.getAddressDetail() + ", mobile=" + this.getMobile() + ", postalCode=" + this.getPostalCode() + ", consignee=" + this.getConsignee() + ", beDefault=" + this.isBeDefault() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
