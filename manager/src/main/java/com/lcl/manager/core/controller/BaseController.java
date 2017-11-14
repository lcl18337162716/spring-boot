package com.lcl.manager.core.controller;

import com.lcl.manager.util.BaseResult;
import com.lcl.manager.util.ConstantsCode;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title: baseController
 * @Package com.lcl.manager.core.controller
 * @Description: 基础控制类
 * @date 2017/11/8
 */
@Getter
@Setter
public class BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
    private Integer pageNo;
    private Integer pageSize;
    /**
     * @return BaseResult 返回类型
     * @throws
     * @Title: doValidated
     * @Description:获取提交表单校验信息错误信息map提示
     */
    protected BaseResult getValidatedInfo(BindingResult result) {
        Map<String, Object> errorMap = new HashMap<String, Object>();
        if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors) {
                if (!errorMap.containsKey(fieldError.getField())) {
                    errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
            }
            Map<String, Object> errorMsg = new HashMap<String, Object>();
            errorMsg.put("errorMsg",errorMap);
            return new BaseResult(ConstantsCode.VALIDATION_ERROR_CODE,
                    ConstantsCode.VALIDATION_ERROR_MSG,
                    errorMsg);
        }
        return new BaseResult(ConstantsCode.SYS_SUCCESS_CODE);
    }

    protected void load(String pageNo,String size) {
        this.pageNo = 0;
        this.pageSize = 0;
        try {
            this.pageNo = Integer.parseInt(pageNo);
            this.pageSize = Integer.parseInt(size);
        } catch (Exception ex) {
            this.pageNo = 0;
            this.pageSize = 10;
        }
    }
}
