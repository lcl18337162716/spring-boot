package com.lcl.manager.sys.dao;


import com.lcl.manager.sys.entity.po.SysPermission;

import java.util.List;

public interface SysPermissionDAO {
    int deleteByPrimaryKey(String permissionId);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(String permissionId);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);

    /**
     * 根据用户id 初始化系统菜单
     * @param userId
     * @return
     */
    List<SysPermission> selectMenuByUserId(String userId);
}