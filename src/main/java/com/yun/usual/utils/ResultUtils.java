package com.yun.usual.utils;

import com.yun.usual.bean.Layer;
import com.yun.usual.bean.Result;
import com.yun.usual.enums.ResultEnum;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yrz
 */
public class ResultUtils {

    public static Result success(String msg, Object data){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    public static Result error(String msg){
        Result result = new Result();
        result.setCode(ResultEnum.ERROR.getCode());
        result.setMsg(msg);
        return result;
    }

    public static Layer layer(Integer count , Object data){
        Layer layer = new Layer();
        layer.setCode(ResultEnum.LAYER_GET_DATA.getCode());
        layer.setMsg(ResultEnum.LAYER_GET_DATA.getMsg());
        layer.setCount(count);
        layer.setData(data);
        return layer;
    }

    public static Map<String, Object> result(String msg){
        Map<String, Object> result = new LinkedHashMap<>();

        result.put("code" , 1);
        result.put("msg" , msg);
        return result;
    }
}
