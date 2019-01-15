package com.yun.usual.service.impl;

import com.yun.usual.bean.Result;
import com.yun.usual.entity.AdminUser;
import com.yun.usual.repository.AdminUserRepository;
import com.yun.usual.service.AdminUserService;
import com.yun.usual.utils.ResultUtils;
import com.yun.usual.utils.SessionUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @author yrz
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserRepository adminUserRepository;

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public Result login(String username, String password) {

        AdminUser adminUser = adminUserRepository.findByAdminUsername(username);

        if(!BCrypt.checkpw(password, adminUser.getAdminPassword())){
            return ResultUtils.error("密码错误");
        }

        String adminSid = adminUser.getAdminUsername() + adminUser.getAdminPassword();
        SessionUtils.setSessionAttribute("admin_uid" , adminUser.getId());
        SessionUtils.setSessionAttribute("admin_sid" , DigestUtils.md5DigestAsHex(adminSid.getBytes()));

        return ResultUtils.success("登录成功",adminUser);
    }
}
