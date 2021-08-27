package com.tofindwork.work.mapper;

import com.tofindwork.work.entity.User;
import com.tofindwork.work.entity.UserWrapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    List<User> findUser(@Param("userWrapper") UserWrapper userWrapper);
}
