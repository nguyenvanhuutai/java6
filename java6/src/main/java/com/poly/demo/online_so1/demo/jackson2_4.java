package com.poly.demo.online_so1.demo;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.poly.demo.online_so1.bean.Contact_4;
import com.poly.demo.online_so1.bean.Student_4;

public class jackson2_4 {
    public static void main(String[] args) throws Exception {
        //demo1();
        //demo2();
        //demo3();
        demo4();
        //demo5();
        //demo6();
        //demo7();
    }
    
   

    private static void demo7() throws Exception {
       
        Contact_4 contact = new Contact_4("teonv@gmail.com", "090239402", null);
        List<String> subjects = Arrays.asList("WEB205","COM108");
        Student_4 student = new Student_4("nguyễn văn tèo", true, 7.3, contact, subjects);
        ObjectMapper mapper = new ObjectMapper();
        // Write to String
        String json = mapper.writeValueAsString(student);
        System.out.println(json);
        // Write to output 
        mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, student);
        // Write to file
        mapper.writeValue(new File("e:/temp/student.json"), student);
    }



    private static void demo6() throws Exception {
        Map<String,Object> contact = new HashMap<String,Object>();
        
        contact.put("email","teo@gmail.com");
        contact.put("phone", "0929812312");

        List<String> subjects = Arrays.asList("WEB205","COM108");

        Map<String,Object> student = new HashMap<String,Object>();

        student.put("name", "Nguyễn Văn Tèo");
        student.put("marks",7.8);
        student.put("gender",true);
        student.put("contact",contact);
        student.put("subjects",subjects);

        ObjectMapper mapper = new ObjectMapper();
        // Write to String
        String json = mapper.writeValueAsString(student);
        System.out.println(json);
        // Write to output 
        mapper.writeValue(System.out, student);
        // Write to file
        mapper.writeValue(new File("e:/temp/student.json"), student);
    }



    private static void demo5() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode student = mapper.createObjectNode();
        student.put("name", "Nguyễn Văn Tèo");
        student.put("marks",7.8);
        student.put("gender",true);

        ObjectNode contact = student.putObject("contact");
        contact.put("email","teo@gmail.com");
        contact.put("phone", "0929812312");

        ArrayNode subjects = student.putArray("subjects");
        subjects.add("WEB205");
        subjects.add("COM108");

        // Write to String
        String json = mapper.writeValueAsString(student);
        // Write to output 
        mapper.writeValue(System.out, student);
        // Write to file
        mapper.writeValue(new File("e:/temp/student.json"), student);
        


        
    }



    public static void demo1() throws Exception{
        String jsonPath = "E:\\Ky6\\block2\\java6\\src\\main\\resources\\static\\json\\student.json";

        ObjectMapper mapper  = new ObjectMapper();
        Map<String,Object> student =mapper.readValue(new File(jsonPath), Map.class);

        System.out.println(">> Name: "+student.get("name"));
        System.out.println(">> Marks: "+student.get("marks"));
        System.out.println(">> Gender: "+student.get("gender") );
        Map<String,Object> contact = (Map<String,Object>) student.get("contact");
        System.out.println(">> Email: "+contact.get("email"));
        System.out.println(">> Phone: "+contact.get("phone"));

        List<String> subjects = (List<String>) student.get("subjects");
        subjects.forEach(subject -> System.out.println(">> subjects: "+subjects));
    }
    public static void demo2() throws Exception{
        String jsonPath = "E:\\Ky6\\block2\\java6\\src\\main\\resources\\static\\json\\students.json";
        ObjectMapper mapper  = new ObjectMapper();
        List<Map<String,Object>> students =mapper.readValue(new File(jsonPath),List.class);
        students.forEach(st -> System.out.println(">> Name: "+st.get("name")));
    }
    private static void demo3() throws Exception {
        String jsonPath = "E:\\Ky6\\block2\\java6\\src\\main\\resources\\static\\json\\student.json";

        ObjectMapper mapper  = new ObjectMapper();
        Student_4 student =mapper.readValue(new File(jsonPath), Student_4.class);

        System.out.println(">> Name: "+student.getName());
        System.out.println(">> Marks: "+student.getMarks());
         System.out.println(">> Gender: "+student.getGender() );
        Contact_4 contact = student.getContact();
        System.out.println(">> Email: "+contact.getEmail());
        System.out.println(">> Phone: "+contact.getPhone());

        List<String> subjects = student.getSubjects();
        subjects.forEach(subject -> System.out.println(">> subjects: "+subject));
    }

    private static void demo4() throws Exception {
        String jsonPath = "E:\\Ky6\\block2\\java6\\src\\main\\resources\\static\\json\\students.json";
        TypeReference<List<Student_4>> type = new TypeReference<List<Student_4>>() {};
        ObjectMapper mapper  = new ObjectMapper();
        List<Student_4> students = mapper.readValue(new File(jsonPath),type);
        students.forEach(st -> System.out.println(">> Name: "+st.getName()));
    }

}
