package com.xmu.wowoto.wowomall.domain;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:日志信息
 * @Data:Created in 14:50 2019/12/11
 **/
public class Log {
    public Integer getId() {
        return this.id;
    }

    public Integer getAdminId() {
        return this.adminId;
    }

    public String getIp() {
        return this.ip;
    }

    public Integer getType() {
        return this.type;
    }

    public String getActions() {
        return this.actions;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public Integer getActionId() {
        return this.actionId;
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

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {return true;}
        if (!(o instanceof Log)){ return false;}
        final Log other = (Log) o;
        if (!other.canEqual((Object) this)) {return false;}
        final Object thisId = this.getId();
        final Object otherId = other.getId();
        if (thisId == null ? otherId != null : !thisId.equals(otherId)) {return false;}
        final Object thisAdminId = this.getAdminId();
        final Object otherAdminId = other.getAdminId();
        if (thisAdminId == null ? otherAdminId != null : !thisAdminId.equals(otherAdminId)) {return false;}
        final Object thisIp = this.getIp();
        final Object otherIp = other.getIp();
        if (thisIp == null ? otherIp != null : !thisIp.equals(otherIp)) {return false;}
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)){ return false;}
        final Object thisActions = this.getActions();
        final Object otherActions = other.getActions();
        if (thisActions == null ? otherActions != null : !thisActions.equals(otherActions)) {return false;}
        final Object this$statusCode = this.getStatusCode();
        final Object other$statusCode = other.getStatusCode();
        if (this$statusCode == null ? other$statusCode != null : !this$statusCode.equals(other$statusCode))
        { return false;}
        final Object thisActionId = this.getActionId();
        final Object otherActionId = other.getActionId();
        if (thisActionId == null ? otherActionId != null : !thisActionId.equals(otherActionId)) {return false;}
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
        return other instanceof Log;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object Id = this.getId();
        result = result * PRIME + (Id == null ? 43 : Id.hashCode());
        final Object AdminId = this.getAdminId();
        result = result * PRIME + (AdminId == null ? 43 : AdminId.hashCode());
        final Object Ip = this.getIp();
        result = result * PRIME + (Ip == null ? 43 : Ip.hashCode());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        final Object Actions = this.getActions();
        result = result * PRIME + (Actions == null ? 43 : Actions.hashCode());
        final Object $statusCode = this.getStatusCode();
        result = result * PRIME + ($statusCode == null ? 43 : $statusCode.hashCode());
        final Object ActionId = this.getActionId();
        result = result * PRIME + (ActionId == null ? 43 : ActionId.hashCode());
        final Object $gmtCreate = this.getGmtCreate();
        result = result * PRIME + ($gmtCreate == null ? 43 : $gmtCreate.hashCode());
        final Object $gmtModified = this.getGmtModified();
        result = result * PRIME + ($gmtModified == null ? 43 : $gmtModified.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Log(id=" + this.getId() + ", adminId=" + this.getAdminId() + ", ip=" + this.getIp() + ", type=" + this.getType() + ", actions=" + this.getActions() + ", statusCode=" + this.getStatusCode() + ", actionId=" + this.getActionId() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ")";
    }


    public enum Type{
        SELECT(0),
        INSERT(1),
        UPDATE(2),
        DELETE(3);

        private final int value;

        Type(int value) { this.value = value; }

        public int getValue() { return value; }

    }

    private Integer id;
    /**
     * 进行该操作的管理员ID
     */
    private Integer adminId;
    /**
     * 操作者的IP地址
     */
    private String ip;
    /**
     * 操作的类型
     * 0 查询，1 插入，2修改，3删除(逻辑删除)
     */
    private Integer type;
    /**
     * 操作的动作
     */
    private String actions;
    /**
     * 操作的状态，0表示操作失败，1表示操作成功
     */
    private Integer statusCode;
    /**
     * 操作对象的ID
     */
    private Integer actionId;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;

    public Log(){
        super();
    }
    public Log(HttpServletRequest request, Integer type, String actions, Integer statusCode, Integer actionId){
        this.adminId = Integer.valueOf(request.getHeader("id"));
        this.ip = request.getRemoteAddr();
        this.type = type;
        this.actions = actions;
        this.statusCode = statusCode;
        this.actionId = actionId;
    }

}
