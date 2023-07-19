package com.poly.demo.online_so4.DAO;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.demo.online_so4.StudentMap;
import com.poly.demo.online_so4.bean.Student;

@Repository
public class StudentDAO {
    RestTemplate rest = new RestTemplate();

    String url ="https://poly-java-6-66445-default-rtdb.firebaseio.com/students.json";
    private String getUrl(String key){
        return url.replace(".json","/"+ key+".json");
    }

    public StudentMap findAll(){
        return rest.getForObject(url,  StudentMap.class);
    }   

    public Student findByKey(String key){
        return rest.getForObject(getUrl(key),  Student.class);
    }
    public String create(Student data){
        HttpEntity<Student> entity  = new HttpEntity<>(data);
        JsonNode resp = rest.postForObject(url, entity, JsonNode.class );
        return resp.get("name").asText();

    }

    public Student update(String key,Student data){
        HttpEntity<Student> entity  = new HttpEntity<>(data);
        rest.put(getUrl(key),entity);
        return data;
    }
//     public Student update(String key, Student data) {
//     HttpEntity<Student> entity = new HttpEntity<>(data);
//     rest.put(getUrl(key), entity);
//     Student updatedData = rest.getForObject(getUrl(key), Student.class);
//     return updatedData;
// }


    // public void delete(String key){
    //     rest.delete(getUrl(key));
    // }
        public boolean delete(String key) {
    try {
        rest.delete(getUrl(key));
        return true;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

}
