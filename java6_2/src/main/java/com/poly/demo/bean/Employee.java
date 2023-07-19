package com.poly.demo.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    String username;
    String password;
    String fullName;
    String email;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
List<EmployeeRole> employeeRole;


    
}
