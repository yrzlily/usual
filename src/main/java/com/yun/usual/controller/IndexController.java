package com.yun.usual.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yrz
 */
@RestController
@RequestMapping(value = {"/index",""})
public class IndexController {

    @GetMapping(value = {"/index",""})
    public String index(){
        return "/admin/login/index";
    }

}
