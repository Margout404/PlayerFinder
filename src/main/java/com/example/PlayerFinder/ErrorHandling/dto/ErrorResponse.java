package com.example.PlayerFinder.ErrorHandling.dto;

import java.time.LocalDateTime;

public record ErrorResponse(
        String message,
        int status,
        LocalDateTime dateTime
) {
}
