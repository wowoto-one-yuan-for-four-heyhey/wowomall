package com.xmu.wowoto.wowomall.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:日志信息
 * @Data:Created in 14:50 2019/12/11
 **/
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Log {
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

    public Log(HttpServletRequest request, Integer type, String actions, Integer statusCode, Integer actionId){
        this.adminId = Integer.valueOf(request.getHeader("id"));
        this.ip = request.getRemoteAddr();
        this.type = type;
        this.actions = actions;
        this.statusCode = statusCode;
        this.actionId = actionId;
    }

}
