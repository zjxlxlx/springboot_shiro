package com.tofindwork.work.service;

import com.tofindwork.work.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> findRoleListByUserId(int userId);


    void addRoleByUserId(int userId);

    void delUserRole(int userId, List<String> roleList);

    void addUserRole(int userId, List<String> roleList);
}
