package com.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	private String password;

	public Long getAdminId() {
		return id;
	}

	public void setAdminId(Long adminId) {
		this.id = adminId;
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

	public Admin() {
	}
	
	public Admin(Long adminId, String name, String email, String password) {
		this.id = adminId;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}

}
