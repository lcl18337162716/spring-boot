package com.lcl.manager.sys.entity.po;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统权限实体类
 */
@Getter
@Setter
public class SysPermission implements Serializable{
    /**
     * 权限id
     */
    private String permissionId;
    /**
     * 权限父id
     */
    private String pid;
    /**
     * 权限路径
     */
    private String pids;
    /**
     * 权限name
     */
    private String name;
    /**
     * 权限url
     */
    private String url;
    /**
     * 权限图标
     */
    private String icon;
    /**
     * 权限唯一标识
     */
    private String unique;
    /**
     * 权限类型
     */
    private Boolean type;
    /**
     * 权限状态
     */
    private Boolean status;
    /**
     * 排序
     */
    private Integer orders;
    /**
     * 创建人
     */
    private String creater;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新人
     */
    private String updater;
    /**
     * 更新时间
     */
    private Date updateTime;

    @Override
    public String toString() {
        return "SysPermission{" +
                "permissionId='" + permissionId + '\'' +
                ", pid='" + pid + '\'' +
                ", pids='" + pids + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", unique='" + unique + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", orders=" + orders +
                ", creater='" + creater + '\'' +
                ", createTime=" + createTime +
                ", updater='" + updater + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}