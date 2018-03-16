package com.lcl.manager.sys.entity.po;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 */
@Getter
@Setter
public class SysUser implements Serializable {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 登录账号
     */
    private String loginId;
    /**
     * 密码
     */
    private String pwd;
    /**
     * name
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private Boolean sex;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * qq
     */
    private String qq;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String cel;
    /**
     * 头像url
     */
    private String avatarUrl;
    /**
     * 国家id
     */
    private Integer countryId;
    /**
     * 省id
     */
    private Integer provinceId;
    /**
     * 城市id
     */
    private Integer cityId;
    /**
     * 区id
     */
    private Integer regionId;
    /**
     * 地址
     */
    private String address;
    /**
     * 状态（1：正常，0：冻结）
     */
    private Boolean status;
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
        return "SysUser{" +
                "userId='" + userId + '\'' +
                ", loginId='" + loginId + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", nickName='" + nickName + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                ", cel='" + cel + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", countryId=" + countryId +
                ", provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", regionId=" + regionId +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", creater='" + creater + '\'' +
                ", createTime=" + createTime +
                ", updater='" + updater + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}