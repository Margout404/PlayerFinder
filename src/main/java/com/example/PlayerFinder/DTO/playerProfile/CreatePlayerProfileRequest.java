package com.example.PlayerFinder.DTO.playerProfile;

public record CreatePlayerProfileRequest(
        String firstName,
        String lastName,
        Integer ageInYears,
        String city,
        String primaryPosition,
        String availability,
        String description
) {
}
