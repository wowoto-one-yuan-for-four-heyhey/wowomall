package com.xmu.wowoto.wowomall.domain.po;

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

    @Override
    public boolean equals(final Object o) {

        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ProductPo;
    }

    @Override
    public int hashCode() {

        return 0;
    }

    @Override
    public String toString() {
        return "ProductPo(id=" + this.getId() + ", goodsId=" + this.getGoodsId() + ", picUrl=" + this.getPicUrl() + ", specifications=" + this.getSpecifications() + ", price=" + this.getPrice() + ", safetyStock=" + this.getSafetyStock() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
