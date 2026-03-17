package com.example.PlayerFinder.DTO.teamProfile;

import com.example.PlayerFinder.Enums.Category;

public record TeamProfileResponse(

        Long id,
        String teamName,
        String city,
        Category category,
        String division,
        String homeGround,
        String description
) {
}
