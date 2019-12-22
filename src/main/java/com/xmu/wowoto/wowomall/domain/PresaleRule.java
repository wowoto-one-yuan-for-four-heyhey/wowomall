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

        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PresaleRule;
    }

    @Override
    public int hashCode() {

        return 0;
    }

    @Override
    public String toString() {
        return "PresaleRule(id=" + this.getId() + ", startTime=" + this.getStartTime() + ", adEndTime=" + this.getAdEndTime() + ", finalStartTime=" + this.getFinalStartTime() + ", endTime=" + this.getEndTime() + ", statusCode=" + this.getStatusCode() + ", goodsId=" + this.getGoodsId() + ", deposit=" + this.getDeposit() + ", finalPayment=" + this.getFinalPayment() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
