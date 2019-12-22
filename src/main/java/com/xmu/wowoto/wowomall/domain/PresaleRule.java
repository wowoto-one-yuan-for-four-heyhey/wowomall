package com.xmu.wowoto.wowomall.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: 数据库与对象模型标准组
 * @Description: 预售信息表
 * @Date: Created in 16:50 2019/12/11
 **/
public class PresaleRule {
    private Integer id;
    /**
     *预售开始时间
     */
    private LocalDateTime startTime;
    /**
     * 预付结束时间
     */
    private LocalDateTime adEndTime;
    /**
     * 尾款开始时间
     */
    private LocalDateTime finalStartTime;
    /**
     *预售结束时间
     */
    private LocalDateTime endTime;
    /**
     *判断预售是否还在进行中
     */
    private Boolean statusCode;
    /**
     *预售商品id
     */
    private Integer goodsId;
    /**
     *定金
     */
    private BigDecimal deposit;
    /**
     * 尾款金额
     */
    private BigDecimal finalPayment;

    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
    private Boolean beDeleted;

    public Integer getId() {
        return this.id;
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public LocalDateTime getAdEndTime() {
        return this.adEndTime;
    }

    public LocalDateTime getFinalStartTime() {
        return this.finalStartTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public Boolean getStatusCode() {
        return this.statusCode;
    }

    public Integer getGoodsId() {
        return this.goodsId;
    }

    public BigDecimal getDeposit() {
        return this.deposit;
    }

    public BigDecimal getFinalPayment() {
        return this.finalPayment;
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

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setAdEndTime(LocalDateTime adEndTime) {
        this.adEndTime = adEndTime;
    }

    public void setFinalStartTime(LocalDateTime finalStartTime) {
        this.finalStartTime = finalStartTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setStatusCode(Boolean statusCode) {
        this.statusCode = statusCode;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public void setFinalPayment(BigDecimal finalPayment) {
        this.finalPayment = finalPayment;
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
        if (o == this){ return true;}
        if (!(o instanceof PresaleRule)) {return false;}
        final PresaleRule other = (PresaleRule) o;
        if (!other.canEqual((Object) this)) {return false;}
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) {return false;}
        final Object this$startTime = this.getStartTime();
        final Object other$startTime = other.getStartTime();
        if (this$startTime == null ? other$startTime != null : !this$startTime.equals(other$startTime)){return false;}
        final Object this$adEndTime = this.getAdEndTime();
        final Object other$adEndTime = other.getAdEndTime();
        if (this$adEndTime == null ? other$adEndTime != null : !this$adEndTime.equals(other$adEndTime)) {return false;}
        final Object this$finalStartTime = this.getFinalStartTime();
        final Object other$finalStartTime = other.getFinalStartTime();
        if (this$finalStartTime == null ? other$finalStartTime != null : !this$finalStartTime.equals(other$finalStartTime))
        {return false;}
        final Object this$endTime = this.getEndTime();
        final Object other$endTime = other.getEndTime();
        if (this$endTime == null ? other$endTime != null : !this$endTime.equals(other$endTime)){return false;}
        final Object this$statusCode = this.getStatusCode();
        final Object other$statusCode = other.getStatusCode();
        if (this$statusCode == null ? other$statusCode != null : !this$statusCode.equals(other$statusCode))
        {return false;}
        final Object this$goodsId = this.getGoodsId();
        final Object other$goodsId = other.getGoodsId();
        if (this$goodsId == null ? other$goodsId != null : !this$goodsId.equals(other$goodsId)) {return false;}
        final Object this$deposit = this.getDeposit();
        final Object other$deposit = other.getDeposit();
        if (this$deposit == null ? other$deposit != null : !this$deposit.equals(other$deposit)) {return false;}
        final Object this$finalPayment = this.getFinalPayment();
        final Object other$finalPayment = other.getFinalPayment();
        if (this$finalPayment == null ? other$finalPayment != null : !this$finalPayment.equals(other$finalPayment))
        {return false;}
        final Object this$gmtCreate = this.getGmtCreate();
        final Object other$gmtCreate = other.getGmtCreate();
        if (this$gmtCreate == null ? other$gmtCreate != null : !this$gmtCreate.equals(other$gmtCreate)) {return false;}
        final Object this$gmtModified = this.getGmtModified();
        final Object other$gmtModified = other.getGmtModified();
        if (this$gmtModified == null ? other$gmtModified != null : !this$gmtModified.equals(other$gmtModified))
        {return false;}
        final Object this$beDeleted = this.getBeDeleted();
        final Object other$beDeleted = other.getBeDeleted();
        if (this$beDeleted == null ? other$beDeleted != null : !this$beDeleted.equals(other$beDeleted)) {return false;}
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PresaleRule;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $startTime = this.getStartTime();
        result = result * PRIME + ($startTime == null ? 43 : $startTime.hashCode());
        final Object $adEndTime = this.getAdEndTime();
        result = result * PRIME + ($adEndTime == null ? 43 : $adEndTime.hashCode());
        final Object $finalStartTime = this.getFinalStartTime();
        result = result * PRIME + ($finalStartTime == null ? 43 : $finalStartTime.hashCode());
        final Object $endTime = this.getEndTime();
        result = result * PRIME + ($endTime == null ? 43 : $endTime.hashCode());
        final Object $statusCode = this.getStatusCode();
        result = result * PRIME + ($statusCode == null ? 43 : $statusCode.hashCode());
        final Object $goodsId = this.getGoodsId();
        result = result * PRIME + ($goodsId == null ? 43 : $goodsId.hashCode());
        final Object $deposit = this.getDeposit();
        result = result * PRIME + ($deposit == null ? 43 : $deposit.hashCode());
        final Object $finalPayment = this.getFinalPayment();
        result = result * PRIME + ($finalPayment == null ? 43 : $finalPayment.hashCode());
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
        return "PresaleRule(id=" + this.getId() + ", startTime=" + this.getStartTime() + ", adEndTime=" + this.getAdEndTime() + ", finalStartTime=" + this.getFinalStartTime() + ", endTime=" + this.getEndTime() + ", statusCode=" + this.getStatusCode() + ", goodsId=" + this.getGoodsId() + ", deposit=" + this.getDeposit() + ", finalPayment=" + this.getFinalPayment() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
