package com.catalogmanagementsystem.services;

import com.catalogmanagementsystem.entities.CartItem;
import com.catalogmanagementsystem.entities.Product;
import com.catalogmanagementsystem.entities.User;


import java.util.List;

public interface CartItemService {
    CartItem findCartItemById(Long cartItemId);

    List<CartItem> findAllCartItems();

    CartItem saveCartItem(CartItem cartItem);

    void deleteCartItem(Long cartItemId);
}

