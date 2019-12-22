package com.xmu.wowoto.wowomall.domain.Po;

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
        if (o == this) {return true;}
        if (!(o instanceof AddressPo)){ return false;}
        final AddressPo other = (AddressPo) o;
        if (!other.canEqual((Object) this)) {return false;}
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)){ return false;}
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)){ return false;}
        final Object this$cityId = this.getCityId();
        final Object other$cityId = other.getCityId();
        if (this$cityId == null ? other$cityId != null : !this$cityId.equals(other$cityId)) {return false;}
        final Object this$provinceId = this.getProvinceId();
        final Object other$provinceId = other.getProvinceId();
        if (this$provinceId == null ? other$provinceId != null : !this$provinceId.equals(other$provinceId))
        {return false;}
        final Object this$countyId = this.getCountyId();
        final Object other$countyId = other.getCountyId();
        if (this$countyId == null ? other$countyId != null : !this$countyId.equals(other$countyId)) {return false;}
        final Object this$addressDetail = this.getAddressDetail();
        final Object other$addressDetail = other.getAddressDetail();
        if (this$addressDetail == null ? other$addressDetail != null : !this$addressDetail.equals(other$addressDetail))
        { return false;}
        final Object this$mobile = this.getMobile();
        final Object other$mobile = other.getMobile();
        if (this$mobile == null ? other$mobile != null : !this$mobile.equals(other$mobile)) {return false;}
        final Object this$postalCode = this.getPostalCode();
        final Object other$postalCode = other.getPostalCode();
        if (this$postalCode == null ? other$postalCode != null : !this$postalCode.equals(other$postalCode))
        { return false;}
        final Object this$consignee = this.getConsignee();
        final Object other$consignee = other.getConsignee();
        if (this$consignee == null ? other$consignee != null : !this$consignee.equals(other$consignee)) {return false;}
        if (this.isBeDefault() != other.isBeDefault()) {return false;}
        final Object this$gmtCreate = this.getGmtCreate();
        final Object other$gmtCreate = other.getGmtCreate();
        if (this$gmtCreate == null ? other$gmtCreate != null : !this$gmtCreate.equals(other$gmtCreate)) {return false;}
        final Object this$gmtModified = this.getGmtModified();
        final Object other$gmtModified = other.getGmtModified();
        if (this$gmtModified == null ? other$gmtModified != null : !this$gmtModified.equals(other$gmtModified))
        { return false;}
        final Object this$beDeleted = this.getBeDeleted();
        final Object other$beDeleted = other.getBeDeleted();
        if (this$beDeleted == null ? other$beDeleted != null : !this$beDeleted.equals(other$beDeleted)) {return false;}
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AddressPo;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final Object $cityId = this.getCityId();
        result = result * PRIME + ($cityId == null ? 43 : $cityId.hashCode());
        final Object $provinceId = this.getProvinceId();
        result = result * PRIME + ($provinceId == null ? 43 : $provinceId.hashCode());
        final Object $countyId = this.getCountyId();
        result = result * PRIME + ($countyId == null ? 43 : $countyId.hashCode());
        final Object $addressDetail = this.getAddressDetail();
        result = result * PRIME + ($addressDetail == null ? 43 : $addressDetail.hashCode());
        final Object $mobile = this.getMobile();
        result = result * PRIME + ($mobile == null ? 43 : $mobile.hashCode());
        final Object $postalCode = this.getPostalCode();
        result = result * PRIME + ($postalCode == null ? 43 : $postalCode.hashCode());
        final Object $consignee = this.getConsignee();
        result = result * PRIME + ($consignee == null ? 43 : $consignee.hashCode());
        result = result * PRIME + (this.isBeDefault() ? 79 : 97);
        final Object $gmtCreate = this.getGmtCreate();
        result = result * PRIME + ($gmtCreate == null ? 43 : $gmtCreate.hashCode());
        final Object $gmtModified = this.getGmtModified();
        result = result * PRIME + ($gmtModified == null ? 43 : $gmtModified.hashCode());
        final Object $beDeleted = this.getBeDeleted();
        result = result * PRIME + ($beDeleted == null ? 43 : $beDeleted.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AddressPo(id=" + this.getId() + ", userId=" + this.getUserId() + ", cityId=" + this.getCityId() + ", provinceId=" + this.getProvinceId() + ", countyId=" + this.getCountyId() + ", addressDetail=" + this.getAddressDetail() + ", mobile=" + this.getMobile() + ", postalCode=" + this.getPostalCode() + ", consignee=" + this.getConsignee() + ", beDefault=" + this.isBeDefault() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
