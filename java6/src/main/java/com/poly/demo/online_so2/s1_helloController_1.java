package com.poly.demo.online_so2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class s1_helloController_1 {
    @RequestMapping("/hello")
    public String hellp(Model model){
        model.addAttribute("message","FPT <b>Polytechnic</b>");
        return "html_so2/hello";
    }
}
