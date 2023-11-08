package com.catalogmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalogmanagementsystem.entities.CartItem;
import com.catalogmanagementsystem.entities.Product;
import com.catalogmanagementsystem.entities.User;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

	CartItem findByUserAndProduct(User user, Product product);

}
