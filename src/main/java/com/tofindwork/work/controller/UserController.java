package com.tofindwork.work.controller;


import com.tofindwork.work.entity.User;
import com.tofindwork.work.service.PubService;
import com.tofindwork.work.service.RoleService;
import com.tofindwork.work.service.UserService;
import com.tofindwork.work.utils.Result;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private PubService pubService;

    @Autowired
    private RoleService roleService;


    @RequestMapping("/findMyInfo")
    public Result findMyInfo(){
        String phone= (String) SecurityUtils.getSubject().getPrincipal();
        User user=pubService.findUserByPhone(phone);
        user.setRoles(roleService.findRoleListByUserId(user.getUserId()));
        return Result.success(user,"查询成功");

    }


    @RequestMapping("/editInfo")
    public Result editInfo(User user){
       userService.editInfo(user);

        return Result.success("修改成功");
    }

    @RequestMapping("/updatePwd")
    public Result updatePwd(String password){
        String phone= (String) SecurityUtils.getSubject().getPrincipal();

        userService.updatePwd(password,phone);

        return Result.success("密码修改成功");
    }




}
