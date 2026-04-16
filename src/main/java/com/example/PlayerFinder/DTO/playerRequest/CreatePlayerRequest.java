package com.example.PlayerFinder.DTO.playerRequest;

import com.example.PlayerFinder.Enums.Category;
import com.example.PlayerFinder.Enums.Position;
import com.example.PlayerFinder.models.TeamProfile;

public record CreatePlayerRequest(
        Position position,
        Category category,
        Integer minAge,
        Integer maxAge
) {
}
