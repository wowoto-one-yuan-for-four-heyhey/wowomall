package com.xmu.wowoto.wowomall.domain.Po;

import java.time.LocalDateTime;

/**
 * @Author: 数据库与对象模型标准组
 * @Description: 购物车明细
 * @Date: Created in 14:30 2019/12/11
 **/
public class CartItemPo {
    private Integer id;
    /**
     * 购物车归属的用户id
     */
    private Integer userId;
    /**
     * 货品ID
     */
    private Integer productId;
    /**
     * 是否选中，0未选中，1已选中
     */
    private Boolean beCheck;
    /**
     * 数量
     */
    private Integer number;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;

    public Integer getId() {
        return this.id;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public Boolean getBeCheck() {
        return this.beCheck;
    }

    public Integer getNumber() {
        return this.number;
    }

    public LocalDateTime getGmtCreate() {
        return this.gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return this.gmtModified;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setBeCheck(Boolean beCheck) {
        this.beCheck = beCheck;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this){ return true;}
        if (!(o instanceof CartItemPo)) {return false;}
        final CartItemPo other = (CartItemPo) o;
        if (!other.canEqual((Object) this)) {return false;}
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)){ return false;}
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) {return false;}
        final Object this$productId = this.getProductId();
        final Object other$productId = other.getProductId();
        if (this$productId == null ? other$productId != null : !this$productId.equals(other$productId)) {return false;}
        final Object this$beCheck = this.getBeCheck();
        final Object other$beCheck = other.getBeCheck();
        if (this$beCheck == null ? other$beCheck != null : !this$beCheck.equals(other$beCheck)) {return false;}
        final Object this$number = this.getNumber();
        final Object other$number = other.getNumber();
        if (this$number == null ? other$number != null : !this$number.equals(other$number)){ return false;}
        final Object this$gmtCreate = this.getGmtCreate();
        final Object other$gmtCreate = other.getGmtCreate();
        if (this$gmtCreate == null ? other$gmtCreate != null : !this$gmtCreate.equals(other$gmtCreate)) {return false;}
        final Object this$gmtModified = this.getGmtModified();
        final Object other$gmtModified = other.getGmtModified();
        if (this$gmtModified == null ? other$gmtModified != null : !this$gmtModified.equals(other$gmtModified))
        {return false;}
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CartItemPo;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final Object $productId = this.getProductId();
        result = result * PRIME + ($productId == null ? 43 : $productId.hashCode());
        final Object $beCheck = this.getBeCheck();
        result = result * PRIME + ($beCheck == null ? 43 : $beCheck.hashCode());
        final Object $number = this.getNumber();
        result = result * PRIME + ($number == null ? 43 : $number.hashCode());
        final Object $gmtCreate = this.getGmtCreate();
        result = result * PRIME + ($gmtCreate == null ? 43 : $gmtCreate.hashCode());
        final Object $gmtModified = this.getGmtModified();
        result = result * PRIME + ($gmtModified == null ? 43 : $gmtModified.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CartItemPo(id=" + this.getId() + ", userId=" + this.getUserId() + ", productId=" + this.getProductId() + ", beCheck=" + this.getBeCheck() + ", number=" + this.getNumber() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ")";
    }
}
