package com.poly.demo.online_so5.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poly.demo.online_so5.Repository.StudentDAOO;
import com.poly.demo.online_so5.bean.Student;

@CrossOrigin("*")
@RestController
public class StudentRestController {
    
    @Autowired
    StudentDAOO dao;

    @GetMapping("/rest/students")
    public List<Student> getAll(Model model){
        return dao.findAll();
    }

    @GetMapping("/rest/students/{email}")
    public Student getOne(Model model,@PathVariable("email") String email){
        return dao.findById(email).get();
    }

    @PostMapping("/rest/students")
    public Student post(@RequestBody Student student){
        dao.save(student);
        return student;
    }

    @PutMapping("/rest/students/{email}")
    public Student update(@PathVariable("email") String email, @RequestBody Student student){
        dao.save(student);
        return student;
    }

    @DeleteMapping("/rest/students/{email}")
    public Boolean delete(@PathVariable("email") String email){
        try {
            dao.deleteById(email);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
