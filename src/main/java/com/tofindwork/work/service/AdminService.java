package com.tofindwork.work.service;

import com.tofindwork.work.entity.User;
import com.tofindwork.work.entity.UserWrapper;

import java.util.List;

public interface AdminService {
    List<User> findUser(UserWrapper userWrapper, int page, int size);
}
