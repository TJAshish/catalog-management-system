package com.catalogmanagementsystem.serviceImpl;

import com.catalogmanagementsystem.entities.OrderDetails;
import com.catalogmanagementsystem.repository.OrderDetailsRepository;
import com.catalogmanagementsystem.services.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
    private OrderDetailsRepository orderDetailsRepository;

    
    @Override
    public OrderDetails findById(Long id) {
        Optional<OrderDetails> orderDetails = orderDetailsRepository.findById(id);
        return orderDetails.orElse(null);
    }

    @Override
    public List<OrderDetails> findAll() {
        return orderDetailsRepository.findAll();
    }

    @Override
    public OrderDetails save(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public void deleteById(Long id) {
        orderDetailsRepository.deleteById(id);
    }
}

