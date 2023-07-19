package com.poly.demo.online_so5.Entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Accounts")
public class Account implements Serializable {

    @Id
    String username;
    String password;
    String fullName;
    String email;
    String photo;
    Boolean activated;
    Boolean admin;
    
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    List<Order> orders;


    
}
