package com.tofindwork.work.service.Impl;

import com.tofindwork.work.entity.User;
import com.tofindwork.work.mapper.UserMapper;
import com.tofindwork.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void editInfo(User user) {
        userMapper.editInfo(user);



    }

    @Override
    public void updatePwd(String password,String phone) {

        userMapper.updatePwd(password,phone);

    }


}
