package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Admin;
import com.ecommerce.service.AdminService;

import lombok.experimental.PackagePrivate;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    
    @PostMapping
    public Admin addAdmin(@RequestBody Admin admin) {
    	return adminService.add(admin);
    }
    
    @GetMapping("/id/{id}")
    public Admin getById(@PathVariable Long id) throws Exception {
    	return adminService.findById(id);
    }

    @GetMapping("/email/{email}")
    public Admin getAdminByEmail(@PathVariable String email) throws Exception {
        return adminService.findByEmail(email);
    }
}
