package com.example.PlayerFinder.controller;

import com.example.PlayerFinder.DTO.user.UserCreateDTO;
import com.example.PlayerFinder.DTO.user.UserResponse;
import com.example.PlayerFinder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/createUser")
    public UserResponse createUser(@RequestBody UserCreateDTO dto){
        return service.createUser(dto);
    }

    @GetMapping("/getUserByEmail/{email}")
    public UserResponse getByEmail(@PathVariable String email){
        return service.getUserByEmail(email);
    }

//    get my infos from token
    @GetMapping("/me")
    public UserResponse getWhoAmI(Authentication authentication){
        String email= authentication.getName();

        return service.getUserByEmail(email);
    }
}
