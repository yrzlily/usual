package com.yun.usual.service.impl;

import com.yun.usual.bean.UserInfo;
import com.yun.usual.entity.User;
import com.yun.usual.repository.UserRepository;
import com.yun.usual.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yrz
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(UserInfo userInfo) {

        User user = new User();

        user.setOpenid(userInfo.getOpenId());
        user.setAvatar(userInfo.getAvatarUrl());
        user.setNickname(userInfo.getNickName());
        user.setGender(userInfo.getGender());
        user.setCity(userInfo.getCity());
        userRepository.save(user);
        return user;
    }
}
