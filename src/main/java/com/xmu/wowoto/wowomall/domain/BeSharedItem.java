package com.xmu.wowoto.wowomall.domain;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:被分享明细
 * @Data:Created in 14:50 2019/11/29
 * @Modified By:
 **/

public class BeSharedItem {

    private Integer id;
    /**
     * 分享者的id
     */
    private Integer sharerId;
    /**
     * 被分享者的id
     */
    private Integer beSharedUserId;
    /**
     * 状态 0：表示分享成功 1：表示成功购买且未退货
     */
    private Short statusCode;
    /**
     * 分享成功时的时间
     */
    private LocalDateTime birthTime;

    @Override
    public String toString() {
        return "BeSharedItem{" +
                "id=" + id +
                ", sharerId=" + sharerId +
                ", beSharedUserId=" + beSharedUserId +
                ", statusCode=" + statusCode +
                ", birthTime=" + birthTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        BeSharedItem that = (BeSharedItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSharerId() {
        return sharerId;
    }

    public void setSharerId(Integer sharerId) {
        this.sharerId = sharerId;
    }

    public Integer getBeSharedUserId() {
        return beSharedUserId;
    }

    public void setBeSharedUserId(Integer beSharedUserId) {
        this.beSharedUserId = beSharedUserId;
    }

    public Short getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Short statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDateTime getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(LocalDateTime birthTime) {
        this.birthTime = birthTime;
    }
}
