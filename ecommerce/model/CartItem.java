package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "Product_Id")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "User_Id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
 

	private Integer quantity;

	private double totalPrice;

	public Long getCartItemId() {
		return id;
	}

	public void setCartItemId(Long cartItemId) {
		this.id = cartItemId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public CartItem() {
	}

	public CartItem(Long cartItemId, Product product, User user, Integer quantity, double totalPrice) {
		super();
		this.id = cartItemId;
		this.product = product;
		this.user = user;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + id + ", product=" + product + ", user=" + user + ", quantity="
				+ quantity + ", totalPrice=" + totalPrice + "]";
	}

}
