package com.catalogmanagementsystem.controllers;

import com.catalogmanagementsystem.entities.CartItem;
import com.catalogmanagementsystem.entities.Product;
import com.catalogmanagementsystem.entities.User;
import com.catalogmanagementsystem.services.CartItemService;

import jakarta.validation.Valid;

import com.catalogmanagementsystem.exceptions.CartItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartItems")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/{id}")
    public ResponseEntity<CartItem> getCartItem(@PathVariable Long id) {
        try {
            CartItem cartItem = cartItemService.findById(id);
            return ResponseEntity.ok(cartItem);
        } catch (CartItemNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        try {
            cartItemService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (CartItemNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addProductToCart")
    public ResponseEntity<CartItem> addProductToCart(  @Valid
            @RequestParam Long userId,
            @RequestParam Long productId,
            @RequestParam int quantity
    ) {
        
        User user = new User(); 
        Product product = new Product(); 

        cartItemService.addProductToCart(user, product, quantity);
        return ResponseEntity.ok().build();
    }
}
