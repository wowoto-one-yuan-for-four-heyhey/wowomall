package com.xmu.wowoto.wowomall.domain.po;

import java.math.BigDecimal;
import java.time.LocalDateTime;
/**
 * @Author: 数据库与对象模型标准组
 * @Description: 默认重量模板
 * @Date: Created in 16:00 2019/12/11
 **/

public class DefaultFreightPo {
    private Integer id;
    /**
     * 货物运送的目的地（即收货地址）
     * JSON格式: {"dest": [xxx,xxx,xxx,xxx,xxx]}
     * eg. {"dest": [1, 2, 3, 4, 5]}
     */
    private String destination;
    /**
     * 快递重量模板中快递首重0.5kg的价格
     */
    private BigDecimal firstHeavyPrice;
    /**
     * 续重的邮费价格
     */
    private BigDecimal continueHeavyPrice;
    /**
     * 10kg以上每kg的邮费价格（下一区间以下）
     */
    private BigDecimal over10Price;
    /**
     * 50kg以上每kg的邮费价格
     */
    private BigDecimal over50Price;
    /**
     * 100kg以上每kg的邮费价格
     */
    private BigDecimal over100Price;
    /**
     * 300kg以上每kg的邮费价格
     */
    private BigDecimal over300Price;
    /**
     * 快递送到需要的时间（次日 或者 1-2天等 ）
     */
    private String requireDays;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
    private Boolean beDeleted;

    public Integer getId() {
        return this.id;
    }

    public String getDestination() {
        return this.destination;
    }

    public BigDecimal getFirstHeavyPrice() {
        return this.firstHeavyPrice;
    }

    public BigDecimal getContinueHeavyPrice() {
        return this.continueHeavyPrice;
    }

    public BigDecimal getOver10Price() {
        return this.over10Price;
    }

    public BigDecimal getOver50Price() {
        return this.over50Price;
    }

    public BigDecimal getOver100Price() {
        return this.over100Price;
    }

    public BigDecimal getOver300Price() {
        return this.over300Price;
    }

    public String getRequireDays() {
        return this.requireDays;
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

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFirstHeavyPrice(BigDecimal firstHeavyPrice) {
        this.firstHeavyPrice = firstHeavyPrice;
    }

    public void setContinueHeavyPrice(BigDecimal continueHeavyPrice) {
        this.continueHeavyPrice = continueHeavyPrice;
    }

    public void setOver10Price(BigDecimal over10Price) {
        this.over10Price = over10Price;
    }

    public void setOver50Price(BigDecimal over50Price) {
        this.over50Price = over50Price;
    }

    public void setOver100Price(BigDecimal over100Price) {
        this.over100Price = over100Price;
    }

    public void setOver300Price(BigDecimal over300Price) {
        this.over300Price = over300Price;
    }

    public void setRequireDays(String requireDays) {
        this.requireDays = requireDays;
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
        return other instanceof DefaultFreightPo;
    }

    @Override
    public int hashCode() {

        return 0;
    }

    @Override
    public String toString() {
        return "DefaultFreightPo(id=" + this.getId() + ", destination=" + this.getDestination() + ", firstHeavyPrice=" + this.getFirstHeavyPrice() + ", continueHeavyPrice=" + this.getContinueHeavyPrice() + ", over10Price=" + this.getOver10Price() + ", over50Price=" + this.getOver50Price() + ", over100Price=" + this.getOver100Price() + ", over300Price=" + this.getOver300Price() + ", requireDays=" + this.getRequireDays() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
