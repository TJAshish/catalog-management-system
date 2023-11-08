package com.catalogmanagementsystem.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogmanagementsystem.entities.CartItem;
import com.catalogmanagementsystem.entities.Product;
import com.catalogmanagementsystem.entities.User;
import com.catalogmanagementsystem.exceptions.CartItemNotFoundException;
import com.catalogmanagementsystem.repository.CartItemRepository;
import com.catalogmanagementsystem.services.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
    private CartItemRepository cartItemRepository;


    @Override
    public CartItem findById(Long id) {
        Optional<CartItem> cartItem = cartItemRepository.findById(id);
        if (cartItem.isEmpty()) {
            throw new CartItemNotFoundException("Cart item with ID " + id + " not found");
        }
        return cartItem.get();
    }


    @Override
    public void deleteById(Long id) {
        if (!cartItemRepository.existsById(id)) {
            throw new CartItemNotFoundException("Cart item with ID " + id + " not found");
        }
        cartItemRepository.deleteById(id);
    }

    @Override
    public void addProductToCart(User user, Product product, int quantity) {
        
        CartItem existingCartItem = cartItemRepository.findByUserAndProduct(user, product);

        // If the cart item exists, update the quantity
        if (existingCartItem != null) {
            existingCartItem.setQuantity(existingCartItem.getQuantity() + quantity);
            cartItemRepository.save(existingCartItem);
        } else {
            // If the cart item does not exist, create a new one
            CartItem newCartItem = new CartItem();
            cartItemRepository.save(newCartItem);
        }
    }

}

