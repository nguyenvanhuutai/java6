package com.poly.demo.online_so2;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.demo.online_so2.bean.Student;

@Controller
public class s2_StudentController_2 {

    @RequestMapping("/student")
    public String home(Model model,@RequestParam("index")Optional<Integer> index) throws Exception{
        ObjectMapper mapper  = new ObjectMapper();
        File path = ResourceUtils.getFile("classpath:static\\json\\students.json");
        TypeReference<List<Student>> teperef = new TypeReference<>() {};
        List<Student> students = mapper.readValue(path,teperef);
        int i = index.orElse(0);
        model.addAttribute("n",i);
        model.addAttribute("sv",students.get(i));
        return "html_so2/student";
    }
    
}
