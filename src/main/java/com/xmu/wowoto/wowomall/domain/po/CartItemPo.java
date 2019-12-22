package com.xmu.wowoto.wowomall.domain.po;

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

        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CartItemPo;
    }

    @Override
    public int hashCode() {

        return 0;
    }

    @Override
    public String toString() {
        return "CartItemPo(id=" + this.getId() + ", userId=" + this.getUserId() + ", productId=" + this.getProductId() + ", beCheck=" + this.getBeCheck() + ", number=" + this.getNumber() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ")";
    }
}
