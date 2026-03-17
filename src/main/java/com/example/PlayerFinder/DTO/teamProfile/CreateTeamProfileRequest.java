package com.example.PlayerFinder.DTO.teamProfile;

import com.example.PlayerFinder.Enums.Category;
import com.example.PlayerFinder.models.User;

public record CreateTeamProfileRequest(
        Long userId,
        String teamName,
        String city,
        Category category,
        String division,
        String homeGround,
        String description
) {
}
