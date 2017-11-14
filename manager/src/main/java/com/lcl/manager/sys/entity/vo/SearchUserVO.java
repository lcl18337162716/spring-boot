package com.lcl.manager.sys.entity.vo;

import com.lcl.manager.core.entity.vo.BasePageVO;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title: 查询user列表实体类
 * @Package com.lcl.manager.sys.entity.vo
 * @Description: 查询user列表实体类
 * @date 2017/11/14
 */
@Getter
@Setter
@ApiModel(value="searchUserVO",description="用户列表查询VO")
public class SearchUserVO extends BasePageVO implements Serializable {
    private String name;//名字
    private String nickName;//昵称
    private String cel;//手机号
    /**
     * 状态（1：正常，0：冻结）
     */
    private Boolean status;

    @Override
    public String toString() {
        return "SearchUserVO{" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", cel='" + cel + '\'' +
                ", status=" + status +
                '}';
    }
}
