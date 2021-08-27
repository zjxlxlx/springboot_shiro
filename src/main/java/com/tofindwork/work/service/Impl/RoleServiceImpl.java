package com.tofindwork.work.service.Impl;

import com.tofindwork.work.entity.Role;
import com.tofindwork.work.mapper.RoleMapper;
import com.tofindwork.work.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;




    @Override
    public List<Role> findRoleListByUserId(int userId) {
        return roleMapper.findRoleListByUserId(userId);
    }

    /**
     * 添加用户权限
     * */
    @Override
    public void addRoleByUserId(int userId) {
        roleMapper.addRoleByUserId(userId);
    }

    @Override
    public void delUserRole(int userId, List<String> roleList) {
        roleMapper.delUserRole(userId,roleList);
    }

    @Override
    public void addUserRole(int userId, List<String> roleList) {
        roleMapper.addUserRoleBatch(userId,roleList);
    }
}
