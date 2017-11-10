package com.lcl.manager.sys.service.imp;

import com.lcl.manager.sys.dao.SysPermissionDAO;
import com.lcl.manager.sys.entity.po.SysPermission;
import com.lcl.manager.sys.service.SysPermissionService;
import com.lcl.manager.util.BaseResult;
import com.lcl.manager.util.ConstantsCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title: 权限接口实现
 * @Package com.lcl.manager.sys.service.imp
 * @Description: 权限接口实现
 * @date 2017/11/9
 */
@Service(value = "sysPermissionService")
public class SysPermissionServiceImp implements SysPermissionService{
    @Autowired
    private SysPermissionDAO sysPermissionDAO;
    /**
     * 根据用户id初始化菜单
     *
     * @param userId
     * @return
     */
    @Override
    public BaseResult selectMenuByUserId(String userId) {
        List<SysPermission> list = sysPermissionDAO.selectMenuByUserId(userId);
        return new BaseResult(ConstantsCode.SYS_SUCCESS_CODE,ConstantsCode.SYS_SUCCESS_MSG,list);
    }
}
