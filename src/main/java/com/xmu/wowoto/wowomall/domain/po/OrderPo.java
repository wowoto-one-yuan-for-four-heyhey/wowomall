package com.xmu.wowoto.wowomall.domain.po;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: 数据库与对象模型标准组
 * @Description: 订单明细
 * @Date: Created in 15:19 2019/12/11
 **/
public class OrderPo {
    private Integer id;
    /**
     * 下单用户
     */
    private Integer userId;
    /**
     * 订单序号
     */
    private String orderSn;
    /**
     * 订单状态
     * 0：订单生成,未支付
     * 1：下单后未支付，用户取消
     * 2：下单后未支付超时系统自动取消
     * 3：支付完成，商家未发货
     * 4：订单产生，已付款未发货，此时用户取消订单并取得退款（在发货前只要用户点取消订单，无需经过审核）
     * 5:商家发货，用户未确认
     * 6:用户确认收货
     * 7:用户没有确认收货超过一定时间，系统自动确认收货
     * 8:已评价
     */
    private Integer statusCode;
    /**
     * 收件人姓名
     */
    private String consignee;
    /**
     * 联系电话
     */
    private String mobile;
    /**
     * 留言
     */
    private String message;
    /**
     * 商品总价
     */
    private BigDecimal goodsPrice;
    /**
     * 优惠卷减免费用
     */
    private BigDecimal couponPrice;
    /**
     * 返点减免费用
     */
    private BigDecimal rebatePrice;
    /**
     * 配送费用
     */
    private BigDecimal freightPrice;
    /**
     * 总费用
     */
    private BigDecimal integralPrice;
    /**
     * 快递单编号
     */
    private String shipSn;
    /**
     * 发货快递公司
     */
    private String shipChannel;
    /**
     * 发货时间
     */
    private LocalDateTime shipTime;
    /**
     * 用户收货确认时间
     */
    private LocalDateTime confirmTime;
    /**
     * 订单关闭时间
     */
    private LocalDateTime endTime;
    /**
     * 订单支付时间
     */
    private LocalDateTime payTime;
    /**
     * 父订单Id
     */
    private Integer parentId;
    /**
     * 收货地址
     */
    private String address;

    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
    private Boolean beDeleted;

    public Integer getId() {
        return this.id;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public String getOrderSn() {
        return this.orderSn;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public String getConsignee() {
        return this.consignee;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getMessage() {
        return this.message;
    }

    public BigDecimal getGoodsPrice() {
        return this.goodsPrice;
    }

    public BigDecimal getCouponPrice() {
        return this.couponPrice;
    }

    public BigDecimal getRebatePrice() {
        return this.rebatePrice;
    }

    public BigDecimal getFreightPrice() {
        return this.freightPrice;
    }

    public BigDecimal getIntegralPrice() {
        return this.integralPrice;
    }

    public String getShipSn() {
        return this.shipSn;
    }

    public String getShipChannel() {
        return this.shipChannel;
    }

    public LocalDateTime getShipTime() {
        return this.shipTime;
    }

    public LocalDateTime getConfirmTime() {
        return this.confirmTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public LocalDateTime getPayTime() {
        return this.payTime;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public String getAddress() {
        return this.address;
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

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    public void setRebatePrice(BigDecimal rebatePrice) {
        this.rebatePrice = rebatePrice;
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
    }

    public void setIntegralPrice(BigDecimal integralPrice) {
        this.integralPrice = integralPrice;
    }

    public void setShipSn(String shipSn) {
        this.shipSn = shipSn;
    }

    public void setShipChannel(String shipChannel) {
        this.shipChannel = shipChannel;
    }

    public void setShipTime(LocalDateTime shipTime) {
        this.shipTime = shipTime;
    }

    public void setConfirmTime(LocalDateTime confirmTime) {
        this.confirmTime = confirmTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return other instanceof OrderPo;
    }

    @Override
    public int hashCode() {

        return 0;
    }

    @Override
    public String toString() {
        return "OrderPo(id=" + this.getId() + ", userId=" + this.getUserId() + ", orderSn=" + this.getOrderSn() + ", statusCode=" + this.getStatusCode() + ", consignee=" + this.getConsignee() + ", mobile=" + this.getMobile() + ", message=" + this.getMessage() + ", goodsPrice=" + this.getGoodsPrice() + ", couponPrice=" + this.getCouponPrice() + ", rebatePrice=" + this.getRebatePrice() + ", freightPrice=" + this.getFreightPrice() + ", integralPrice=" + this.getIntegralPrice() + ", shipSn=" + this.getShipSn() + ", shipChannel=" + this.getShipChannel() + ", shipTime=" + this.getShipTime() + ", confirmTime=" + this.getConfirmTime() + ", endTime=" + this.getEndTime() + ", payTime=" + this.getPayTime() + ", parentId=" + this.getParentId() + ", address=" + this.getAddress() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
