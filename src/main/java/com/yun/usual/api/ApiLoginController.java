package com.yun.usual.api;

import com.alibaba.fastjson.JSON;
import com.yun.usual.bean.Iv;
import com.yun.usual.bean.Result;
import com.yun.usual.bean.UserInfo;
import com.yun.usual.entity.User;
import com.yun.usual.repository.UserRepository;
import com.yun.usual.service.UserService;
import com.yun.usual.utils.HttpClientUtils;
import com.yun.usual.utils.ResultUtils;
import com.yun.usual.utils.WeChatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author yrz
 */
@RestController
@RequestMapping("/api")
public class ApiLoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    private Map<String, Object> result = new LinkedHashMap<>();

    @PostMapping(value = "/login")
    public Map index(@RequestBody Iv iv) throws IOException {

        String sessionKey =  WeChatUtil.getSessionKey(iv.getCode());
        String message = WeChatUtil.decryptData(iv.getEncryptedData() , sessionKey , iv.getIv());
        UserInfo userInfo = JSON.parseObject(message , UserInfo.class);
        User user = userRepository.findByOpenid(userInfo.getOpenId());

        if(null == user){
            user = userService.register(userInfo);
        }

        user.setToken(user.getId() + "&" + user.getOpenid());

        result.put("code",1);
        result.put("msg","登录成功");
        result.put("token",user.getToken());
        result.put("user",user);
        return result;
    }

}
