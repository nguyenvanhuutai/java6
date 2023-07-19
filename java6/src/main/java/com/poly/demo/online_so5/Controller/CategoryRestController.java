package com.poly.demo.online_so5.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poly.demo.online_so5.Entity.Category;
import com.poly.demo.online_so5.Repository.CategoryDAO;


@CrossOrigin("*")
@RestController
public class CategoryRestController {
    
    @Autowired
    CategoryDAO dao;

    @GetMapping("/rest/categories")
    public ResponseEntity<List<Category>> getAll(Model model){
        return ResponseEntity.ok(dao.findAll());
    }

    
    @GetMapping("/rest/categories/{id}")
    public ResponseEntity<Category> getOne(@PathVariable("id") Long id){
        if(!dao.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dao.findById(id).get());
    }

    @PostMapping("/rest/categories")
    public ResponseEntity<Category> post(@RequestBody Category category){
       if(dao.existsById(category.getId())){
        return ResponseEntity.badRequest().build();
       }
       dao.save(category);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/rest/categories/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") Long id, @RequestBody Category category){
        if(!dao.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        dao.save(category);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/rest/categories/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id){
       
          if(!dao.existsById(id)){
            return ResponseEntity.notFound().build();
          }
           dao.deleteById(id);
           return ResponseEntity.ok(true);
       
    }
}
