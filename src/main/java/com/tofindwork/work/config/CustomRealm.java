package com.tofindwork.work.config;

import com.tofindwork.work.entity.Permission;
import com.tofindwork.work.entity.Role;
import com.tofindwork.work.entity.User;
import com.tofindwork.work.service.PubService;
import com.tofindwork.work.service.RoleService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private PubService pubService;

    @Autowired
    private RoleService roleService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String phone = (String) principals.getPrimaryPrincipal();
      User user=pubService.findUserByPhone(phone);
      user.setRoles(roleService.findRoleListByUserId(user.getUserId()));

        List<Role> userRoles= user.getRoles();

        List<String> roleList=new ArrayList<>();

        List<String> permissionList=new ArrayList<>();

        for (Role r:userRoles) {
            roleList.add(r.getRoleName());

            for (Permission p:r.getPermissions()) {
                permissionList.add(p.getName());
            }

        }

        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roleList);
        simpleAuthorizationInfo.addStringPermissions(permissionList);

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String phone= (String) token.getPrincipal();
//        Object token1=token.getPrincipal();
        String password= new String((char[])token.getCredentials()) ;

        User user = pubService.findUserByPhone(phone);

      if (user!=null){
          if (password.equals(user.getPassword())){

              return new SimpleAuthenticationInfo(phone, password,this.getClass().getName());
          }
      }
        return null;
    }
}
