package com.lcl.manager.sys.dao;


import com.lcl.manager.sys.entity.po.SysRole;

public interface SysRoleDAO {
    int deleteByPrimaryKey(String roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}