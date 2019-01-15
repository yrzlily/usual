package com.yun.usual.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yrz
 */
@RestController
@RequestMapping(value = {"/api/index","/api"})
public class ApiIndexController {

    @GetMapping(value = {"/index",""})
    public String index(){
        return "api/index";
    }

}
