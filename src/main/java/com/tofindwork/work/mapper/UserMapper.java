package com.tofindwork.work.mapper;


import com.tofindwork.work.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {


    void editInfo(@Param("user") User user);

    void updatePwd(String password, String phone);
}
