package com.lcl.manager.sys.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcl.manager.core.encrypt.EncryptUtil;
import com.lcl.manager.core.exceptionHandler.MyException;
import com.lcl.manager.sys.dao.SysUserDAO;
import com.lcl.manager.sys.entity.po.SysUser;
import com.lcl.manager.sys.entity.vo.AddUserVO;
import com.lcl.manager.sys.entity.vo.SearchUserVO;
import com.lcl.manager.sys.service.SysUserService;
import com.lcl.manager.util.BaseResult;
import com.lcl.manager.util.ConstantsCode;
import com.lcl.manager.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title: 用户service实现
 * @Package com.lcl.manager.sys.service.imp
 * @Description: 用户service实现
 * @date 2017/11/14
 */
@Service("sysUserService")
public class SysUserServiceImp implements SysUserService{
    @Autowired
    private SysUserDAO sysUserDAO;
    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImp.class);

    /**
     * 条件查询用户列表
     *
     * @param searchUserVO
     * @param pageNo
     *@param pageSize @return
     */
    @Override
    public BaseResult selectUserList(SearchUserVO searchUserVO, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<SysUser> list = sysUserDAO.selectUserList(searchUserVO);
        PageInfo pageInfo = new PageInfo(list);
        return new BaseResult(ConstantsCode.SYS_SUCCESS_CODE,ConstantsCode.SYS_SUCCESS_MSG,pageInfo);
    }

    /**
     * 根据id删除用户
     *
     * @param userId
     * @return
     */
    @Override
    public BaseResult deleteUserById(String userId) {
        try {
            sysUserDAO.deleteByPrimaryKey(userId);
            return new BaseResult(ConstantsCode.SYS_SUCCESS_CODE,ConstantsCode.SYS_SUCCESS_MSG);
        }catch (Exception e){
            return new BaseResult(ConstantsCode.OPERATION_ERROR_CODE,ConstantsCode.OPERATION_DELETE_ERROR_MSG,e.getMessage());
        }
    }

    /**
     * 添加用户
     *
     * @param sysUser
     * @return
     */
    @Override
    public BaseResult addUser(SysUser sysUser) throws MyException {
        SysUser sysUser1 = sysUserDAO.selectSysUserByUserLoginId(sysUser.getLoginId());
        if(sysUser1 != null){
            return new BaseResult(ConstantsCode.OPERATION_ERROR_CODE,"用户名已经存在");
        }
        sysUser.setPwd(EncryptUtil.sha(sysUser.getPwd()));
        sysUser.setUserId(UUIDUtil.getUUID());
        try{
            sysUserDAO.insert(sysUser);
            return new BaseResult(ConstantsCode.SYS_SUCCESS_CODE,ConstantsCode.SYS_SUCCESS_MSG);
        }catch (Exception e){
            logger.error("add user error",e);
            throw new MyException(ConstantsCode.OPERATION_ADD_ERROR_MSG);
        }
    }
}
