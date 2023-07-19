package com.poly.demo.online_so2;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.demo.online_so2.bean.Student;


@Controller
public class s1_homeController_1 {
     @RequestMapping("/home/menu")
    public String home(Model model) throws Exception{
        model.addAttribute("message","Welcome to Thymeleaf");
        String jsonPath = "E:\\Ky6\\block2\\java6\\src\\main\\resources\\static\\json\\student.json";
        ObjectMapper mapper  = new ObjectMapper();
        Student student  = mapper.readValue(new File( jsonPath), Student.class);
        model.addAttribute("sv", student);
        return "html_so2/index";
    }
}
