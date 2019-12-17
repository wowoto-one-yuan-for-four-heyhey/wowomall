package com.xmu.wowoto.wowomall.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: 数据库与对象模型标准组
 * @Description: 付款记录
 * @Date: Created in 16:00 2019/12/11
 **/
public class Payment {

    public Payment(){

    }
    public Payment(Order order){
        this.actualPrice = order.getIntegralPrice();
        this.payChannel = 1;
        this.beSuccessful = false;
        this.orderId = order.getId();
    }

    private Integer id;
    /**
     * 付款金额
     */
    private BigDecimal actualPrice;
    /**
     * 付款渠道，微信，银行等等
     */
    private Integer payChannel;
    /**
     * 是否付款成功,0不成功，1成功
     */
    private Boolean beSuccessful;
    /**
     * 付款时间
     */
    private LocalDateTime payTime;
    /**
     * 付款编号，从支付渠道获得的
     */
    private String paySn;
    /**
     * 付款的开始时间 （在开始时间和结束时间之间才可以付款）
     */
    private LocalDateTime beginTime;
    /**
     * 付款的结束时间
     */
    private LocalDateTime endTime;
    /**
     * 订单Id
     */
    private Integer orderId;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
    private Boolean beDeleted;

    public Integer getId() {
        return this.id;
    }

    public BigDecimal getActualPrice() {
        return this.actualPrice;
    }

    public Integer getPayChannel() {
        return this.payChannel;
    }

    public Boolean getBeSuccessful() {
        return this.beSuccessful;
    }

    public LocalDateTime getPayTime() {
        return this.payTime;
    }

    public String getPaySn() {
        return this.paySn;
    }

    public LocalDateTime getBeginTime() {
        return this.beginTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public Integer getOrderId() {
        return this.orderId;
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

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public void setPayChannel(Integer payChannel) {
        this.payChannel = payChannel;
    }

    public void setBeSuccessful(Boolean beSuccessful) {
        this.beSuccessful = beSuccessful;
    }

    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }

    public void setPaySn(String paySn) {
        this.paySn = paySn;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
        if (!(o instanceof Payment)) return false;
        final Payment other = (Payment) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$actualPrice = this.getActualPrice();
        final Object other$actualPrice = other.getActualPrice();
        if (this$actualPrice == null ? other$actualPrice != null : !this$actualPrice.equals(other$actualPrice))
            return false;
        final Object this$payChannel = this.getPayChannel();
        final Object other$payChannel = other.getPayChannel();
        if (this$payChannel == null ? other$payChannel != null : !this$payChannel.equals(other$payChannel))
            return false;
        final Object this$beSuccessful = this.getBeSuccessful();
        final Object other$beSuccessful = other.getBeSuccessful();
        if (this$beSuccessful == null ? other$beSuccessful != null : !this$beSuccessful.equals(other$beSuccessful))
            return false;
        final Object this$payTime = this.getPayTime();
        final Object other$payTime = other.getPayTime();
        if (this$payTime == null ? other$payTime != null : !this$payTime.equals(other$payTime)) return false;
        final Object this$paySn = this.getPaySn();
        final Object other$paySn = other.getPaySn();
        if (this$paySn == null ? other$paySn != null : !this$paySn.equals(other$paySn)) return false;
        final Object this$beginTime = this.getBeginTime();
        final Object other$beginTime = other.getBeginTime();
        if (this$beginTime == null ? other$beginTime != null : !this$beginTime.equals(other$beginTime)) return false;
        final Object this$endTime = this.getEndTime();
        final Object other$endTime = other.getEndTime();
        if (this$endTime == null ? other$endTime != null : !this$endTime.equals(other$endTime)) return false;
        final Object this$orderId = this.getOrderId();
        final Object other$orderId = other.getOrderId();
        if (this$orderId == null ? other$orderId != null : !this$orderId.equals(other$orderId)) return false;
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
        return other instanceof Payment;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $actualPrice = this.getActualPrice();
        result = result * PRIME + ($actualPrice == null ? 43 : $actualPrice.hashCode());
        final Object $payChannel = this.getPayChannel();
        result = result * PRIME + ($payChannel == null ? 43 : $payChannel.hashCode());
        final Object $beSuccessful = this.getBeSuccessful();
        result = result * PRIME + ($beSuccessful == null ? 43 : $beSuccessful.hashCode());
        final Object $payTime = this.getPayTime();
        result = result * PRIME + ($payTime == null ? 43 : $payTime.hashCode());
        final Object $paySn = this.getPaySn();
        result = result * PRIME + ($paySn == null ? 43 : $paySn.hashCode());
        final Object $beginTime = this.getBeginTime();
        result = result * PRIME + ($beginTime == null ? 43 : $beginTime.hashCode());
        final Object $endTime = this.getEndTime();
        result = result * PRIME + ($endTime == null ? 43 : $endTime.hashCode());
        final Object $orderId = this.getOrderId();
        result = result * PRIME + ($orderId == null ? 43 : $orderId.hashCode());
        final Object $gmtCreate = this.getGmtCreate();
        result = result * PRIME + ($gmtCreate == null ? 43 : $gmtCreate.hashCode());
        final Object $gmtModified = this.getGmtModified();
        result = result * PRIME + ($gmtModified == null ? 43 : $gmtModified.hashCode());
        final Object $beDeleted = this.getBeDeleted();
        result = result * PRIME + ($beDeleted == null ? 43 : $beDeleted.hashCode());
        return result;
    }

    public String toString() {
        return "Payment(id=" + this.getId() + ", actualPrice=" + this.getActualPrice() + ", payChannel=" + this.getPayChannel() + ", beSuccessful=" + this.getBeSuccessful() + ", payTime=" + this.getPayTime() + ", paySn=" + this.getPaySn() + ", beginTime=" + this.getBeginTime() + ", endTime=" + this.getEndTime() + ", orderId=" + this.getOrderId() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
