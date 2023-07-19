package com.poly.demo.online_so7.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poly.demo.JpaReponsitory.EmployeeDAO;
import com.poly.demo.JpaReponsitory.EmployeeRoleDAO;
import com.poly.demo.JpaReponsitory.RoleDAO;
import com.poly.demo.bean.EmployeeRole;

@RestController
public class EmployeeRoleRestController {

    @Autowired EmployeeRoleDAO employeeRoleDao;
    @Autowired RoleDAO roleDao;
    @Autowired EmployeeDAO employeeDao;


    @GetMapping("/rest/employeeRole")
    public Map<String,Object> employeeRole(){
        Map<String,Object> data = new HashMap<>();
        data.put("authorities", employeeRoleDao.findAll());
        data.put("roles", roleDao.findAll());
        data.put("accounts", employeeDao.findAll());

        return data;
    }
    
    @PostMapping("/rest/employeeRole")
    public EmployeeRole create(@RequestBody EmployeeRole employeeRole){
        return employeeRoleDao.save(employeeRole);
    }

    @DeleteMapping("/rest/employeeRole/{id}")
    public void delete(@PathVariable("id") Integer id){

        employeeRoleDao.deleteById(id);
    }
}
