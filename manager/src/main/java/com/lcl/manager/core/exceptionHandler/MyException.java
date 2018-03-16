package com.lcl.manager.core.exceptionHandler;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title:
 * @Package com.metchange.zcg.base.exceptionHandler
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2017/11/22
 */
public class MyException extends Exception {

    private String errorMsg;

    public MyException() {
    }

    public MyException(String errorMsg) {
        this.errorMsg = errorMsg;
    }


    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
