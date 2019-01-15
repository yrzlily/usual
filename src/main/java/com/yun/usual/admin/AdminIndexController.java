package com.yun.usual.admin;

import com.yun.usual.repository.AdminNavRepository;
import com.yun.usual.service.AdminNavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yrz
 */
@Controller
@RequestMapping(value = {"/admin/index","/admin"})
public class AdminIndexController {

    @Autowired
    private AdminNavRepository navRepository;

    @Autowired
    private AdminNavService navService;

    @GetMapping(value = {"/index",""})
    public ModelAndView index(ModelAndView view){
        view.addObject("nav",navService.findChild(0,navRepository.findAllList()));

        view.setViewName("/admin/index");
        return view;
    }

}
