package com.op.app.service.implementation;

import com.op.app.dto.UserDto;
import com.op.app.exception.UtilisateurNonTrouverException;
import com.op.app.model.User;
import com.op.app.repository.UserRepository;
import com.op.app.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserDto userDto) {
        var user = new User();
        user.setName(userDto.getName());
        user.setBalance(userDto.getBalance());
        return userRepository.save(user);
    }

    public double getBalance(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UtilisateurNonTrouverException("Utilisateur non trouve")).getBalance();
    }
}
