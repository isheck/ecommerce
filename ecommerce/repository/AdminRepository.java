package com.ecommerce.repository;

import com.ecommerce.model.Admin;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);
}
