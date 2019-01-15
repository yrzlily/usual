package com.yun.usual.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yrz
 */
@RestController
@RequestMapping("/api/user")
public class ApiUserController {

    @GetMapping("/index")
    public String index(){
        return "/user/index";
    }

}
