package com.poly.demo.online_so1.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student_4 {
    String name;
    Boolean gender;
    Double marks = 0.0;
    Contact_4 contact;
    List<String> subjects;
    
}
