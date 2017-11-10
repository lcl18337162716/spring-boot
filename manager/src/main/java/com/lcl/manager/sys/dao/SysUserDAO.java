package com.lcl.manager.sys.dao;


import com.lcl.manager.sys.entity.po.SysUser;

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
}