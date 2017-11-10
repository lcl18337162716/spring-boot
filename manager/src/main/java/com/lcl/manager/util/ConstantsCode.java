package com.lcl.manager.util;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title: 返回结果code
 * @Package com.lcl.manager.util
 * @Description:
 * @date 2017/11/8
 */
public class ConstantsCode {
    /**
     * 系统错误code
     */
    public static final Integer SYS_ERROR_CODE = 50000;
    /**
     * 系统错误msg
     */
    public static final String SYS_ERROR_MSG = "系统错误，联系客服";
    /**
     * 系统操作成功code
     */
    public static final Integer SYS_SUCCESS_CODE = 10000;
    /**
     * 系统操作成功msg
     */
    public static final String SYS_SUCCESS_MSG = "操作成功";
    /**
     * 系统操作失败code
     */
    public static final Integer OPERATION_ERROR_CODE = 20000;
    /**
     * 数据校验失败msg
     */
    public static final Integer VALIDATION_ERROR_CODE = 20001;
    /**
     * 数据校验失败msg
     */
    public static final String VALIDATION_ERROR_MSG = "数据参数不合法";
    /**
     * 数据添加失败msg
     */
    public static final String OPERATION_ADD_ERROR_MSG = "添加失败";
    /**
     * 数据更新失败msg
     */
    public static final String OPERATION_UPDATE_ERROR_MSG = "更新失败";
    /**
     * 数据删除失败msg
     */
    public static final String OPERATION_DELETE_ERROR_MSG = "删除失败";
    /**
     * 数据查询失败msg
     */
    public static final String OPERATION_SELECT_ERROR_MSG = "查询失败";
}
