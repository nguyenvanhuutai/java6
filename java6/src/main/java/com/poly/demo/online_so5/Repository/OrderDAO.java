package com.poly.demo.online_so5.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.demo.online_so5.Entity.Order;

public interface OrderDAO extends JpaRepository<Order,Long> {
    
}
