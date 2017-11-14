package com.lcl.manager.sys.service;

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
}
