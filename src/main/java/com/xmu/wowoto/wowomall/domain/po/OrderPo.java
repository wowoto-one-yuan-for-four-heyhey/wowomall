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
        if (o == this) {return true;}
        if (!(o instanceof OrderPo)) {return false;}
        final OrderPo other = (OrderPo) o;
        if (!other.canEqual((Object) this)) {return false;}
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) {return false;}
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) {return false;}
        final Object this$orderSn = this.getOrderSn();
        final Object other$orderSn = other.getOrderSn();
        if (this$orderSn == null ? other$orderSn != null : !this$orderSn.equals(other$orderSn)) {return false;}
        final Object this$statusCode = this.getStatusCode();
        final Object other$statusCode = other.getStatusCode();
        if (this$statusCode == null ? other$statusCode != null : !this$statusCode.equals(other$statusCode))
        {return false;}
        final Object this$consignee = this.getConsignee();
        final Object other$consignee = other.getConsignee();
        if (this$consignee == null ? other$consignee != null : !this$consignee.equals(other$consignee)) {return false;}
        final Object this$mobile = this.getMobile();
        final Object other$mobile = other.getMobile();
        if (this$mobile == null ? other$mobile != null : !this$mobile.equals(other$mobile)) {return false;}
        final Object this$message = this.getMessage();
        final Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) {return false;}
        final Object this$goodsPrice = this.getGoodsPrice();
        final Object other$goodsPrice = other.getGoodsPrice();
        if (this$goodsPrice == null ? other$goodsPrice != null : !this$goodsPrice.equals(other$goodsPrice))
        {return false;}
        final Object this$couponPrice = this.getCouponPrice();
        final Object other$couponPrice = other.getCouponPrice();
        if (this$couponPrice == null ? other$couponPrice != null : !this$couponPrice.equals(other$couponPrice))
        {return false;}
        final Object this$rebatePrice = this.getRebatePrice();
        final Object other$rebatePrice = other.getRebatePrice();
        if (this$rebatePrice == null ? other$rebatePrice != null : !this$rebatePrice.equals(other$rebatePrice))
        {return false;}
        final Object this$freightPrice = this.getFreightPrice();
        final Object other$freightPrice = other.getFreightPrice();
        if (this$freightPrice == null ? other$freightPrice != null : !this$freightPrice.equals(other$freightPrice))
        {return false;}
        final Object this$integralPrice = this.getIntegralPrice();
        final Object other$integralPrice = other.getIntegralPrice();
        if (this$integralPrice == null ? other$integralPrice != null : !this$integralPrice.equals(other$integralPrice))
        {return false;}
        final Object this$shipSn = this.getShipSn();
        final Object other$shipSn = other.getShipSn();
        if (this$shipSn == null ? other$shipSn != null : !this$shipSn.equals(other$shipSn)) {return false;}
        final Object this$shipChannel = this.getShipChannel();
        final Object other$shipChannel = other.getShipChannel();
        if (this$shipChannel == null ? other$shipChannel != null : !this$shipChannel.equals(other$shipChannel))
        {return false;}
        final Object this$shipTime = this.getShipTime();
        final Object other$shipTime = other.getShipTime();
        if (this$shipTime == null ? other$shipTime != null : !this$shipTime.equals(other$shipTime)) {return false;}
        final Object this$confirmTime = this.getConfirmTime();
        final Object other$confirmTime = other.getConfirmTime();
        if (this$confirmTime == null ? other$confirmTime != null : !this$confirmTime.equals(other$confirmTime))
        {return false;}
        final Object this$endTime = this.getEndTime();
        final Object other$endTime = other.getEndTime();
        if (this$endTime == null ? other$endTime != null : !this$endTime.equals(other$endTime)) {return false;}
        final Object this$payTime = this.getPayTime();
        final Object other$payTime = other.getPayTime();
        if (this$payTime == null ? other$payTime != null : !this$payTime.equals(other$payTime)) {return false;}
        final Object this$parentId = this.getParentId();
        final Object other$parentId = other.getParentId();
        if (this$parentId == null ? other$parentId != null : !this$parentId.equals(other$parentId)) {return false;}
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) {return false;}
        final Object this$gmtCreate = this.getGmtCreate();
        final Object other$gmtCreate = other.getGmtCreate();
        if (this$gmtCreate == null ? other$gmtCreate != null : !this$gmtCreate.equals(other$gmtCreate)) {return false;}
        final Object this$gmtModified = this.getGmtModified();
        final Object other$gmtModified = other.getGmtModified();
        if (this$gmtModified == null ? other$gmtModified != null : !this$gmtModified.equals(other$gmtModified))
        {return false;}
        final Object this$beDeleted = this.getBeDeleted();
        final Object other$beDeleted = other.getBeDeleted();
        if (this$beDeleted == null ? other$beDeleted != null : !this$beDeleted.equals(other$beDeleted)) {return false;}
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OrderPo;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final Object $orderSn = this.getOrderSn();
        result = result * PRIME + ($orderSn == null ? 43 : $orderSn.hashCode());
        final Object $statusCode = this.getStatusCode();
        result = result * PRIME + ($statusCode == null ? 43 : $statusCode.hashCode());
        final Object $consignee = this.getConsignee();
        result = result * PRIME + ($consignee == null ? 43 : $consignee.hashCode());
        final Object $mobile = this.getMobile();
        result = result * PRIME + ($mobile == null ? 43 : $mobile.hashCode());
        final Object $message = this.getMessage();
        result = result * PRIME + ($message == null ? 43 : $message.hashCode());
        final Object $goodsPrice = this.getGoodsPrice();
        result = result * PRIME + ($goodsPrice == null ? 43 : $goodsPrice.hashCode());
        final Object $couponPrice = this.getCouponPrice();
        result = result * PRIME + ($couponPrice == null ? 43 : $couponPrice.hashCode());
        final Object $rebatePrice = this.getRebatePrice();
        result = result * PRIME + ($rebatePrice == null ? 43 : $rebatePrice.hashCode());
        final Object $freightPrice = this.getFreightPrice();
        result = result * PRIME + ($freightPrice == null ? 43 : $freightPrice.hashCode());
        final Object $integralPrice = this.getIntegralPrice();
        result = result * PRIME + ($integralPrice == null ? 43 : $integralPrice.hashCode());
        final Object $shipSn = this.getShipSn();
        result = result * PRIME + ($shipSn == null ? 43 : $shipSn.hashCode());
        final Object $shipChannel = this.getShipChannel();
        result = result * PRIME + ($shipChannel == null ? 43 : $shipChannel.hashCode());
        final Object $shipTime = this.getShipTime();
        result = result * PRIME + ($shipTime == null ? 43 : $shipTime.hashCode());
        final Object $confirmTime = this.getConfirmTime();
        result = result * PRIME + ($confirmTime == null ? 43 : $confirmTime.hashCode());
        final Object $endTime = this.getEndTime();
        result = result * PRIME + ($endTime == null ? 43 : $endTime.hashCode());
        final Object $payTime = this.getPayTime();
        result = result * PRIME + ($payTime == null ? 43 : $payTime.hashCode());
        final Object $parentId = this.getParentId();
        result = result * PRIME + ($parentId == null ? 43 : $parentId.hashCode());
        final Object $address = this.getAddress();
        result = result * PRIME + ($address == null ? 43 : $address.hashCode());
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
        return "OrderPo(id=" + this.getId() + ", userId=" + this.getUserId() + ", orderSn=" + this.getOrderSn() + ", statusCode=" + this.getStatusCode() + ", consignee=" + this.getConsignee() + ", mobile=" + this.getMobile() + ", message=" + this.getMessage() + ", goodsPrice=" + this.getGoodsPrice() + ", couponPrice=" + this.getCouponPrice() + ", rebatePrice=" + this.getRebatePrice() + ", freightPrice=" + this.getFreightPrice() + ", integralPrice=" + this.getIntegralPrice() + ", shipSn=" + this.getShipSn() + ", shipChannel=" + this.getShipChannel() + ", shipTime=" + this.getShipTime() + ", confirmTime=" + this.getConfirmTime() + ", endTime=" + this.getEndTime() + ", payTime=" + this.getPayTime() + ", parentId=" + this.getParentId() + ", address=" + this.getAddress() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
