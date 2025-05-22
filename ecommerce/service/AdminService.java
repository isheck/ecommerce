package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Admin;
import com.ecommerce.repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin findByEmail(String email) throws Exception {
        Admin admin = adminRepository.findByEmail(email).orElseThrow(() -> new Exception("Admin not found"));
        return admin;
    }

	public Admin add(Admin admin) {
		return adminRepository.save(admin);
	}

	public Admin findById(Long id) throws Exception {
		return adminRepository.findById(id).orElseThrow(() -> new Exception("Admin not found"));
	}
}
