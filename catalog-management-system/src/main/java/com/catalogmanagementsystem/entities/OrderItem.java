package com.catalogmanagementsystem.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class OrderItem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    
    private String orderNumber;

    
    private Date orderDate;

    private double totalAmount;

}
