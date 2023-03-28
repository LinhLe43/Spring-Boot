package com.example.blogbackend.controller;

import com.example.blogbackend.request.LoginRequest;
import com.example.blogbackend.response.AuthResponse;
import com.example.blogbackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("handle-login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
fewfwefwfw