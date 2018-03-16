package com.lcl.manager.sys.service;

import com.lcl.manager.core.exceptionHandler.MyException;
import com.lcl.manager.sys.entity.po.SysUser;
import com.lcl.manager.sys.entity.vo.AddUserVO;
import com.lcl.manager.sys.entity.vo.SearchUserVO;
import com.lcl.manager.util.BaseResult;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title: 用户service
 * @Package com.lcl.manager.sys.service
 * @Description: 用户service
 * @date 2017/11/14
 */
public interface SysUserService {
    /**
     * 条件查询用户列表
     * @param searchUserVO
     * @param pageNo
     *@param pageSize @return
     */
    BaseResult selectUserList(SearchUserVO searchUserVO, Integer pageNo, Integer pageSize);

    /**
     * 根据id删除用户
     * @param userId
     * @return
     */
    BaseResult deleteUserById(String userId);

    /**
     * 添加用户
     * @param sysUser
     * @return
     */
    BaseResult addUser(SysUser sysUser) throws MyException;
}
