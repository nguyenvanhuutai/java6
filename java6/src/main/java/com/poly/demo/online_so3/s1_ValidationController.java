package com.poly.demo.online_so3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.demo.online_so3.bean.Student;
import com.poly.demo.online_so3.bean.Student2;

@Controller
public class s1_ValidationController {
    @GetMapping("/validation/form")
    public String form(Model model) {
        Student2 student = new Student2();
        model.addAttribute("sv", student);

        return "html_so3/student/form";
    }
    @PostMapping("/validation/validate")
    public String save(Model model,@Validated @ModelAttribute("sv")Student2 student,Errors errors) {
        if(errors.hasErrors()){
           return "html_so3/student/form";
        }
        return "html_so3/student/success";
    }


}
