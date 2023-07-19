package com.poly.demo.online_so2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class s3_OperatorController_3 {
    @RequestMapping("/operator")
    public String operator(Model model){
        model.addAttribute("x",5);
        model.addAttribute("y",7);
        return "html_so2/operator";
    }
}
