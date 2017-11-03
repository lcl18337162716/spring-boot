package com.lcl.manager.login.controller;

import com.lcl.manager.core.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title: 登录
 * @Package com.lcl.manager.login
 * @Description: 登录
 * @date 2017/10/31
 */
@RestController
@RequestMapping(value = "login")
public class LoginController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "test")
    public String test(){
       return "test";
    }
    @RequestMapping(value = "doLogin")
    public Object doLogin(String username,String pwd){


        return null;
    }
}
