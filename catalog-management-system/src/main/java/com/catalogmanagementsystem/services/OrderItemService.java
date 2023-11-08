package com.catalogmanagementsystem.services;

import com.catalogmanagementsystem.entities.OrderItem;

public interface OrderItemService {
    void saveOrderItem(OrderItem orderItem);

    void deleteOrderItem(Long orderId);
}
