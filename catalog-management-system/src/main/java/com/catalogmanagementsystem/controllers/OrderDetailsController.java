package com.catalogmanagementsystem.controllers;

import com.catalogmanagementsystem.entities.OrderDetails;
import com.catalogmanagementsystem.services.OrderDetailsService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-details")
public class OrderDetailsController {

	@Autowired
    private OrderDetailsService orderDetailsService;


    @GetMapping("/{id}")
    public OrderDetails getOrderDetailsById(@PathVariable Long id) {
        return orderDetailsService.findById(id);
    }

    @GetMapping("/")
    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsService.findAll();
    }

    @PostMapping("/")
    public OrderDetails saveOrderDetails(@Valid @RequestBody OrderDetails orderDetails) {
        return orderDetailsService.save(orderDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderDetails(@PathVariable Long id) {
        orderDetailsService.deleteById(id);
    }
}
