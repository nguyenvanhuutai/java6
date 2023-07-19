package com.poly.demo.online_so5.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.demo.online_so5.bean.Student;

public interface StudentDAOO extends JpaRepository <Student,String>  {
    
}
