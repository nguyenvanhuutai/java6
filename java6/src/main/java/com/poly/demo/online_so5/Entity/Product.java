package com.poly.demo.online_so5.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Products")
public class Product implements Serializable {
    @Id
    String id;

    String name;

    String email;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    Date createdDate = new Date();

    Boolean available;
        
    @ManyToOne
    @JoinColumn(name  = "category_id")
    Category category;
  


    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetails;
    

}
