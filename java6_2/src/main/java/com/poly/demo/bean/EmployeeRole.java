package com.poly.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_roles", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"username","role_id"})
})
public class EmployeeRole {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    
    @ManyToOne
    @JoinColumn(name = "username")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;





}
