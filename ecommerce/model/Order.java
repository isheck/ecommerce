package com.ecommerce.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Order_Entity")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "User_Id")
    private User user;

    private LocalDate orderDate;
    
    private double totalPrice;
    
	private String shippingAddress;
    
    private String orderStatus;
    
    private String paymentStatus;
    

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItem> cartItems;
    
	public Long getOrderId() {
		return id;
	}

	public void setOrderId(Long orderId) {
		this.id = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public List<CartItem> getCartItems() {
        return cartItems;
    }
 
    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
    
   @Override
   	public String toString() {
   		return "Order [orderId=" + id + ", user=" + user + ", orderDate=" + orderDate + ", totalPrice="
   				+ totalPrice + ", shippingAddress=" + shippingAddress + ", orderStatus=" + orderStatus
   				+ ", paymentStatus=" + paymentStatus + ", cart="  + (cartItems != null ? cartItems.size() : 0) + "]";
   	}
	
	public Order(Long orderId, User user, LocalDate orderDate, double totalPrice, String shippingAddress,
			String orderStatus, String paymentStatus,  List<CartItem> cartItems) {
		this.id = orderId;
		this.user = user;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.shippingAddress = shippingAddress;
		this.orderStatus = orderStatus;
		this.paymentStatus = paymentStatus;
		this.cartItems = cartItems;
	}

	
	
	public Order() {
	}
    
    
}
