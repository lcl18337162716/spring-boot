package com.lcl.manager.util;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title: 统一返回结果实体
 * @Package com.lcl.manager.util
 * @Description: 统一返回结果实体
 * @date 2017/11/8
 */
@Getter
@Setter
public class BaseResult implements Serializable{
    /**
     * 返回结果
     */
   private Integer code;
    /**
     * 返回信息
     */
   private String msg;
    /**
     * 返回数据
     */
   private Object data;

    public BaseResult(Integer code) {
        this.code = code;
    }

    public BaseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
