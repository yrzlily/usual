package com.yun.usual.api;

import com.yun.usual.bean.Result;
import com.yun.usual.repository.PostsRepository;
import com.yun.usual.utils.ResultUtils;
import com.yun.usual.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yrz
 */
@RestController
@RequestMapping("/api/user")
public class ApiUserController {

    @Autowired
    private PostsRepository postsRepository;

    @GetMapping("/index")
    public String index(){
        return "/user/index";
    }

    @GetMapping("/delete_data")
    public Result delete(){

        postsRepository.deleteStatus(SessionUtils.getUserId());
        return ResultUtils.success("delete successful", SessionUtils.getUserId());
    }
}
