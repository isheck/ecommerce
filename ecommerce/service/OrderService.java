package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Order;
import com.ecommerce.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	public List<Order> getOrdersByUserId(Long userId) throws Exception {
		List<Order> orders = orderRepository.findByUserId(userId);
		if (orders.isEmpty()) {
			throw new Exception("Order not found");
		}
		return orders;
	}

	public Order getOrderById(Long orderId) throws Exception {
		return orderRepository.findById(orderId).orElseThrow(() -> new Exception("Order not found"));
	}

	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}
}
