package com.xmu.wowoto.wowomall.domain;

import java.time.LocalDateTime;

/**
 * @Author: 数据库与对象模型标准组
 * @Description: 用户信息
 * @Date: Created in 16:00 2019/12/11
 **/
public class User {

    private Integer id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 密码
     */
    private String password;
    /**
     * 0：男， 1：女
     */
    private Integer gender;
    /**
     * 生日
     */
    private LocalDateTime birthday;
    /**
     * 用户电话
     */
    private String mobile;
    /**
     * 用户积分
     */
    private Integer rebate;
    /**
     * 用户头像图片
     */
    private String avatar;
    /**
     * 最后一次登录时间
     */
    private LocalDateTime lastLoginTime;
    /**
     * 最后一次登录IP
     */
    private String lastLoginIp;
    /**
     * 用户级别
     */
    private Integer userLevel;
    /**
     * 微信Open ID
     */
    private String wxOpenId;
    /**
     * 微信会话Key
     */
    private String sessionKey;
    /**
     * 用户权限id
     */
    private Integer roleId;

    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
    private Boolean beDeleted;

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getPassword() {
        return this.password;
    }

    public Integer getGender() {
        return this.gender;
    }

    public LocalDateTime getBirthday() {
        return this.birthday;
    }

    public String getMobile() {
        return this.mobile;
    }

    public Integer getRebate() {
        return this.rebate;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public LocalDateTime getLastLoginTime() {
        return this.lastLoginTime;
    }

    public String getLastLoginIp() {
        return this.lastLoginIp;
    }

    public Integer getUserLevel() {
        return this.userLevel;
    }

    public String getWxOpenId() {
        return this.wxOpenId;
    }

    public String getSessionKey() {
        return this.sessionKey;
    }

    public Integer getRoleId() {
        return this.roleId;
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

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setRebate(Integer rebate) {
        this.rebate = rebate;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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
        return other instanceof User;
    }

    @Override
    public int hashCode() {

        return 0;
    }

    @Override
    public String toString() {
        return "User(id=" + this.getId() + ", name=" + this.getName() + ", nickname=" + this.getNickname() + ", password=" + this.getPassword() + ", gender=" + this.getGender() + ", birthday=" + this.getBirthday() + ", mobile=" + this.getMobile() + ", rebate=" + this.getRebate() + ", avatar=" + this.getAvatar() + ", lastLoginTime=" + this.getLastLoginTime() + ", lastLoginIp=" + this.getLastLoginIp() + ", userLevel=" + this.getUserLevel() + ", wxOpenId=" + this.getWxOpenId() + ", sessionKey=" + this.getSessionKey() + ", roleId=" + this.getRoleId() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
