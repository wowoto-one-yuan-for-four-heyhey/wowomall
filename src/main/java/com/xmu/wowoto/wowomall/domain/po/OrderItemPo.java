package com.xmu.wowoto.wowomall.domain.po;

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

    @Override
    public boolean equals(final Object o) {

        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OrderItemPo;
    }

    @Override
    public int hashCode() {

        return 0;
    }

    @Override
    public String toString() {
        return "OrderItemPo(id=" + this.getId() + ", orderId=" + this.getOrderId() + ", itemType=" + this.getItemType() + ", statusCode=" + this.getStatusCode() + ", number=" + this.getNumber() + ", price=" + this.getPrice() + ", dealPrice=" + this.getDealPrice() + ", productId=" + this.getProductId() + ", goodsId=" + this.getGoodsId() + ", nameWithSpecifications=" + this.getNameWithSpecifications() + ", picUrl=" + this.getPicUrl() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
