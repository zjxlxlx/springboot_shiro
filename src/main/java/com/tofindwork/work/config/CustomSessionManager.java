package com.tofindwork.work.config;

import org.apache.shiro.session.mgt.SessionManager;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;


public class CustomSessionManager extends DefaultWebSessionManager {

    private static final String AUTHORIZATION="token";

    public CustomSessionManager(){
        super();
    }

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {


        String sessionId= WebUtils.toHttp(request).getHeader(AUTHORIZATION);


        if (sessionId!=null){

            //校验sessionId

            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,
                    ShiroHttpServletRequest.COOKIE_SESSION_ID_SOURCE);

            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,sessionId);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID,Boolean.TRUE);

            return sessionId;
        }else{

            return super.getSessionId(request,response);
        }


    }


}
