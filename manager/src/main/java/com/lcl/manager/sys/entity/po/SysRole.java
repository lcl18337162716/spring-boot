package com.lcl.manager.sys.entity.po;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统角色实体类
 */
@Setter
@Getter
public class SysRole implements Serializable {
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 角色name
     */
    private String name;
    /**
     * 备注
     */
    private String remark;
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
        return "SysRole{" +
                "roleId='" + roleId + '\'' +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", creater='" + creater + '\'' +
                ", createTime=" + createTime +
                ", updater='" + updater + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}