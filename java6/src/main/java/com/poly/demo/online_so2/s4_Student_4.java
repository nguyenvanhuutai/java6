package com.poly.demo.online_so2;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.demo.online_so2.bean.Student;

@Controller
public class s4_Student_4 {
    @RequestMapping("/student/list")
    public String operator(Model model,@RequestParam("index")Optional<Integer> index) throws Exception{
        File file = new ClassPathResource("/static/json/students.json").getFile();
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Student>> type = new TypeReference<>() {};
        List<Student> list = mapper.readValue(file,type);

        model.addAttribute("sv", list.get(index.orElse(0)));
        model.addAttribute("dssv", list);
        
        return "html_so2/ListStudent";
    }
}
