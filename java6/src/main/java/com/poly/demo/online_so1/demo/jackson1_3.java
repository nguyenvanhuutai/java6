package com.poly.demo.online_so1.demo;

import java.io.File;

import javax.security.auth.Subject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jackson1_3 {

    public static void main(String[] args) throws Exception {
        demo1();
       //demo2();
    }

    public static void demo1() throws Exception {
        String jsonPath = "E:\\Ky6\\block2\\java6\\src\\main\\resources\\static\\json\\student.json";

        ObjectMapper mapper  = new ObjectMapper();
        JsonNode student = mapper.readTree(new File(jsonPath));

        System.out.println(">> Name: "+student.get("name").asText());
        System.out.println(">> Marks: "+student.get("marks").asDouble());
        System.out.println(">> Gender: "+student.get("gender").asBoolean());
        System.out.println(">> Email: "+student.get("contact").get("email").asText());
        System.out.println(">> Phone: "+student.findValue("phone").asText());
        student.get("subjects").iterator().forEachRemaining(subject -> System.out.println(">> Subject: " + subject.asText()) );

    }
    public static void demo2() throws Exception{
        String jsonPath = "E:\\Ky6\\block2\\java6\\src\\main\\java\\com\\poly\\demo\\online_so1\\demo\\students.json";
        ObjectMapper mapper  = new ObjectMapper();
        JsonNode students = mapper.readTree(new File(jsonPath));
        students.iterator().forEachRemaining(student ->
         System.out.println(">> Name: " + student.get("name").asText())
         );
    }
}
