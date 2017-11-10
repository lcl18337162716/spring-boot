package com.lcl.manager.sys.controller;

import com.lcl.manager.core.controller.BaseController;
import com.lcl.manager.sys.entity.po.SysPermission;
import com.lcl.manager.sys.service.SysPermissionService;
import com.lcl.manager.util.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title: 首页
 * @Package com.lcl.manager.sys.controller
 * @Description: 首页接口controller
 * @date 2017/11/9
 */
@Api(value = "系统首页", tags = {"系统首页"})
@RestController
@RequestMapping(value = "index")
public class IndexController extends BaseController{
    @Autowired
    private SysPermissionService sysPermissionService;

    @ApiOperation(value="初始化菜单操作",
            notes="初始化菜单操作",
            httpMethod = "POST",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "initMenu",method = {RequestMethod.POST})
    public Object initMenu(@RequestBody Map oMap){
        return sysPermissionService.selectMenuByUserId(oMap.get("userId").toString());
    }
}
