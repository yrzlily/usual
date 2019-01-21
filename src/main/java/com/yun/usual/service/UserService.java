package com.yun.usual.service;

import com.yun.usual.bean.UserInfo;
import com.yun.usual.entity.User;

/**
 * @author yrz
 */
public interface UserService {

    /**
     * 登录注册
     * @param user
     * @return
     */
    User register(UserInfo user);

}
