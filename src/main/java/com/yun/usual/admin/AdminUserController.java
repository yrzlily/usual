package com.yun.usual.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yrz
 */
@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

}
