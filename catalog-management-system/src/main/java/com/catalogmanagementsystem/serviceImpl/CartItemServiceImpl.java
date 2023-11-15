package com.catalogmanagementsystem.serviceImpl;

import com.catalogmanagementsystem.entities.CartItem;
import com.catalogmanagementsystem.repository.CartItemRepository;
import com.catalogmanagementsystem.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartItem findCartItemById(Long cartItemId) {
        return cartItemRepository.findById(cartItemId).orElse(null);
    }

    @Override
    public List<CartItem> findAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public CartItem saveCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteCartItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }
}
