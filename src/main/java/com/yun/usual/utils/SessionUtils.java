package com.yun.usual.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author yrz
 */
public class SessionUtils {

    /**
     * 获取请求request
     * @return
     */
    private static HttpServletRequest getRequest(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes==null? null : requestAttributes.getRequest();
    }

    private static ServletRequestAttributes getRequestAttributes() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
    }

    public static HttpServletResponse getResponse() {
        return getRequestAttributes().getResponse();
    }

    /**
     * 设置session
     * @param key
     * @param value
     */
    public static void setSessionAttribute(String key , Object value){
        HttpServletRequest request = getRequest();
        if(request!=null){
            request.getSession().setAttribute(key, value);
        }
    }

    /**
     * 获取session
     * @return
     */
    public static HttpSession getSession(){
        return Objects.requireNonNull(getRequest()).getSession(false);
    }

    /**
     * 获取session中的Attribute
     * @param name
     * @return
     */
    public static Object getSessionAttribute(String name){
        HttpServletRequest request = getRequest();
        return request == null?null:request.getSession().getAttribute(name);
    }

    public static void removeSessionAttribute(String name) {
        getRequest().getSession().removeAttribute(name);
    }
}
