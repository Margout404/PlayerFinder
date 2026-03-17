package com.example.PlayerFinder.DTO.playerProfile;

import com.example.PlayerFinder.Enums.Availability;
import com.example.PlayerFinder.Enums.Category;
import com.example.PlayerFinder.Enums.Position;

import java.util.Set;

public record PlayerProfileResponse(
        Long id,
        String fName,
        String lName,
        int ageInYears,
        String city,
        Position primaryPosition,
        Set<Position> secondaryPositions,
        Set<Category> preferredCategories,
        Availability availability,
        String description
) {
}
