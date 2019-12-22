package com.xmu.wowoto.wowomall.domain.po;

import java.time.LocalDateTime;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:优惠券信息
 * @Data:Created in 14:50 2019/12/11
 **/

public class CouponPo {
    private Integer id;
    /**
     * 所属用户的ID
     */
    private Integer userId;
    /**
     * 所属优惠券规则的ID
     */
    private Integer couponRuleId;
    /**
     * 优惠券序列号
     */
    private String couponSn;
    /**
     * 本张优惠券的生效时间
     */
    private LocalDateTime beginTime;
    /**
     * 本张优惠券的失效时间
     */
    private LocalDateTime endTime;
    /**
     * 本张优惠券被使用的日期
     */
    private LocalDateTime usedTime;
    /**
     * 本张优惠券的名称
     */
    private String name;
    /**
     * 本张优惠券的图片
     */
    private String picUrl;
    /**
     * 优惠券是否已经使用，0未使用，1已使用
     */
    private Boolean statusCode;

    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
    private Boolean beDeleted;

    public Integer getId() {
        return this.id;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public Integer getCouponRuleId() {
        return this.couponRuleId;
    }

    public String getCouponSn() {
        return this.couponSn;
    }

    public LocalDateTime getBeginTime() {
        return this.beginTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public LocalDateTime getUsedTime() {
        return this.usedTime;
    }

    public String getName() {
        return this.name;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public Boolean getStatusCode() {
        return this.statusCode;
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

    public void setCouponRuleId(Integer couponRuleId) {
        this.couponRuleId = couponRuleId;
    }

    public void setCouponSn(String couponSn) {
        this.couponSn = couponSn;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setUsedTime(LocalDateTime usedTime) {
        this.usedTime = usedTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setStatusCode(Boolean statusCode) {
        this.statusCode = statusCode;
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
        if (!(o instanceof CouponPo)){ return false;}
        final CouponPo other = (CouponPo) o;
        if (!other.canEqual((Object) this)) {return false;}
        final Object thisid = this.getId();
        final Object otherid = other.getId();
        if (thisid == null ? otherid != null : !thisid.equals(otherid)) {return false;}
        final Object thisuserId = this.getUserId();
        final Object otheruserId = other.getUserId();
        if (thisuserId == null ? otheruserId != null : !thisuserId.equals(otheruserId)){ return false;}
        final Object thiscouponRuleId = this.getCouponRuleId();
        final Object othercouponRuleId = other.getCouponRuleId();
        if (thiscouponRuleId == null ? othercouponRuleId != null : !thiscouponRuleId.equals(othercouponRuleId))
        {  return false;}
        final Object thiscouponSn = this.getCouponSn();
        final Object othercouponSn = other.getCouponSn();
        if (thiscouponSn == null ? othercouponSn != null : !thiscouponSn.equals(othercouponSn)){ return false;}
        final Object thisbeginTime = this.getBeginTime();
        final Object otherbeginTime = other.getBeginTime();
        if (thisbeginTime == null ? otherbeginTime != null : !thisbeginTime.equals(otherbeginTime)){ return false;}
        final Object thisendTime = this.getEndTime();
        final Object otherendTime = other.getEndTime();
        if (thisendTime == null ? otherendTime != null : !thisendTime.equals(otherendTime)){ return false;}
        final Object thisusedTime = this.getUsedTime();
        final Object otherusedTime = other.getUsedTime();
        if (thisusedTime == null ? otherusedTime != null : !thisusedTime.equals(otherusedTime)) {return false;}
        final Object thisname = this.getName();
        final Object othername = other.getName();
        if (thisname == null ? othername != null : !thisname.equals(othername)){ return false;}
        final Object thispicUrl = this.getPicUrl();
        final Object otherpicUrl = other.getPicUrl();
        if (thispicUrl == null ? otherpicUrl != null : !thispicUrl.equals(otherpicUrl)){ return false;}
        final Object thisstatusCode = this.getStatusCode();
        final Object otherstatusCode = other.getStatusCode();
        if (thisstatusCode == null ? otherstatusCode != null : !thisstatusCode.equals(otherstatusCode))
        {   return false;}
        final Object thisgmtCreate = this.getGmtCreate();
        final Object othergmtCreate = other.getGmtCreate();
        if (thisgmtCreate == null ? othergmtCreate != null : !thisgmtCreate.equals(othergmtCreate)){ return false;}
        final Object thisgmtModified = this.getGmtModified();
        final Object othergmtModified = other.getGmtModified();
        if (thisgmtModified == null ? othergmtModified != null : !thisgmtModified.equals(othergmtModified))
        {  return false;}
        final Object thisbeDeleted = this.getBeDeleted();
        final Object otherbeDeleted = other.getBeDeleted();
        if (thisbeDeleted == null ? otherbeDeleted != null : !thisbeDeleted.equals(otherbeDeleted)){ return false;}
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CouponPo;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        final Object id = this.getId();
        result = result * prime + (id == null ? 43 : id.hashCode());
        final Object userId = this.getUserId();
        result = result * prime + (userId == null ? 43 : userId.hashCode());
        final Object couponRuleId = this.getCouponRuleId();
        result = result * prime + (couponRuleId == null ? 43 : couponRuleId.hashCode());
        final Object couponSn = this.getCouponSn();
        result = result * prime + (couponSn == null ? 43 : couponSn.hashCode());
        final Object beginTime = this.getBeginTime();
        result = result * prime + (beginTime == null ? 43 : beginTime.hashCode());
        final Object endTime = this.getEndTime();
        result = result * prime + (endTime == null ? 43 : endTime.hashCode());
        final Object usedTime = this.getUsedTime();
        result = result * prime + (usedTime == null ? 43 : usedTime.hashCode());
        final Object name = this.getName();
        result = result * prime + (name == null ? 43 : name.hashCode());
        final Object picUrl = this.getPicUrl();
        result = result * prime + (picUrl == null ? 43 : picUrl.hashCode());
        final Object statusCode = this.getStatusCode();
        result = result * prime + (statusCode == null ? 43 : statusCode.hashCode());
        final Object gmtCreate = this.getGmtCreate();
        result = result * prime + (gmtCreate == null ? 43 : gmtCreate.hashCode());
        final Object gmtModified = this.getGmtModified();
        result = result * prime + (gmtModified == null ? 43 : gmtModified.hashCode());
        final Object beDeleted = this.getBeDeleted();
        result = result * prime + (beDeleted == null ? 43 : beDeleted.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CouponPo(id=" + this.getId() + ", userId=" + this.getUserId() + ", couponRuleId=" + this.getCouponRuleId() + ", couponSn=" + this.getCouponSn() + ", beginTime=" + this.getBeginTime() + ", endTime=" + this.getEndTime() + ", usedTime=" + this.getUsedTime() + ", name=" + this.getName() + ", picUrl=" + this.getPicUrl() + ", statusCode=" + this.getStatusCode() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
