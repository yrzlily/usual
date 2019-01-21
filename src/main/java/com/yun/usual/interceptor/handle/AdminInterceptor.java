package com.yun.usual.interceptor.handle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author yrz
 */
@Configuration
@Slf4j
public class AdminInterceptor implements HandlerInterceptor {

    private static final String ADMIN_UID = "admin_uid";
    private static final String ADMIN_SID = "admin_sid";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("start admin authentication");

        HttpSession session = request.getSession();
//        if(session.getAttribute(ADMIN_UID) == null && session.getAttribute(ADMIN_SID) == null){
//            response.sendRedirect("/admin/login/index");
//        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
