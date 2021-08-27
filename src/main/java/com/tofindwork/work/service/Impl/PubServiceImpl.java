package com.tofindwork.work.service.Impl;

import com.tofindwork.work.entity.User;
import com.tofindwork.work.mapper.PubMapper;
import com.tofindwork.work.mapper.RoleMapper;
import com.tofindwork.work.service.PubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;

@Transactional
@Service
public class PubServiceImpl implements PubService {


    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private PubMapper pubMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User findUserByPhone(String phone) {

        User user=null;

        //取消与redis连接
//
//      try{
//          user= (User) redisTemplate.opsForValue().get(phone);
//
//          if (user!=null){
//              redisTemplate.expire(phone, Duration.ofMinutes(5L));
//              return user;
//          }else {

              user= pubMapper.findUserByPhone(phone);
//              redisTemplate.opsForValue().set(phone,user);
//              redisTemplate.expire(phone, Duration.ofMinutes(5L));
//          }
//
//      }catch (Exception e){
//          e.printStackTrace();
//      }



        return user;
    }

    @Override
    public void register(String phone, String password) {




         pubMapper.addUser(phone, password);

         User user=pubMapper.findUserByPhone(phone);

         roleMapper.addRoleByUserId(user.getUserId());



    }
}
