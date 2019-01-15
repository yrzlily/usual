package com.yun.usual.utils;

import com.yun.usual.bean.Result;
import com.yun.usual.enums.ResultEnum;

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

}
