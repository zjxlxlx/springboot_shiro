package com.tofindwork.work.service;

import com.tofindwork.work.entity.User;

public interface PubService {
    User findUserByPhone(String phone);

    void register(String phone, String password);
}
