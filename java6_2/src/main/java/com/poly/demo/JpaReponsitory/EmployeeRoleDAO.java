package com.poly.demo.JpaReponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.poly.demo.bean.EmployeeRole;

@Service
public interface EmployeeRoleDAO extends JpaRepository <EmployeeRole,Integer> {
    
}
