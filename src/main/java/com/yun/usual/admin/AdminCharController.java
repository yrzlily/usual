package com.yun.usual.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yrz
 */
@Controller
@RequestMapping("/admin/char")
public class AdminCharController {

    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("/admin/char/index");
    }

}
