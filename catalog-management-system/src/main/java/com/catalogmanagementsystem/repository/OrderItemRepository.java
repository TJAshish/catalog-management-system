package com.catalogmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalogmanagementsystem.entities.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
//    List<OrderItem> findByUserId(Long userId);
}