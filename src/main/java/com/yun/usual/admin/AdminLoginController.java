package com.yun.usual.admin;

import com.yun.usual.bean.Result;
import com.yun.usual.service.AdminUserService;
import com.yun.usual.utils.JumpUtils;
import com.yun.usual.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;

/**
 * @author yrz
 */
@Controller
@RequestMapping("/admin/login/**")
public class AdminLoginController {

    private final AdminUserService adminUserService;

    private static String adminUid = "admin_uid";
    private static String adminSid = "admin_sid";

    @Autowired
    public AdminLoginController(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    @GetMapping("/index")
    public String index() throws IOException {


        if(SessionUtils.getSessionAttribute(adminUid) != null && SessionUtils.getSessionAttribute(adminSid) != null){
            SessionUtils.getResponse().sendRedirect("/admin/index");
        }

        return "/admin/login/index";
    }

    @PostMapping("/index")
    public ModelAndView login(@RequestParam("admin_username")String adminUsername, @RequestParam("admin_password")String adminPassword){

        Result result = adminUserService.login(adminUsername,adminPassword);

        if(result.getCode() == 0){
            return JumpUtils.error("/admin/login/index",result.getMsg());
        }

        return JumpUtils.success("/admin/index","登录成功");
    }

    @GetMapping("/logout")
    public ModelAndView logout(){
        SessionUtils.removeSessionAttribute(adminUid);
        SessionUtils.removeSessionAttribute(adminSid);
        return JumpUtils.success("/admin/login/index","退出成功");
    }
}
