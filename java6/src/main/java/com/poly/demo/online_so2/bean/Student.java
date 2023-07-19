package com.poly.demo.online_so2.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    String name;
    Boolean gender;
    Double marks = 0.0;
    Contact contact;
    List<String> subjects;
    
}
