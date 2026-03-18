package com.example.PlayerFinder.DTO.playerProfile;

import com.example.PlayerFinder.Enums.Availability;
import com.example.PlayerFinder.Enums.Category;
import com.example.PlayerFinder.Enums.Position;
import java.util.Set;

public record PlayerProfileResponse(
        Long id,
        String firstName,
        String lastName,
        int ageInYears,
        String city,
        Position primaryPosition,
        Set<Position> secondaryPositions,
        Set<Category> preferredCategories,
        Set<Availability> availability,
        String description
) {
}
