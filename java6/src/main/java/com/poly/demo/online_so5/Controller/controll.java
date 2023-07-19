package com.poly.demo.online_so5.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controll {
    @GetMapping("/hiengiaodien")
    public String a(){
        return "html_so5/index";
    }
}
