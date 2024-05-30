package com.example.ex13interceptor_middleware1.users.controllers;

import com.example.ex13interceptor_middleware1.users.models.User;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

//    @Autowired
//    private UserRepository userRepository;
//
//    @PostMapping
//    public User create(@RequestBody User user) {
//        return userRepository.save(user);
//    }

    @GetMapping
    public User get(HttpServletRequest request) {
        return (User) request.getAttribute("LoggedUserInterceptor-user");
    }


}
