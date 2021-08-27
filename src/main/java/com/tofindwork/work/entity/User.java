package com.tofindwork.work.entity;

import lombok.*;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {

    private int userId;

    private String username;

    private String password;

    private String age;

    private String phone;

    private String describe;

    private List<Role> roles;

    private String createTime;

    private String updateTime;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                ", phone='" + phone + '\'' +
                ", describe='" + describe + '\'' +
                ", roles=" + roles +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
