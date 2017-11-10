package com.lcl.manager.sys.controller;

import com.lcl.manager.core.controller.BaseController;
import com.lcl.manager.sys.entity.vo.LoginVO;
import com.lcl.manager.sys.service.LoginService;
import com.lcl.manager.util.BaseResult;
import com.lcl.manager.util.ConstantsCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title: 登录
 * @Package com.lcl.manager.login
 * @Description: 登录
 * @date 2017/10/31
 */
@Api(value = "用户登录", tags = {"用户登录登出"})
@RestController
@RequestMapping(value = "login")
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;
    /**
     * 用户登录
     * @param loginVO
     * @return
     */
    @ApiOperation(value="用户登录操作",
            notes="用户登录操作",
            httpMethod = "POST",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "doLogin",method = {RequestMethod.POST})
    public Object doLogin(@RequestBody @Validated  LoginVO loginVO, BindingResult bindingResult){
        BaseResult baseResult = this.getValidatedInfo(bindingResult);
        if(!ConstantsCode.SYS_SUCCESS_CODE.equals(baseResult.getCode())){
            return baseResult;
        }
        return loginService.doLogin(loginVO);
    }
}
