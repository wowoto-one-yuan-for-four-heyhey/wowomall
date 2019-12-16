package com.xmu.wowoto.wowomall.domain.Po;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: 数据库与对象模型标准组
 * @Description: 订单明细
 * @Date: Created in 14:35 2019/12/11
 **/
public class OrderItemPo {
    private Integer id;
    /**
     * 所属订单的ID
     */
    private Integer orderId;
    /**
     *下单时商品类型，0普通商品，1预售商品，2团购商品
     */
    private Integer itemType;
    /**
     *订单项状态，0未付款，1未发货，2未收货，3未评价，4已完成订单(无售后或售后拒绝)，5申请退货，6退货成功，7申请换货，8换货成功，9待付尾款
     */
    private Integer statusCode;
    /**
     * 数量
     */
    private Integer number;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 成交价格，用于退货
     */
    private BigDecimal dealPrice;
    /**
     * 订单项对应货品ID
     */
    private Integer productId;
    /**
     * 订单项对应商品ID（冗余存储）
     */
    private Integer goodsId;
    /**
     * 订单项对应商品的描述（冗余存储）
     * JSON格式: {"name":xyz, "specifications":{"xxx": xxx, "yyy":yyy}}
     */
    private String nameWithSpecifications;
    /**
     * 订单项对应商品图片（冗余存储）
     */
    private String picUrl;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
    private Boolean beDeleted;

    public Integer getId() {
        return this.id;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public Integer getItemType() {
        return this.itemType;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public Integer getNumber() {
        return this.number;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public BigDecimal getDealPrice() {
        return this.dealPrice;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public Integer getGoodsId() {
        return this.goodsId;
    }

    public String getNameWithSpecifications() {
        return this.nameWithSpecifications;
    }

    public String getPicUrl() {
        return this.picUrl;
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

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDealPrice(BigDecimal dealPrice) {
        this.dealPrice = dealPrice;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public void setNameWithSpecifications(String nameWithSpecifications) {
        this.nameWithSpecifications = nameWithSpecifications;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
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
        if (!(o instanceof OrderItemPo)) return false;
        final OrderItemPo other = (OrderItemPo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$orderId = this.getOrderId();
        final Object other$orderId = other.getOrderId();
        if (this$orderId == null ? other$orderId != null : !this$orderId.equals(other$orderId)) return false;
        final Object this$itemType = this.getItemType();
        final Object other$itemType = other.getItemType();
        if (this$itemType == null ? other$itemType != null : !this$itemType.equals(other$itemType)) return false;
        final Object this$statusCode = this.getStatusCode();
        final Object other$statusCode = other.getStatusCode();
        if (this$statusCode == null ? other$statusCode != null : !this$statusCode.equals(other$statusCode))
            return false;
        final Object this$number = this.getNumber();
        final Object other$number = other.getNumber();
        if (this$number == null ? other$number != null : !this$number.equals(other$number)) return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final Object this$dealPrice = this.getDealPrice();
        final Object other$dealPrice = other.getDealPrice();
        if (this$dealPrice == null ? other$dealPrice != null : !this$dealPrice.equals(other$dealPrice)) return false;
        final Object this$productId = this.getProductId();
        final Object other$productId = other.getProductId();
        if (this$productId == null ? other$productId != null : !this$productId.equals(other$productId)) return false;
        final Object this$goodsId = this.getGoodsId();
        final Object other$goodsId = other.getGoodsId();
        if (this$goodsId == null ? other$goodsId != null : !this$goodsId.equals(other$goodsId)) return false;
        final Object this$nameWithSpecifications = this.getNameWithSpecifications();
        final Object other$nameWithSpecifications = other.getNameWithSpecifications();
        if (this$nameWithSpecifications == null ? other$nameWithSpecifications != null : !this$nameWithSpecifications.equals(other$nameWithSpecifications))
            return false;
        final Object this$picUrl = this.getPicUrl();
        final Object other$picUrl = other.getPicUrl();
        if (this$picUrl == null ? other$picUrl != null : !this$picUrl.equals(other$picUrl)) return false;
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
        return other instanceof OrderItemPo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $orderId = this.getOrderId();
        result = result * PRIME + ($orderId == null ? 43 : $orderId.hashCode());
        final Object $itemType = this.getItemType();
        result = result * PRIME + ($itemType == null ? 43 : $itemType.hashCode());
        final Object $statusCode = this.getStatusCode();
        result = result * PRIME + ($statusCode == null ? 43 : $statusCode.hashCode());
        final Object $number = this.getNumber();
        result = result * PRIME + ($number == null ? 43 : $number.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $dealPrice = this.getDealPrice();
        result = result * PRIME + ($dealPrice == null ? 43 : $dealPrice.hashCode());
        final Object $productId = this.getProductId();
        result = result * PRIME + ($productId == null ? 43 : $productId.hashCode());
        final Object $goodsId = this.getGoodsId();
        result = result * PRIME + ($goodsId == null ? 43 : $goodsId.hashCode());
        final Object $nameWithSpecifications = this.getNameWithSpecifications();
        result = result * PRIME + ($nameWithSpecifications == null ? 43 : $nameWithSpecifications.hashCode());
        final Object $picUrl = this.getPicUrl();
        result = result * PRIME + ($picUrl == null ? 43 : $picUrl.hashCode());
        final Object $gmtCreate = this.getGmtCreate();
        result = result * PRIME + ($gmtCreate == null ? 43 : $gmtCreate.hashCode());
        final Object $gmtModified = this.getGmtModified();
        result = result * PRIME + ($gmtModified == null ? 43 : $gmtModified.hashCode());
        final Object $beDeleted = this.getBeDeleted();
        result = result * PRIME + ($beDeleted == null ? 43 : $beDeleted.hashCode());
        return result;
    }

    public String toString() {
        return "OrderItemPo(id=" + this.getId() + ", orderId=" + this.getOrderId() + ", itemType=" + this.getItemType() + ", statusCode=" + this.getStatusCode() + ", number=" + this.getNumber() + ", price=" + this.getPrice() + ", dealPrice=" + this.getDealPrice() + ", productId=" + this.getProductId() + ", goodsId=" + this.getGoodsId() + ", nameWithSpecifications=" + this.getNameWithSpecifications() + ", picUrl=" + this.getPicUrl() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
