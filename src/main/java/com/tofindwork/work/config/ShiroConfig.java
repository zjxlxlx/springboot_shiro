package com.tofindwork.work.config;



import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {


    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){

        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();

        Map<String,String>  filtercChianMap=new LinkedHashMap<>();

        filtercChianMap.put("/**","anon");
//暂时关闭权限过滤器  由于前后端分离  shiro重定向产生跨域
//        filtercChianMap.put("/pub/**","anon");
//        filtercChianMap.put("/user/**","authc");
//        filtercChianMap.put("/admin/**","roles[admin]");
//        filtercChianMap.put("/admin/findUserList","perms[user_list]");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filtercChianMap);

        shiroFilterFactoryBean.setLoginUrl("/page/login.html");
        shiroFilterFactoryBean.setSuccessUrl("/page/welcome.html");
        shiroFilterFactoryBean.setUnauthorizedUrl("/page/nopermission.html");


        shiroFilterFactoryBean.setSecurityManager(securityManager());

        return shiroFilterFactoryBean;

    }

    @Bean
    public SecurityManager securityManager(){

        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();

        defaultWebSecurityManager.setRealm(customRealm());

        defaultWebSecurityManager.setSessionManager(sessionManager());

        return defaultWebSecurityManager;

    }

    @Bean
    public SessionManager sessionManager(){
        SessionManager sessionManager=new CustomSessionManager();


        return sessionManager;
    }

    @Bean
    public CustomRealm customRealm(){
        CustomRealm customRealm=new CustomRealm();

//        customRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return customRealm;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher=new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashIterations(2);
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        return  hashedCredentialsMatcher;
    }





}
