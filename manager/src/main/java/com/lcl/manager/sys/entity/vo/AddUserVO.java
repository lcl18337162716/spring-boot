package com.lcl.manager.sys.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * @author PVer
 * @version V1.0
 * @Title: ${FILE_NAME}
 * @Package com.lcl.manager.sys.entity.vo
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2017/12/8
 */
@Getter
@Setter
@ApiModel(value="AddUserVO",description="添加用户VO")
public class AddUserVO implements Serializable{
    /**
     * 登录账号
     */
    @ApiModelProperty(value="用户id",name="loginId",example="admin",required = true)
    @NotBlank(message = "用户名不能为空")
    private String loginId;
    /**
     * name
     */
    @ApiModelProperty(value="用户名",name="name",example="admin",required = true)
    @NotBlank(message = "用户名不能为空")
    private String name;

    @ApiModelProperty(value = "密码", name = "pwd", example = "a123456", required = true)
    @Pattern(regexp = "^[a-zA-Z]\\w{5,17}$", message = "密码以字母开头，长度在6~18之间，只能包含字符、数字和下划线")
    private String pwd;
    /**
     * 年龄
     */
    @ApiModelProperty(value="年龄",name="age",example="1",required = true)
    @Min(value = 1,message = "用户名年龄最小为1")
    private Integer age;
    /**
     * 性别
     */
    @ApiModelProperty(value="性别",name="sex",example="1",required = true)
    private Integer sex;
    /**
     * 昵称
     */
    @ApiModelProperty(value="用户昵称",name="nickName",example="admin",required = true)
    @NotBlank(message = "用户昵称不能为空")
    private String nickName;
    /**
     * qq
     */
    @ApiModelProperty(value="用户名",name="qq",example="18261584",required = true)
    private String qq;
    /**
     * 邮箱
     */
    @ApiModelProperty(value="邮箱",name="email",example="21515@163.COM",required = true)
    private String email;
    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号",name="cel",example="18337162716",required = true)
    @Pattern(regexp = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$",message = "手机号不合法")
    private String cel;
    /**
     * 头像url
     */
    @ApiModelProperty(value="头像url",name="avatarUrl",example="",required = true)
    private String avatarUrl;
    /**
     * 国家id
     */
    @ApiModelProperty(value="国家id",name="countryId",example="1221",required = true)
    private Integer countryId;
    /**
     * 省id
     */
    @ApiModelProperty(value="省",name="provinceId",example="1231",required = true)
    private Integer provinceId;
    /**
     * 城市id
     */
    @ApiModelProperty(value="城市",name="cityId",example="1231",required = true)
    private Integer cityId;
    /**
     * 区id
     */
    @ApiModelProperty(value="用户名",name="loginId",example="124123",required = true)
    private Integer regionId;
    /**
     * 地址
     */
    @ApiModelProperty(value="地址不能为空",name="address",example="",required = true)
    @NotBlank(message = "地址不能为空")
    private String address;


    @Override
    public String toString() {
        return "SysUser{" +
                ", loginId='" + loginId + '\'' +
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
                '}';
    }
}
