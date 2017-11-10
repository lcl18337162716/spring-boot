package com.lcl.manager.sys.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title: 用户登录实体类
 * @Package com.lcl.manager.sys.entity.vo
 * @Description: 用于登录的实体类
 * @date 2017/11/8
 */
@Setter
@Getter
@ApiModel(value="loginVO",description="用户登录VO")
public class LoginVO implements Serializable {
    @ApiModelProperty(value="用户名",name="loginId",example="admin",required = true)
    @NotBlank(message = "用户名不能为空")
    private String loginId;
    @ApiModelProperty(value="密码",name="pwd",example="a123456",required = true)
    @NotBlank(message = "密码不能为空")
    private String pwd;

    @Override
    public String toString() {
        return "LoginVO{" +
                "loginId='" + loginId + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
