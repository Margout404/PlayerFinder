package com.example.PlayerFinder.DTO.playerRequest;

import com.example.PlayerFinder.Enums.Category;
import com.example.PlayerFinder.Enums.Position;

public record PlayerRequestResponse(
        Long id,
        String teamName,
        String position,
        String category,
        String city,
        Integer minAge,
        Integer maxAge) {
}
