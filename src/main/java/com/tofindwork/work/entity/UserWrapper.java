package com.tofindwork.work.entity;


import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserWrapper {  //User接收类

    private int userId;

    private String username;

    private String password;

    private String phone;

    private String start_age;

    private String end_age;

    private String timeChoose;    //create :1  |update :2

    private String start_time;

    private String end_time;

    private List<Role> roles;


}
