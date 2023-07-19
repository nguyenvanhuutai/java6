package com.poly.demo.online_so3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class s2_HomeController {
    
    @GetMapping("/home/index")
    public String index(Model model){
        return "html_so3/home/index";
    }

    @GetMapping("/home/about")
    public String about(Model model){
        return "html_so3/home/about";
    }
}
