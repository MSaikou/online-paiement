package com.op.app.service.implementation;

import com.op.app.dto.UserDto;
import com.op.app.model.User;
import com.op.app.repository.UserRepository;
import com.op.app.service.UserSerivce;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserSerivce {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setBalance(userDto.getBalance());
        return userRepository.save(user);
    }

    public double getBalance(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouve")).getBalance();
    }
}
