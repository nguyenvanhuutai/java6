package com.poly.demo.online_so3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.demo.online_so3.bean.Student;


@Controller
public class s1_StudentController {
    
    @GetMapping("/student/form")
    public String form(Model model) {
        Student student = new Student();
        student.setGender(true);
        model.addAttribute("sv", student);

        return "html_so3/student/form";
    }

    @PostMapping("/student/save")
    public String save(Model model,@ModelAttribute("sv")Student student) {
        
        return "html_so3/student/success";
    }
    
}
