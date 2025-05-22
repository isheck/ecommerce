package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.CartItem;
import com.ecommerce.service.CartItemService;

@RestController
@RequestMapping("/api/cart")
public class CartItemController {
	@Autowired
	private CartItemService cartItemService;
	
	@GetMapping("/{id}")
	public CartItem getCartItem(@PathVariable Long id) throws Exception {
		return cartItemService.getById(id);
	}

	@GetMapping("/user/{userId}")
	public List<CartItem> getCartItemsByUser(@PathVariable Long userId) throws Exception {
		return cartItemService.getCartItemsByUserId(userId);
	}

	@PostMapping
	public CartItem addCartItem(@RequestBody CartItem cartItem) {
		return cartItemService.saveCartItem(cartItem);
	}

	@DeleteMapping("/{cartItemId}")
	public String deleteCartItem(@PathVariable Long cartItemId) {
		cartItemService.deleteCartItem(cartItemId);
		return "Deleted Cart Item : "+cartItemId;
	}
}
