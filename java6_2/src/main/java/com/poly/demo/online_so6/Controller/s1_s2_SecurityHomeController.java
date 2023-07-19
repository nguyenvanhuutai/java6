package com.poly.demo.online_so6.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class s1_s2_SecurityHomeController {
    

        @RequestMapping("/home/index")
        public String index(Model model){
            model.addAttribute("message","This is home page");
            return "html_so6/security/index";
        }

        @RequestMapping("/home/about")
        public String about(Model model){
            model.addAttribute("message","This is introduction page");
            return "html_so6/security/index";
        }


        @RequestMapping("/home/admins")
        public String admins(Model model){
            model.addAttribute("message", "Xin chào admins");
            return "html_so6/security/index";
        }

        @RequestMapping("/home/users")
        public String users(Model model){
            model.addAttribute("message", "Xin chào Staff");
            return "html_so6/security/index";
        }

        @RequestMapping("/home/authenticated")
        public String authenticated(Model model){
            model.addAttribute("message", "Xin chào Authenticated");
            return "html_so6/security/index";
        }


        // demo s2
        // @PreAuthorize("hasRole('ADMIN')")
        // @RequestMapping("/home/admins")
        // public String admins(Model model){
        //     model.addAttribute("message", "Xin chào admins");
        //     return "html_so6/security/index";
        // }
       
        // @PreAuthorize("hasAnyRole('ADMIN','USER')")
        // @RequestMapping("/home/users")
        // public String users(Model model){
        //     model.addAttribute("message", "Xin chào Staff");
        //     return "html_so6/security/index";
        // }
        
        // @PreAuthorize("isAuthenticated()")
        // @RequestMapping("/home/authenticated")
        // public String authenticated(Model model){
        //     model.addAttribute("message", "Xin chào Authenticated");
        //     return "html_so6/security/index";
        // }






        

}
