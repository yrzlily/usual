package com.yun.usual.service;

import com.yun.usual.bean.Result;
import com.yun.usual.entity.AdminUser;
import org.springframework.stereotype.Service;

/**
 * @author yrz
 */
public interface AdminUserService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    Result login(String username, String password);

}
