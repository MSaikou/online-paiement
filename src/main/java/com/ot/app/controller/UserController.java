package com.ot.app.controller;

import com.ot.app.dto.UserDto;
import com.ot.app.model.User;
import com.ot.app.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDto userDto) {
        User user = userService.createUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/balances")
    public double getBalance(@PathVariable Long userId) {
        return userService.getBalance(userId);
    }
}
