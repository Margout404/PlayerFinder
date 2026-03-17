package com.example.PlayerFinder.DTO.user;

import com.example.PlayerFinder.Enums.Role;

public record UserCreateDTO (
        String email,
        Role role
){
}
