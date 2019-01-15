package com.yun.usual.utils;

import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yrz
 */
public class JumpUtils {

    public static ModelAndView success(String url , String msg){

        Map<String, String> map = new HashMap<>();
        map.put("url",url);
        map.put("msg",msg);

        return new ModelAndView("/admin/common/success",map);
    }

    public static ModelAndView error(String url , String msg){

        Map<String, String> map = new HashMap<>();
        map.put("url",url);
        map.put("msg",msg);

        return new ModelAndView("/admin/common/error",map);
    }

}
