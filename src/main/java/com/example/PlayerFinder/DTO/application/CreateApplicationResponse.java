package com.example.PlayerFinder.DTO.application;

import com.example.PlayerFinder.Enums.ApplicationStatus;

import java.time.LocalDateTime;

public record CreateApplicationResponse(
        Long id,
        String playerName,
        Long requestId,
        ApplicationStatus status,
        LocalDateTime createdAt,
        String teamName
) {
}
