package com.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(unique = true)
	private String email;

	private String password;

	private String shippingAddress;

	private String paymentDetails;

	public Long getUserId() {
		return id;
	}

	public void setUserId(Long userId) {
		this.id = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(String paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public User() {
		
	}
	public User(Long userId, String name, String email, String password, String shippingAddress,
			String paymentDetails) {
		this.id = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.shippingAddress = shippingAddress;
		this.paymentDetails = paymentDetails;
	}

	@Override
	public String toString() {
		return "User [userId=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", shippingAddress=" + shippingAddress + ", paymentDetails=" + paymentDetails + "]";
	}

}
