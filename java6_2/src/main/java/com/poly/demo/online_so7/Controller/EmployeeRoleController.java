package com.poly.demo.online_so7.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.poly.demo.JpaReponsitory.EmployeeDAO;
import com.poly.demo.JpaReponsitory.EmployeeRoleDAO;
import com.poly.demo.JpaReponsitory.RoleDAO;

@Controller
public class EmployeeRoleController {

    @Autowired EmployeeRoleDAO employeeRole;
    @Autowired RoleDAO role;
    @Autowired EmployeeDAO employee;
    @GetMapping("/employeeRole")
    public String a(){
    return "html_so7/index";
    }
    

}
