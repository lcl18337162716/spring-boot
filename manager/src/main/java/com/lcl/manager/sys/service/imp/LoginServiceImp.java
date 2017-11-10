package com.lcl.manager.sys.service.imp;

import com.lcl.manager.core.jwt.JwtTokenUtil;
import com.lcl.manager.sys.dao.SysUserDAO;
import com.lcl.manager.sys.entity.po.SysUser;
import com.lcl.manager.sys.entity.vo.LoginVO;
import com.lcl.manager.sys.service.LoginService;
import com.lcl.manager.util.BaseResult;
import com.lcl.manager.util.ConstantsCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title: 用户登录Service接口实现
 * @Package com.lcl.manager.login.service.imp
 * @Description: 用户登录Service接口实现
 * @date 2017/10/31
 */
@Service(value = "loginService")
public class LoginServiceImp implements LoginService {
    @Autowired
    private SysUserDAO sysUserDAO;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public BaseResult doLogin(LoginVO loginVO) {
        SysUser sysUser = sysUserDAO.selectSysUserByUserLoginId(loginVO.getLoginId());
        if(sysUser == null){
            return new BaseResult(ConstantsCode.OPERATION_ERROR_CODE,"账号不存在");
        }
        if(!sysUser.getStatus()){
            return new BaseResult(ConstantsCode.OPERATION_ERROR_CODE,"账号已经冻结");
        }
        if(!loginVO.getPwd().equals(sysUser.getPwd())){
            return new BaseResult(ConstantsCode.OPERATION_ERROR_CODE,"账号或密码错误");
        }
        Map<String,Object> oMap = new HashMap<String,Object>();
        oMap.put("token",jwtTokenUtil.generateToken(sysUser.getUserId()));
        oMap.put("userInfo",sysUser);
        return new BaseResult(ConstantsCode.SYS_SUCCESS_CODE,ConstantsCode.SYS_SUCCESS_MSG,oMap);
    }
}
