package com.tofindwork.work.entity;


import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private int roleId;

    private String roleName;

    private String marks;

    private List<Permission> permissions;

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", marks='" + marks + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
