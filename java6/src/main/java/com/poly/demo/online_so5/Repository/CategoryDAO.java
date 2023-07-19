package com.poly.demo.online_so5.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.demo.online_so5.Entity.Category;

public interface CategoryDAO extends JpaRepository<Category,Long> {
    
}
