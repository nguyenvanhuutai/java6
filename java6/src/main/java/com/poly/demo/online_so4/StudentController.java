package com.poly.demo.online_so4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.demo.online_so4.DAO.StudentDAO;
import com.poly.demo.online_so4.bean.Student;

@Controller 
public class StudentController {
    @Autowired
    StudentDAO dao;

    @RequestMapping("/student/index")
    public String index(Model model){
        Student student = new Student("", "",0.0, true, "VN");
        model.addAttribute("student", student);
        StudentMap map = dao.findAll();
        model.addAttribute("items", map);
        // System.out.println(map);
        return "html_so4/student/index";
    }

    @RequestMapping("/student/edit/{key}")
    public String edit(Model model,@PathVariable("key")String key){
        model.addAttribute("key", key);
        Student student = dao.findByKey(key);
        model.addAttribute("student", student);
        StudentMap map = dao.findAll();
        model.addAttribute("items", map);
        return "html_so4/student/index";   
    }

    @RequestMapping("/student/create")
    public String create(Student student){
        System.out.println(">>>>>>: "+student);
        dao.create(student);
        return "redirect:/student/index"; 
    }

    @RequestMapping("/student/update/{key}")
    public String update(Student student,@PathVariable("key")String key){
        dao.update(key, student);
        return "redirect:/student/edit/"+key;   
    }

    @RequestMapping("/student/delete/{key}")
    public String delete(@PathVariable("key")String key){
        dao.delete(key);
        return "redirect:/student/index";   
    }
}
