package com.lcl.manager.sys.service;

import com.lcl.manager.util.BaseResult;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title: 权限接口
 * @Package com.lcl.manager.sys.service
 * @Description: 权限接口
 * @date 2017/11/9
 */
public interface SysPermissionService {
    /**
     *根据用户id初始化菜单
     * @param userId
     * @return
     */
    BaseResult selectMenuByUserId(String userId);
}
