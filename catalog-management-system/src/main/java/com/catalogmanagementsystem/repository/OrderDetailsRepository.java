package com.catalogmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalogmanagementsystem.entities.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
	
}


