package com.ot.app.controller;

import com.ot.app.model.User;
import com.ot.app.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestParam String name, @RequestParam double balance) {
        return userService.createUser(name, balance);
    }

    @GetMapping("/{userId}/balances")
    public double getBalance(@PathVariable Long userId) {
        return userService.getBalance(userId);
    }
}
