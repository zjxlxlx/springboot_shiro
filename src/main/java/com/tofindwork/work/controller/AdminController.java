package com.tofindwork.work.controller;


import com.tofindwork.work.entity.Role;
import com.tofindwork.work.entity.User;
import com.tofindwork.work.entity.UserWrapper;
import com.tofindwork.work.service.AdminService;
import com.tofindwork.work.service.RoleService;
import com.tofindwork.work.service.UserService;
import com.tofindwork.work.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @Autowired
    private RoleService roleService;





    @RequestMapping("/findUser")
    public Result findUser(
            @RequestParam(defaultValue = "1",value = "page")Integer page,
            @RequestParam(defaultValue = "10",value = "size")Integer size,
             UserWrapper userWrapper
    ){
    List<User> users=adminService.findUser(userWrapper,page,size);
        for (User user:users) {
            user.setRoles(roleService.findRoleListByUserId(user.getUserId()));
        }
        return Result.success(users,"查询成功");

    }

/**
 * userId  roleName =>> 删除userId的roleName权限
 * */
    @RequestMapping("/delUserRole")
    public Result delUserRole(@RequestBody UserWrapper userWrapper){

        List<Role> roles = roleService.findRoleListByUserId(userWrapper.getUserId());

        for (Role r:roles) {
            if (r.getRoleName().equals("root")||r.getRoleName().equals("admin")){

                return Result.error("你没有权限删除该用户权限");
            }
        }

        List<String> roleList=new LinkedList<>();

       if (userWrapper.getRoles()==null||userWrapper.getRoles().size()==0){
           return null;
       }else {
           for (Role role:userWrapper.getRoles()) {
               roleList.add(role.getRoleName());
           }
       }

        roleService.delUserRole(userWrapper.getUserId(),roleList);

        return Result.success("权限修改成功");
    }


@RequestMapping("/addUserRole")
    public Result addUserRole(@RequestBody UserWrapper userWrapper){



        List<String> roleList=new LinkedList<>();

        for (Role role:userWrapper.getRoles()) {
           if (role.getRoleName().equals("root")||role.getRoleName().equals("admin")){
               return Result.error("你没有权限添加该权限");
           }
            roleList.add(role.getRoleName());
        }
        roleService.addUserRole(userWrapper.getUserId(),roleList);
        return Result.success("权限添加成功");

    }







}
