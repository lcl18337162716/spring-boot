package com.lcl.manager.sys.dao;


import com.lcl.manager.sys.entity.po.SysUserRole;

public interface SysUserRoleDAO {
    int deleteByPrimaryKey(String id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
}