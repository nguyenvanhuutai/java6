package com.poly.demo.online_so5.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.poly.demo.online_so5.Entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail,Long> {
    
}
