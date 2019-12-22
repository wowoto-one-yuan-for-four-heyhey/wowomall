package com.xmu.wowoto.wowomall.domain.po;

import java.time.LocalDateTime;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:优惠券规则信息
 * @Data:Created in 14:50 2019/12/11
 **/
public class CouponRulePo {
    private Integer id;
    /**
     * 优惠券规则名称
     */
    private String name;
    /**
     * 优惠券简介
     */
    private String brief;
    /**
     * 优惠券规则的生效日期
     */
    private LocalDateTime beginTime;
    /**
     * 优惠券规则的失效日期
     */
    private LocalDateTime endTime;
    /**
     * 优惠券规则的图片
     */
    private String picUrl;
    /**
     * 优惠券规则的有效期(即有效的天数)
     */
    private Integer validPeriod;
    /**
     * 折扣策略
     * JSON格式:{"name":“XXX”, "obj":{XXX}}
     * eg. {"name":"xmu.oomall.discount.domain.DiscountStrategy.NumberStrategy", "obj":{"threshold":5, "offCash":10.01}}
     */
    private String strategy;
    /**
     * 该优惠券规则下优惠券的总张数
     */
    private Integer total;
    /**
     * 该优惠券规则下优惠券的被领取数
     */
    private Integer collectedNum;
    /**
     * 存放适用于本优惠券规则的所有商品ID
     * JSON格式:{"goodsIds": [xxx,xxx,xxx,xxx,xxx]}
     * eg. {"goodsIds": [1, 2, 3, 4, 5]}
     */
    private String goodsList1;
    /**
     * 存放适用于本优惠券规则的所有商品ID(商品可能很多，可能需要多个list存放)
     * JSON格式:{"goodsIds": [xxx,xxx,xxx,xxx,xxx]}
     * eg. {"goodsIds": [1, 2, 3, 4, 5]}
     */
    private String goodsList2;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
    private Boolean beDeleted;

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getBrief() {
        return this.brief;
    }

    public LocalDateTime getBeginTime() {
        return this.beginTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public Integer getValidPeriod() {
        return this.validPeriod;
    }

    public String getStrategy() {
        return this.strategy;
    }

    public Integer getTotal() {
        return this.total;
    }

    public Integer getCollectedNum() {
        return this.collectedNum;
    }

    public String getGoodsList1() {
        return this.goodsList1;
    }

    public String getGoodsList2() {
        return this.goodsList2;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setValidPeriod(Integer validPeriod) {
        this.validPeriod = validPeriod;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setCollectedNum(Integer collectedNum) {
        this.collectedNum = collectedNum;
    }

    public void setGoodsList1(String goodsList1) {
        this.goodsList1 = goodsList1;
    }

    public void setGoodsList2(String goodsList2) {
        this.goodsList2 = goodsList2;
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
        if (!(o instanceof CouponRulePo)) {return false;}
        final CouponRulePo other = (CouponRulePo) o;
        if (!other.canEqual((Object) this)) {return false;}
        final Object thisId = this.getId();
        final Object otherId = other.getId();
        if (thisId == null ? otherId != null : !thisId.equals(otherId)) {return false;}
        final Object thisName = this.getName();
        final Object otherName = other.getName();
        if (thisName == null ? otherName != null : !thisName.equals(otherName)){ return false;}
        final Object thisbrief = this.getBrief();
        final Object otherBrief = other.getBrief();
        if (thisbrief == null ? otherBrief != null : !thisbrief.equals(otherBrief)) {return false;}
        final Object thisBeginTime = this.getBeginTime();
        final Object otherBeginTime  = other.getBeginTime();
        if (thisBeginTime == null ? otherBeginTime  != null : !thisBeginTime.equals(otherBeginTime )){ return false;}
        final Object thisEndTime = this.getEndTime();
        final Object otherEndTime = other.getEndTime();
        if (thisEndTime == null ? otherEndTime != null : !thisEndTime.equals(otherEndTime)) {return false;}
        final Object thisPicUrl = this.getPicUrl();
        final Object otherPicUrl = other.getPicUrl();
        if (thisPicUrl == null ? otherPicUrl != null : !thisPicUrl.equals(otherPicUrl)){ return false;}
        final Object thisValidPeriod = this.getValidPeriod();
        final Object otherValidPeriod = other.getValidPeriod();
        if (thisValidPeriod == null ? otherValidPeriod != null : !thisValidPeriod.equals(otherValidPeriod))
        {   return false;}
        final Object thisStrategy = this.getStrategy();
        final Object otherStrategy = other.getStrategy();
        if (thisStrategy == null ? otherStrategy != null : !thisStrategy.equals(otherStrategy)) {return false;}
        final Object thisTotal = this.getTotal();
        final Object otherTotal = other.getTotal();
        if (thisTotal == null ? otherTotal != null : !thisTotal.equals(otherTotal)){ return false;}
        final Object thisCollectedNum = this.getCollectedNum();
        final Object otherCollectedNum = other.getCollectedNum();
        if (thisCollectedNum == null ? otherCollectedNum != null : !thisCollectedNum.equals(otherCollectedNum))
        {    return false;}
        final Object thisGoodsList1 = this.getGoodsList1();
        final Object otherGoodsList1 = other.getGoodsList1();
        if (thisGoodsList1 == null ? otherGoodsList1 != null : !thisGoodsList1.equals(otherGoodsList1))
        {  return false;}
        final Object thisGoodsList2 = this.getGoodsList2();
        final Object otherGoodsList2 = other.getGoodsList2();
        if (thisGoodsList2 == null ? otherGoodsList2 != null : !thisGoodsList2.equals(otherGoodsList2))
        {   return false;}
        final Object thisGmtCreate = this.getGmtCreate();
        final Object otherGmtCreate = other.getGmtCreate();
        if (thisGmtCreate == null ? otherGmtCreate != null : !thisGmtCreate.equals(otherGmtCreate)){ return false;}
        final Object thisGmtModified = this.getGmtModified();
        final Object otherGmtModified = other.getGmtModified();
        if (thisGmtModified == null ? otherGmtModified != null : !thisGmtModified.equals(otherGmtModified))
        {    return false;}
        final Object thisBeDeleted = this.getBeDeleted();
        final Object otherBeDeleted = other.getBeDeleted();
        if (thisBeDeleted == null ? otherBeDeleted != null : !thisBeDeleted.equals(otherBeDeleted)) {return false;}
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CouponRulePo;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        final Object id = this.getId();
        result = result * prime + (id == null ? 43 : id.hashCode());
        final Object name = this.getName();
        result = result * prime + (name == null ? 43 : name.hashCode());
        final Object brief = this.getBrief();
        result = result * prime + (brief == null ? 43 : brief.hashCode());
        final Object beginTime = this.getBeginTime();
        result = result * prime + (beginTime == null ? 43 : beginTime.hashCode());
        final Object endTime = this.getEndTime();
        result = result * prime + (endTime == null ? 43 : endTime.hashCode());
        final Object picUrl = this.getPicUrl();
        result = result * prime + (picUrl == null ? 43 : picUrl.hashCode());
        final Object validPeriod = this.getValidPeriod();
        result = result * prime + (validPeriod == null ? 43 : validPeriod.hashCode());
        final Object strategy = this.getStrategy();
        result = result * prime + (strategy == null ? 43 : strategy.hashCode());
        final Object total = this.getTotal();
        result = result * prime + (total == null ? 43 : total.hashCode());
        final Object collectedNum = this.getCollectedNum();
        result = result * prime + (collectedNum == null ? 43 : collectedNum.hashCode());
        final Object goodsList1 = this.getGoodsList1();
        result = result * prime + (goodsList1 == null ? 43 : goodsList1.hashCode());
        final Object goodsList2 = this.getGoodsList2();
        result = result * prime + (goodsList2 == null ? 43 : goodsList2.hashCode());
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
        return "CouponRulePo(id=" + this.getId() + ", name=" + this.getName() + ", brief=" + this.getBrief() + ", beginTime=" + this.getBeginTime() + ", endTime=" + this.getEndTime() + ", picUrl=" + this.getPicUrl() + ", validPeriod=" + this.getValidPeriod() + ", strategy=" + this.getStrategy() + ", total=" + this.getTotal() + ", collectedNum=" + this.getCollectedNum() + ", goodsList1=" + this.getGoodsList1() + ", goodsList2=" + this.getGoodsList2() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
