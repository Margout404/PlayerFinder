package com.example.PlayerFinder.DTO.user;

import com.example.PlayerFinder.Enums.Role;

import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String email,
        Role role,
        LocalDateTime createdAt,
        Boolean active
) {
}
