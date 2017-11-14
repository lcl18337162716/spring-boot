package com.lcl.manager.sys.controller;

import com.lcl.manager.core.controller.BaseController;
import com.lcl.manager.sys.entity.vo.SearchUserVO;
import com.lcl.manager.sys.service.SysUserService;
import com.lcl.manager.util.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title: 用户管理控制类
 * @Package com.lcl.manager.sys.controller
 * @Description: 用户管理控制类
 * @date 2017/11/14
 */
@Api(value = "用户管理", tags = {"用户管理"})
@RestController
@RequestMapping(value = "user")
public class SysUserController extends BaseController{

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value="用户list查询",
            notes="用户list查询",
            httpMethod = "POST",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "selectUserList",method = {RequestMethod.POST})
    public Object selectUserList(@RequestBody SearchUserVO searchUserVO){
        this.load(searchUserVO.getPageNo(),searchUserVO.getPageSize());
        return sysUserService.selectUserList(searchUserVO,this.getPageNo(),this.getPageSize());
    }
}
