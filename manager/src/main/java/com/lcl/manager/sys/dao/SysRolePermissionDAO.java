package com.lcl.manager.sys.dao;


import com.lcl.manager.sys.entity.po.SysRolePermission;

public interface SysRolePermissionDAO {
    int deleteByPrimaryKey(String id);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    SysRolePermission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);
}