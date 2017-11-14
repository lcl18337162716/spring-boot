package com.lcl.manager.core.entity.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title: 基础分页VO
 * @Package com.lcl.manager.core.entity.vo
 * @Description: 基础分页VO
 * @date 2017/11/14
 */
@Setter
@Getter
public class BasePageVO implements Serializable {
    private String pageNo;//当前页
    private String pageSize;//每页显示条数
    private String pageTotal;//总条数

    @Override
    public String toString() {
        return "BasePageVO{" +
                "pageNo='" + pageNo + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", pageTotal='" + pageTotal + '\'' +
                '}';
    }
}
