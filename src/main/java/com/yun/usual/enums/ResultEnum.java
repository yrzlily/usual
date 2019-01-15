package com.yun.usual.enums;

/**
 * @author yrz
 */
public enum  ResultEnum {
    /**
     * 请求成功
     */
    SUCCESS(1,"成功"),
    ERROR(0, "失败");



    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
