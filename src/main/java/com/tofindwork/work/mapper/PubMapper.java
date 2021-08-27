package com.tofindwork.work.mapper;

import com.tofindwork.work.entity.User;

public interface PubMapper {
    User findUserByPhone(String phone);

    void addUser(String phone, String password);
}
