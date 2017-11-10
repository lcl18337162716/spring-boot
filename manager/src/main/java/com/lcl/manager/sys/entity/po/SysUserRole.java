package com.lcl.manager.sys.entity.po;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SysUserRole implements Serializable {
    private String id;

    private String roleId;

    private String userId;

    @Override
    public String toString() {
        return "SysUserRole{" +
                "id='" + id + '\'' +
                ", roleId='" + roleId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}