package com.lcl.manager.sys.dao;


import com.lcl.manager.sys.entity.po.SysUser;
import com.lcl.manager.sys.entity.vo.SearchUserVO;

import java.util.List;

public interface SysUserDAO {
    int deleteByPrimaryKey(String userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    /**
     * 根据登录账号查询用户信息
     * @param loginId
     * @return
     */
    SysUser selectSysUserByUserLoginId(String loginId);

    /**
     * 条件查询用户列表
     * @param searchUserVO
     * @return
     */
    List<SysUser> selectUserList(SearchUserVO searchUserVO);
}