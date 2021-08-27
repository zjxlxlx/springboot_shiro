package com.tofindwork.work.service.Impl;

import com.tofindwork.work.entity.User;
import com.tofindwork.work.entity.UserWrapper;
import com.tofindwork.work.mapper.AdminMapper;
import com.tofindwork.work.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public List<User> findUser(UserWrapper userWrapper, int page, int size) {


        return  adminMapper.findUser(userWrapper);
    }
}
