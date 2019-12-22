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
        if (o == this) {return true;}
        if (!(o instanceof DefaultFreightPo)) {return false;}
        final DefaultFreightPo other = (DefaultFreightPo) o;
        if (!other.canEqual((Object) this)) {return false;}
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) {return false;}
        final Object this$destination = this.getDestination();
        final Object other$destination = other.getDestination();
        if (this$destination == null ? other$destination != null : !this$destination.equals(other$destination))
        {    return false;}
        final Object this$firstHeavyPrice = this.getFirstHeavyPrice();
        final Object other$firstHeavyPrice = other.getFirstHeavyPrice();
        if (this$firstHeavyPrice == null ? other$firstHeavyPrice != null : !this$firstHeavyPrice.equals(other$firstHeavyPrice))
        {   return false;}
        final Object this$continueHeavyPrice = this.getContinueHeavyPrice();
        final Object other$continueHeavyPrice = other.getContinueHeavyPrice();
        if (this$continueHeavyPrice == null ? other$continueHeavyPrice != null : !this$continueHeavyPrice.equals(other$continueHeavyPrice))
        {    return false;}
        final Object this$over10Price = this.getOver10Price();
        final Object other$over10Price = other.getOver10Price();
        if (this$over10Price == null ? other$over10Price != null : !this$over10Price.equals(other$over10Price))
        {    return false;}
        final Object this$over50Price = this.getOver50Price();
        final Object other$over50Price = other.getOver50Price();
        if (this$over50Price == null ? other$over50Price != null : !this$over50Price.equals(other$over50Price))
        {    return false;}
        final Object this$over100Price = this.getOver100Price();
        final Object other$over100Price = other.getOver100Price();
        if (this$over100Price == null ? other$over100Price != null : !this$over100Price.equals(other$over100Price))
        {   return false;}
        final Object this$over300Price = this.getOver300Price();
        final Object other$over300Price = other.getOver300Price();
        if (this$over300Price == null ? other$over300Price != null : !this$over300Price.equals(other$over300Price))
        {   return false;}
        final Object this$requireDays = this.getRequireDays();
        final Object other$requireDays = other.getRequireDays();
        if (this$requireDays == null ? other$requireDays != null : !this$requireDays.equals(other$requireDays))
        {   return false;}
        final Object this$gmtCreate = this.getGmtCreate();
        final Object other$gmtCreate = other.getGmtCreate();
        if (this$gmtCreate == null ? other$gmtCreate != null : !this$gmtCreate.equals(other$gmtCreate)) {return false;}
        final Object this$gmtModified = this.getGmtModified();
        final Object other$gmtModified = other.getGmtModified();
        if (this$gmtModified == null ? other$gmtModified != null : !this$gmtModified.equals(other$gmtModified))
        {   return false;}
        final Object this$beDeleted = this.getBeDeleted();
        final Object other$beDeleted = other.getBeDeleted();
        if (this$beDeleted == null ? other$beDeleted != null : !this$beDeleted.equals(other$beDeleted)) {return false;}
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof DefaultFreightPo;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $destination = this.getDestination();
        result = result * PRIME + ($destination == null ? 43 : $destination.hashCode());
        final Object $firstHeavyPrice = this.getFirstHeavyPrice();
        result = result * PRIME + ($firstHeavyPrice == null ? 43 : $firstHeavyPrice.hashCode());
        final Object $continueHeavyPrice = this.getContinueHeavyPrice();
        result = result * PRIME + ($continueHeavyPrice == null ? 43 : $continueHeavyPrice.hashCode());
        final Object $over10Price = this.getOver10Price();
        result = result * PRIME + ($over10Price == null ? 43 : $over10Price.hashCode());
        final Object $over50Price = this.getOver50Price();
        result = result * PRIME + ($over50Price == null ? 43 : $over50Price.hashCode());
        final Object $over100Price = this.getOver100Price();
        result = result * PRIME + ($over100Price == null ? 43 : $over100Price.hashCode());
        final Object $over300Price = this.getOver300Price();
        result = result * PRIME + ($over300Price == null ? 43 : $over300Price.hashCode());
        final Object $requireDays = this.getRequireDays();
        result = result * PRIME + ($requireDays == null ? 43 : $requireDays.hashCode());
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
        return "DefaultFreightPo(id=" + this.getId() + ", destination=" + this.getDestination() + ", firstHeavyPrice=" + this.getFirstHeavyPrice() + ", continueHeavyPrice=" + this.getContinueHeavyPrice() + ", over10Price=" + this.getOver10Price() + ", over50Price=" + this.getOver50Price() + ", over100Price=" + this.getOver100Price() + ", over300Price=" + this.getOver300Price() + ", requireDays=" + this.getRequireDays() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
