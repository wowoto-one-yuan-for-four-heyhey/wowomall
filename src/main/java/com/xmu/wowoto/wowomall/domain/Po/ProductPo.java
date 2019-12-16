package com.xmu.wowoto.wowomall.domain.Po;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: 数据库与对象模型标准组
 * @Description: 产品信息
 * @Date: Created in 16:00 2019/12/11
 **/
public class ProductPo {

    private Integer id;
    /**
     * 产品对应商品的id
     */
    private Integer goodsId;
    /**
     * 产品图片的url
     */
    private String picUrl;
    /**
     * sku属性，用于描述特定货品，如红色，41码
     * JSON格式，针对不同规格有不同的描述
     * eg1. {"color": "red", "size": 41}，可以表示红色41码
     * eg2. {"color": "black", "volume": 500}，可以表示黑色500ml的水杯
     */
    private String specifications;
    /**
     * 产品价格
     */
    private BigDecimal price;
    /**
     * 产品安全库存
     */
    private Integer safetyStock;

    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
    private Boolean beDeleted;

    public Integer getId() {
        return this.id;
    }

    public Integer getGoodsId() {
        return this.goodsId;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getSpecifications() {
        return this.specifications;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public Integer getSafetyStock() {
        return this.safetyStock;
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

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setSafetyStock(Integer safetyStock) {
        this.safetyStock = safetyStock;
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
        if (!(o instanceof ProductPo)) return false;
        final ProductPo other = (ProductPo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$goodsId = this.getGoodsId();
        final Object other$goodsId = other.getGoodsId();
        if (this$goodsId == null ? other$goodsId != null : !this$goodsId.equals(other$goodsId)) return false;
        final Object this$picUrl = this.getPicUrl();
        final Object other$picUrl = other.getPicUrl();
        if (this$picUrl == null ? other$picUrl != null : !this$picUrl.equals(other$picUrl)) return false;
        final Object this$specifications = this.getSpecifications();
        final Object other$specifications = other.getSpecifications();
        if (this$specifications == null ? other$specifications != null : !this$specifications.equals(other$specifications))
            return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final Object this$safetyStock = this.getSafetyStock();
        final Object other$safetyStock = other.getSafetyStock();
        if (this$safetyStock == null ? other$safetyStock != null : !this$safetyStock.equals(other$safetyStock))
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
        return other instanceof ProductPo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $goodsId = this.getGoodsId();
        result = result * PRIME + ($goodsId == null ? 43 : $goodsId.hashCode());
        final Object $picUrl = this.getPicUrl();
        result = result * PRIME + ($picUrl == null ? 43 : $picUrl.hashCode());
        final Object $specifications = this.getSpecifications();
        result = result * PRIME + ($specifications == null ? 43 : $specifications.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $safetyStock = this.getSafetyStock();
        result = result * PRIME + ($safetyStock == null ? 43 : $safetyStock.hashCode());
        final Object $gmtCreate = this.getGmtCreate();
        result = result * PRIME + ($gmtCreate == null ? 43 : $gmtCreate.hashCode());
        final Object $gmtModified = this.getGmtModified();
        result = result * PRIME + ($gmtModified == null ? 43 : $gmtModified.hashCode());
        final Object $beDeleted = this.getBeDeleted();
        result = result * PRIME + ($beDeleted == null ? 43 : $beDeleted.hashCode());
        return result;
    }

    public String toString() {
        return "ProductPo(id=" + this.getId() + ", goodsId=" + this.getGoodsId() + ", picUrl=" + this.getPicUrl() + ", specifications=" + this.getSpecifications() + ", price=" + this.getPrice() + ", safetyStock=" + this.getSafetyStock() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
