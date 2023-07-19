package com.poly.demo.JpaReponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.poly.demo.bean.Role;

@Service
public interface RoleDAO extends JpaRepository <Role,Integer> {
    
}
