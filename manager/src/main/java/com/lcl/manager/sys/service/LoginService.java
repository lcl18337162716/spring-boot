package com.lcl.manager.sys.service;

import com.lcl.manager.sys.entity.vo.LoginVO;
import com.lcl.manager.util.BaseResult;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title: LoginService
 * @Package com.lcl.manager.login.service
 * @Description: LoginService接口
 * @date 2017/10/31
 */
public interface LoginService {
    BaseResult doLogin(LoginVO loginVO);
}
