package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Helper method to check if a user exists
    private boolean userExists(Long id) {
        return userRepository.findById(id).isPresent();
    }
    
    public User findByEmail(String email) throws Exception {
        return userRepository.findByEmail(email).orElseThrow(() -> new Exception("User not found"));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    public User updateUser(User user) throws Exception {
    	if (!userExists(user.getUserId())) {
            throw new Exception("User not found");
        }
    	return userRepository.save(user);
    }

    public User getUserById(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
    }
}
