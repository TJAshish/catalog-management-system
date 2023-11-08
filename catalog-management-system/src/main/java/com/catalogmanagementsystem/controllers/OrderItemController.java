package com.catalogmanagementsystem.controllers;

import com.catalogmanagementsystem.entities.OrderItem;
import com.catalogmanagementsystem.services.OrderItemService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

	@Autowired
    private OrderItemService orderItemService;

    @PostMapping("/")
    public void saveOrderItem(@Valid @RequestBody OrderItem orderItem) {
        orderItemService.saveOrderItem(orderItem);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrderItem(@PathVariable Long orderId) {
        orderItemService.deleteOrderItem(orderId);
    }
}
