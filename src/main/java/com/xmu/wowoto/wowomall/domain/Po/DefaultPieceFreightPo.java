package com.xmu.wowoto.wowomall.domain.Po;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: 数据库与对象模型标准组
 * @Description: 默认件数模板
 * @Date: Created in 16:00 2019/12/11
 **/
public class DefaultPieceFreightPo {

    private Integer id;
    /**
     * 货物运送的目的地（即收货地址）
     * JSON格式: {"dest": [xxx,xxx,xxx,xxx,xxx]}
     * eg. {"dest": [1, 2, 3, 4, 5]}
     */
    private String destination;
    /**
     * 单位比例
     */
    private BigDecimal unitRate;
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

    public BigDecimal getUnitRate() {
        return this.unitRate;
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

    public void setUnitRate(BigDecimal unitRate) {
        this.unitRate = unitRate;
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
        if (!(o instanceof DefaultPieceFreightPo)) {return false;}
        final DefaultPieceFreightPo other = (DefaultPieceFreightPo) o;
        if (!other.canEqual((Object) this)) {return false;}
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) {return false;}
        final Object this$destination = this.getDestination();
        final Object other$destination = other.getDestination();
        if (this$destination == null ? other$destination != null : !this$destination.equals(other$destination))
        {    return false;}
        final Object this$unitRate = this.getUnitRate();
        final Object other$unitRate = other.getUnitRate();
        if (this$unitRate == null ? other$unitRate != null : !this$unitRate.equals(other$unitRate)) {return false;}
        final Object this$requireDays = this.getRequireDays();
        final Object other$requireDays = other.getRequireDays();
        if (this$requireDays == null ? other$requireDays != null : !this$requireDays.equals(other$requireDays))
        {    return false;}
        final Object this$gmtCreate = this.getGmtCreate();
        final Object other$gmtCreate = other.getGmtCreate();
        if (this$gmtCreate == null ? other$gmtCreate != null : !this$gmtCreate.equals(other$gmtCreate)) {return false;}
        final Object this$gmtModified = this.getGmtModified();
        final Object other$gmtModified = other.getGmtModified();
        if (this$gmtModified == null ? other$gmtModified != null : !this$gmtModified.equals(other$gmtModified))
        {    return false;}
        final Object this$beDeleted = this.getBeDeleted();
        final Object other$beDeleted = other.getBeDeleted();
        if (this$beDeleted == null ? other$beDeleted != null : !this$beDeleted.equals(other$beDeleted)){ return false;}
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof DefaultPieceFreightPo;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $destination = this.getDestination();
        result = result * PRIME + ($destination == null ? 43 : $destination.hashCode());
        final Object $unitRate = this.getUnitRate();
        result = result * PRIME + ($unitRate == null ? 43 : $unitRate.hashCode());
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
        return "DefaultPieceFreightPo(id=" + this.getId() + ", destination=" + this.getDestination() + ", unitRate=" + this.getUnitRate() + ", requireDays=" + this.getRequireDays() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
