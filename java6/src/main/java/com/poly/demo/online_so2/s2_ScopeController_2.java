package com.poly.demo.online_so2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Reactive.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class s2_ScopeController_2 {

    @Autowired
    HttpServletRequest request;

    @Autowired 
    HttpSession session;

    @Autowired
    ServletContext servletContext;

    @RequestMapping("/scope")
    public String index(Model model){
        model.addAttribute("a", "I am in Model");
        request.setAttribute("b", "I am in Request Scope");
        session.setAttribute("c", "I am in Session Scope");
        servletContext.setAttribute("d", "I am in Application Scope");

        return "html_so2/scopeIndex";
    }
}
