package com.lcl.manager.sys.entity.po;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class SysRolePermission implements Serializable {
    private String id;

    private String roleId;

    private String permissionId;

    @Override
    public String toString() {
        return "SysRolePermission{" +
                "id='" + id + '\'' +
                ", roleId='" + roleId + '\'' +
                ", permissionId='" + permissionId + '\'' +
                '}';
    }
}