package com.tofindwork.work.service;

import com.tofindwork.work.entity.User;

public interface UserService {
    void editInfo(User user);

    void updatePwd(String password,String phone);
}
