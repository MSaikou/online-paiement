package com.ot.app.service;

import com.ot.app.model.User;
import com.ot.app.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, double balance) {
        User user = new User();
        user.setName(name);
        user.setBalance(balance);
        return userRepository.save(user);
    }

    public double getBalance(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouve")).getBalance();
    }
}
