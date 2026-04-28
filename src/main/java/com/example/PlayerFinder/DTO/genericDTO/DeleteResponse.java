package com.example.PlayerFinder.DTO.genericDTO;

import java.time.LocalDateTime;

public record DeleteResponse(
        String name,
        String info,
        LocalDateTime time
) {
}
