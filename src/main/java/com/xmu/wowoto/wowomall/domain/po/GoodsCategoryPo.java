package com.xmu.wowoto.wowomall.domain.po;


import java.time.LocalDateTime;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:商品种类的信息
 * @Data:Created in 14:50 2019/12/11
 **/
public class GoodsCategoryPo {
    private Integer id;
    /**
     * 种类的名称
     */
    private String name;
    /**
     * 该种类的父种类ID
     */
    private Integer pid;
    /**
     * 二级目录的pic
     */
    private String picUrl;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
    private Boolean beDeleted;

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPid() {
        return this.pid;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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
        if (o == this) {return true;}
        if (!(o instanceof GoodsCategoryPo)){ return false;}
        final GoodsCategoryPo other = (GoodsCategoryPo) o;
        if (!other.canEqual((Object) this)) {return false;}
        final Object thisId = this.getId();
        final Object otherId = other.getId();
        if (thisId == null ? otherId != null : !thisId.equals(otherId)) {return false;}
        final Object thisName = this.getName();
        final Object otherName = other.getName();
        if (thisName == null ? otherName != null : !thisName.equals(otherName)) {return false;}
        final Object thisPid = this.getPid();
        final Object otherPid = other.getPid();
        if (thisPid == null ? otherPid != null : !thisPid.equals(otherPid)) {return false;}
        final Object thisPicUrl = this.getPicUrl();
        final Object otherPicUrl  = other.getPicUrl();
        if (thisPicUrl == null ? otherPicUrl  != null : !thisPicUrl.equals(otherPicUrl )) {return false;}
        final Object thisGmtCreate = this.getGmtCreate();
        final Object otherGmtCreate = other.getGmtCreate();
        if (thisGmtCreate == null ? otherGmtCreate != null : !thisGmtCreate.equals(otherGmtCreate)){ return false;}
        final Object thisGmtModified = this.getGmtModified();
        final Object otherGmtModified = other.getGmtModified();
        if (thisGmtModified == null ? otherGmtModified != null : !thisGmtModified.equals(otherGmtModified))
        { return false;}
        final Object thisBeDeleted = this.getBeDeleted();
        final Object otherBeDeleted = other.getBeDeleted();
        if (thisBeDeleted == null ? otherBeDeleted != null : !thisBeDeleted.equals(otherBeDeleted)){ return false;}
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof GoodsCategoryPo;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        final Object id = this.getId();
        result = result * prime + (id == null ? 43 : id.hashCode());
        final Object name = this.getName();
        result = result * prime + (name == null ? 43 : name.hashCode());
        final Object pid = this.getPid();
        result = result * prime + (pid == null ? 43 : pid.hashCode());
        final Object picUrl = this.getPicUrl();
        result = result * prime + (picUrl == null ? 43 : picUrl.hashCode());
        final Object gmtCreate = this.getGmtCreate();
        result = result * prime + (gmtCreate == null ? 43 : gmtCreate.hashCode());
        final Object gmtModified= this.getGmtModified();
        result = result * prime + (gmtModified== null ? 43 : gmtModified.hashCode());
        final Object beDeleted = this.getBeDeleted();
        result = result * prime + (beDeleted == null ? 43 : beDeleted.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GoodsCategoryPo(id=" + this.getId() + ", name=" + this.getName() + ", pid=" + this.getPid() + ", picUrl=" + this.getPicUrl() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
