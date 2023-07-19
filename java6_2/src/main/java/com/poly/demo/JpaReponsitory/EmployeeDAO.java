package com.poly.demo.JpaReponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.poly.demo.bean.Employee;

@Service
public interface EmployeeDAO extends JpaRepository <Employee,String> {
    
}
