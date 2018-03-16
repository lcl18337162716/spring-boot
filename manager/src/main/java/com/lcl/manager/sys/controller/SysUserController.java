package com.lcl.manager.sys.controller;

import com.lcl.manager.core.controller.BaseController;
import com.lcl.manager.core.exceptionHandler.MyException;
import com.lcl.manager.core.jwt.JwtTokenUtil;
import com.lcl.manager.sys.entity.po.SysUser;
import com.lcl.manager.sys.entity.vo.AddUserVO;
import com.lcl.manager.sys.entity.vo.SearchUserVO;
import com.lcl.manager.sys.service.SysUserService;
import com.lcl.manager.util.BaseResult;
import com.lcl.manager.util.ConstantsCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title: 用户管理控制类
 * @Package com.lcl.manager.sys.controller
 * @Description: 用户管理控制类
 * @date 2017/11/14
 */
@Api(value = "用户管理", description = "用户管理")
@RestController
@RequestMapping(value = "user")
public class SysUserController extends BaseController{

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @ApiOperation(value="用户list查询",
            notes="用户list查询",
            httpMethod = "POST",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "selectUserList",method = {RequestMethod.POST})
    public Object selectUserList(@RequestBody SearchUserVO searchUserVO){
        this.load(searchUserVO.getPageNo(),searchUserVO.getPageSize());
        return sysUserService.selectUserList(searchUserVO,this.getPageNo(),this.getPageSize());
    }

    @ApiOperation(value="根据id删除用户",notes="根据id删除用户")
    @RequestMapping(value = "deleteUserById",method = {RequestMethod.GET})
    public Object deleteUserById(@RequestParam(required = true) String userId){
        return sysUserService.deleteUserById(userId);
    }

    @ApiOperation(value="添加用户",notes="添加用户")
    @RequestMapping(value = "addUser",method = {RequestMethod.POST})
    public Object addUser(@RequestBody @Validated AddUserVO addUserVO, BindingResult bindingResult
                          /*@RequestHeader(value = "token") String token*/) throws MyException {
        BaseResult baseResult = this.getValidatedInfo(bindingResult);
        if(!ConstantsCode.SYS_SUCCESS_CODE.equals(baseResult.getCode())){
            return baseResult;
        }
        //String userId = jwtTokenUtil.getJwtUserIdFromToken(token);
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(addUserVO,sysUser);
        //sysUser.setCreater(userId);
        //sysUser.setUpdater(userId);
        return sysUserService.addUser(sysUser);
    }
}
