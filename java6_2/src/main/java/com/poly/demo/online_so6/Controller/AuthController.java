package com.poly.demo.online_so6.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AuthController {

    @RequestMapping("/auth/login/form")
    public String login() {
        return "html_so6/auth/login" ;
    }

    @RequestMapping("/auth/login/success")
    public String success(Model model){
        model.addAttribute("massage", "Đăng nhập thành công");
        return "html_so6/auth/login" ;
    }

    @RequestMapping("/auth/login/error")
    public String error(Model model){
        model.addAttribute("massage", "Sai thông tin đăng nhập");
        return "html_so6/auth/login" ;
    }

    @RequestMapping("/auth/logoff/success")
    public String errorSuccess(Model model){
        model.addAttribute("massage", "Đăng xuất thành công");
        return "forward:/auth/login/form" ;
    }

    @RequestMapping("/auth/access/denied")
    public String denied(Model model){
        model.addAttribute("massage", "Bạn không có quyền truy cập");
        return "html_so6/auth/login" ;
    }


    
    
}
