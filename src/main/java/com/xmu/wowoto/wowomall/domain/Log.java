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
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Log;
    }

    @Override
    public int hashCode() {

        return 0;
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
