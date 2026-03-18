package com.example.PlayerFinder.DTO.playerProfile;

import com.example.PlayerFinder.Enums.Availability;
import com.example.PlayerFinder.Enums.Category;
import com.example.PlayerFinder.Enums.Position;

import java.util.Set;

public record CreatePlayerProfileRequest(
        Long userId,
        String firstName,
        String lastName,
        Integer ageInYears,
        String city,
        Position primaryPosition,
        Set<Position> secondaryPositions,
        Set<Category> preferredCategories,
        Set<Availability> availability,
        String description
) {
}
