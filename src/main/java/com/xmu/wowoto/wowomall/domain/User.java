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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$nickname = this.getNickname();
        final Object other$nickname = other.getNickname();
        if (this$nickname == null ? other$nickname != null : !this$nickname.equals(other$nickname)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$gender = this.getGender();
        final Object other$gender = other.getGender();
        if (this$gender == null ? other$gender != null : !this$gender.equals(other$gender)) return false;
        final Object this$birthday = this.getBirthday();
        final Object other$birthday = other.getBirthday();
        if (this$birthday == null ? other$birthday != null : !this$birthday.equals(other$birthday)) return false;
        final Object this$mobile = this.getMobile();
        final Object other$mobile = other.getMobile();
        if (this$mobile == null ? other$mobile != null : !this$mobile.equals(other$mobile)) return false;
        final Object this$rebate = this.getRebate();
        final Object other$rebate = other.getRebate();
        if (this$rebate == null ? other$rebate != null : !this$rebate.equals(other$rebate)) return false;
        final Object this$avatar = this.getAvatar();
        final Object other$avatar = other.getAvatar();
        if (this$avatar == null ? other$avatar != null : !this$avatar.equals(other$avatar)) return false;
        final Object this$lastLoginTime = this.getLastLoginTime();
        final Object other$lastLoginTime = other.getLastLoginTime();
        if (this$lastLoginTime == null ? other$lastLoginTime != null : !this$lastLoginTime.equals(other$lastLoginTime))
            return false;
        final Object this$lastLoginIp = this.getLastLoginIp();
        final Object other$lastLoginIp = other.getLastLoginIp();
        if (this$lastLoginIp == null ? other$lastLoginIp != null : !this$lastLoginIp.equals(other$lastLoginIp))
            return false;
        final Object this$userLevel = this.getUserLevel();
        final Object other$userLevel = other.getUserLevel();
        if (this$userLevel == null ? other$userLevel != null : !this$userLevel.equals(other$userLevel)) return false;
        final Object this$wxOpenId = this.getWxOpenId();
        final Object other$wxOpenId = other.getWxOpenId();
        if (this$wxOpenId == null ? other$wxOpenId != null : !this$wxOpenId.equals(other$wxOpenId)) return false;
        final Object this$sessionKey = this.getSessionKey();
        final Object other$sessionKey = other.getSessionKey();
        if (this$sessionKey == null ? other$sessionKey != null : !this$sessionKey.equals(other$sessionKey))
            return false;
        final Object this$roleId = this.getRoleId();
        final Object other$roleId = other.getRoleId();
        if (this$roleId == null ? other$roleId != null : !this$roleId.equals(other$roleId)) return false;
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
        return other instanceof User;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $nickname = this.getNickname();
        result = result * PRIME + ($nickname == null ? 43 : $nickname.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $gender = this.getGender();
        result = result * PRIME + ($gender == null ? 43 : $gender.hashCode());
        final Object $birthday = this.getBirthday();
        result = result * PRIME + ($birthday == null ? 43 : $birthday.hashCode());
        final Object $mobile = this.getMobile();
        result = result * PRIME + ($mobile == null ? 43 : $mobile.hashCode());
        final Object $rebate = this.getRebate();
        result = result * PRIME + ($rebate == null ? 43 : $rebate.hashCode());
        final Object $avatar = this.getAvatar();
        result = result * PRIME + ($avatar == null ? 43 : $avatar.hashCode());
        final Object $lastLoginTime = this.getLastLoginTime();
        result = result * PRIME + ($lastLoginTime == null ? 43 : $lastLoginTime.hashCode());
        final Object $lastLoginIp = this.getLastLoginIp();
        result = result * PRIME + ($lastLoginIp == null ? 43 : $lastLoginIp.hashCode());
        final Object $userLevel = this.getUserLevel();
        result = result * PRIME + ($userLevel == null ? 43 : $userLevel.hashCode());
        final Object $wxOpenId = this.getWxOpenId();
        result = result * PRIME + ($wxOpenId == null ? 43 : $wxOpenId.hashCode());
        final Object $sessionKey = this.getSessionKey();
        result = result * PRIME + ($sessionKey == null ? 43 : $sessionKey.hashCode());
        final Object $roleId = this.getRoleId();
        result = result * PRIME + ($roleId == null ? 43 : $roleId.hashCode());
        final Object $gmtCreate = this.getGmtCreate();
        result = result * PRIME + ($gmtCreate == null ? 43 : $gmtCreate.hashCode());
        final Object $gmtModified = this.getGmtModified();
        result = result * PRIME + ($gmtModified == null ? 43 : $gmtModified.hashCode());
        final Object $beDeleted = this.getBeDeleted();
        result = result * PRIME + ($beDeleted == null ? 43 : $beDeleted.hashCode());
        return result;
    }

    public String toString() {
        return "User(id=" + this.getId() + ", name=" + this.getName() + ", nickname=" + this.getNickname() + ", password=" + this.getPassword() + ", gender=" + this.getGender() + ", birthday=" + this.getBirthday() + ", mobile=" + this.getMobile() + ", rebate=" + this.getRebate() + ", avatar=" + this.getAvatar() + ", lastLoginTime=" + this.getLastLoginTime() + ", lastLoginIp=" + this.getLastLoginIp() + ", userLevel=" + this.getUserLevel() + ", wxOpenId=" + this.getWxOpenId() + ", sessionKey=" + this.getSessionKey() + ", roleId=" + this.getRoleId() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
