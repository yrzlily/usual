package com.yun.usual.dto;

import com.yun.usual.entity.User;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yrz
 */
@Data
public class UserInfo implements Serializable  {

    private Integer id;

    private String username;

    private String avatar;


}
