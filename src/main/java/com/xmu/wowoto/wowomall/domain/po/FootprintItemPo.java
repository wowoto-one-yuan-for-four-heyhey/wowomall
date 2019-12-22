package com.xmu.wowoto.wowomall.domain.po;

import java.time.LocalDateTime;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:足迹信息
 * @Data:Created in 14:50 2019/12/11
 **/
public class FootprintItemPo {
    private Integer id;

    /**
    *创建时间
    */
    private LocalDateTime birthTime;
    /**
    *用户id
    */
    private Integer userId;
    /**
    *商品id
    */
    private Integer goodsId;
    private LocalDateTime gmtCreate;

    public Integer getId() {
        return this.id;
    }

    public LocalDateTime getBirthTime() {
        return this.birthTime;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public Integer getGoodsId() {
        return this.goodsId;
    }

    public LocalDateTime getGmtCreate() {
        return this.gmtCreate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBirthTime(LocalDateTime birthTime) {
        this.birthTime = birthTime;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Override
    public boolean equals(final Object o) {

        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof FootprintItemPo;
    }

    @Override
    public int hashCode() {

        return 0;
    }

    @Override
    public String toString() {
        return "FootprintItemPo(id=" + this.getId() + ", birthTime=" + this.getBirthTime() + ", userId=" + this.getUserId() + ", goodsId=" + this.getGoodsId() + ", gmtCreate=" + this.getGmtCreate() + ")";
    }
}
