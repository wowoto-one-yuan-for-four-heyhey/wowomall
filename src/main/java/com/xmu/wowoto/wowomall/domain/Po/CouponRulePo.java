package com.xmu.wowoto.wowomall.domain.Po;

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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CouponRulePo)) return false;
        final CouponRulePo other = (CouponRulePo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$brief = this.getBrief();
        final Object other$brief = other.getBrief();
        if (this$brief == null ? other$brief != null : !this$brief.equals(other$brief)) return false;
        final Object this$beginTime = this.getBeginTime();
        final Object other$beginTime = other.getBeginTime();
        if (this$beginTime == null ? other$beginTime != null : !this$beginTime.equals(other$beginTime)) return false;
        final Object this$endTime = this.getEndTime();
        final Object other$endTime = other.getEndTime();
        if (this$endTime == null ? other$endTime != null : !this$endTime.equals(other$endTime)) return false;
        final Object this$picUrl = this.getPicUrl();
        final Object other$picUrl = other.getPicUrl();
        if (this$picUrl == null ? other$picUrl != null : !this$picUrl.equals(other$picUrl)) return false;
        final Object this$validPeriod = this.getValidPeriod();
        final Object other$validPeriod = other.getValidPeriod();
        if (this$validPeriod == null ? other$validPeriod != null : !this$validPeriod.equals(other$validPeriod))
            return false;
        final Object this$strategy = this.getStrategy();
        final Object other$strategy = other.getStrategy();
        if (this$strategy == null ? other$strategy != null : !this$strategy.equals(other$strategy)) return false;
        final Object this$total = this.getTotal();
        final Object other$total = other.getTotal();
        if (this$total == null ? other$total != null : !this$total.equals(other$total)) return false;
        final Object this$collectedNum = this.getCollectedNum();
        final Object other$collectedNum = other.getCollectedNum();
        if (this$collectedNum == null ? other$collectedNum != null : !this$collectedNum.equals(other$collectedNum))
            return false;
        final Object this$goodsList1 = this.getGoodsList1();
        final Object other$goodsList1 = other.getGoodsList1();
        if (this$goodsList1 == null ? other$goodsList1 != null : !this$goodsList1.equals(other$goodsList1))
            return false;
        final Object this$goodsList2 = this.getGoodsList2();
        final Object other$goodsList2 = other.getGoodsList2();
        if (this$goodsList2 == null ? other$goodsList2 != null : !this$goodsList2.equals(other$goodsList2))
            return false;
        final Object this$gmtCreate = this.getGmtCreate();
        final Object other$gmtCreate = other.getGmtCreate();
        if (this$gmtCreate == null ? other$gmtCreate != null : !this$gmtCreate.equals(other$gmtCreate)) return false;
        final Object this$gmtModified = this.getGmtModified();
        final Object other$gmtModified = other.getGmtModified();
        if (this$gmtModified == null ? other$gmtModified != null : !this$gmtModified.equals(other$gmtModified))
            return false;
        final Object this$beDeleted = this.getBeDeleted();
        final Object other$beDeleted = other.getBeDeleted();
        if (this$beDeleted == null ? other$beDeleted != null : !this$beDeleted.equals(other$beDeleted)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CouponRulePo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $brief = this.getBrief();
        result = result * PRIME + ($brief == null ? 43 : $brief.hashCode());
        final Object $beginTime = this.getBeginTime();
        result = result * PRIME + ($beginTime == null ? 43 : $beginTime.hashCode());
        final Object $endTime = this.getEndTime();
        result = result * PRIME + ($endTime == null ? 43 : $endTime.hashCode());
        final Object $picUrl = this.getPicUrl();
        result = result * PRIME + ($picUrl == null ? 43 : $picUrl.hashCode());
        final Object $validPeriod = this.getValidPeriod();
        result = result * PRIME + ($validPeriod == null ? 43 : $validPeriod.hashCode());
        final Object $strategy = this.getStrategy();
        result = result * PRIME + ($strategy == null ? 43 : $strategy.hashCode());
        final Object $total = this.getTotal();
        result = result * PRIME + ($total == null ? 43 : $total.hashCode());
        final Object $collectedNum = this.getCollectedNum();
        result = result * PRIME + ($collectedNum == null ? 43 : $collectedNum.hashCode());
        final Object $goodsList1 = this.getGoodsList1();
        result = result * PRIME + ($goodsList1 == null ? 43 : $goodsList1.hashCode());
        final Object $goodsList2 = this.getGoodsList2();
        result = result * PRIME + ($goodsList2 == null ? 43 : $goodsList2.hashCode());
        final Object $gmtCreate = this.getGmtCreate();
        result = result * PRIME + ($gmtCreate == null ? 43 : $gmtCreate.hashCode());
        final Object $gmtModified = this.getGmtModified();
        result = result * PRIME + ($gmtModified == null ? 43 : $gmtModified.hashCode());
        final Object $beDeleted = this.getBeDeleted();
        result = result * PRIME + ($beDeleted == null ? 43 : $beDeleted.hashCode());
        return result;
    }

    public String toString() {
        return "CouponRulePo(id=" + this.getId() + ", name=" + this.getName() + ", brief=" + this.getBrief() + ", beginTime=" + this.getBeginTime() + ", endTime=" + this.getEndTime() + ", picUrl=" + this.getPicUrl() + ", validPeriod=" + this.getValidPeriod() + ", strategy=" + this.getStrategy() + ", total=" + this.getTotal() + ", collectedNum=" + this.getCollectedNum() + ", goodsList1=" + this.getGoodsList1() + ", goodsList2=" + this.getGoodsList2() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
