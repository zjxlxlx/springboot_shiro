package com.tofindwork.work.controller;


import com.tofindwork.work.entity.User;
import com.tofindwork.work.entity.UserWrapper;
import com.tofindwork.work.service.PubService;
import com.tofindwork.work.service.RoleService;
import com.tofindwork.work.utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/pub")
public class PubController {

    @Autowired
    private PubService pubService;

    @Autowired
    private RoleService roleService;

//    @RequestMapping("/test")
//public void test(String phone,String password){
//        User user= pubService.findUserByPhone(phone);
//        user.setRoles(roleService.findRoleListByUserId(1));
//        System.out.println(user.toString());
//
//    }


    @RequestMapping("/login")
    public Result login(@RequestBody UserWrapper userWrapper){
        Result result=null;

        UsernamePasswordToken token=new UsernamePasswordToken(userWrapper.getPhone(),userWrapper.getPassword());
        Subject subject= SecurityUtils.getSubject();
        try{
            subject.login(token);

            result=Result.success( subject.getSession().getId(),"登录成功");

        }catch (Exception e){
            result=Result.error("用户名密码错误");
        }

return result;
    }

    @RequestMapping("/register")
    public Result register(String phone, String password){

        Result result=null;

       User user= pubService.findUserByPhone(phone);


       if (user==null){

        pubService.register(phone,password);

           result=Result.success("注册成功");

       }else{
           result=Result.error("用户已注册");
       }

       return result;





    }

}
