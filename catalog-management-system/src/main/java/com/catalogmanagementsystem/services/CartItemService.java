package com.catalogmanagementsystem.services;

import com.catalogmanagementsystem.entities.CartItem;
import com.catalogmanagementsystem.entities.Product;
import com.catalogmanagementsystem.entities.User;

public interface CartItemService {
    CartItem findById(Long id);
    void addProductToCart(User user, Product product, int quantity);
    void deleteById(Long id);
	
}

