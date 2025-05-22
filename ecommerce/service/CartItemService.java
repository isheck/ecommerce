package com.ecommerce.service;

import com.ecommerce.model.CartItem;
import com.ecommerce.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> getCartItemsByUserId(Long userId) throws Exception {
        List<CartItem> cartItems = cartItemRepository.findByUser_Id(userId);
        if(cartItems.isEmpty()) {
        	throw new Exception("Cart is empty");
        }
        return cartItems;
    }

    public CartItem saveCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public void deleteCartItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

	public CartItem getById(Long id) throws Exception {
		return cartItemRepository.findById(id).orElseThrow(() -> new Exception("Cart not found"));
	}
}
