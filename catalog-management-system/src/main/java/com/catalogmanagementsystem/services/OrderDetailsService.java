package com.catalogmanagementsystem.services;

import com.catalogmanagementsystem.entities.OrderDetails;

import java.util.List;

public interface OrderDetailsService {
    OrderDetails findById(Long id);
    List<OrderDetails> findAll(); 
    OrderDetails save(OrderDetails orderDetails);
    void deleteById(Long id);
}

