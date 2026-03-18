package com.example.PlayerFinder.controller;

import com.example.PlayerFinder.DTO.login.LoginRequest;
import com.example.PlayerFinder.DTO.login.LoginResponse;
import com.example.PlayerFinder.DTO.user.UserCreateDTO;
import com.example.PlayerFinder.services.securityServices.AuthService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public void register(@RequestBody UserCreateDTO request) {
        authService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
