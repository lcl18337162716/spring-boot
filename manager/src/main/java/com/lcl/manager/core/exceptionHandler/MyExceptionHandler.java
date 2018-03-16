package com.lcl.manager.core.exceptionHandler;

import com.lcl.manager.util.BaseResult;
import com.lcl.manager.util.ConstantsCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuchaolong
 * @version V1.0
 * @Package com.ytkj.ivis.base.exceptionHandler
 * @Description: 异常同一处理类
 * @date 2017/11/22
 */
@ControllerAdvice
public class MyExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = MyException.class)
    public BaseResult returnException(MyException e) {
        return new BaseResult(ConstantsCode.OPERATION_ERROR_CODE, e.getErrorMsg(), e
                .getStackTrace());
    }
}
