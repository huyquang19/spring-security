package com.example.shopee_security.controller;

import com.example.shopee_security.model.User;
import com.example.shopee_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login() {
        return "Login";
    }

    @PostMapping("/register")
    public Boolean register(@RequestBody User user) {
        return userService.createUser(user);
    }

}
