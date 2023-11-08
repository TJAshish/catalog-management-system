package com.catalogmanagementsystem.serviceImpl;

import com.catalogmanagementsystem.entities.OrderItem;
import com.catalogmanagementsystem.repository.OrderItemRepository;
import com.catalogmanagementsystem.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void saveOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    @Override
    public void deleteOrderItem(Long orderId) {
        orderItemRepository.deleteById(orderId);
    }
}

