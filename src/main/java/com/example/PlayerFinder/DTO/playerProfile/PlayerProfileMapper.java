package com.example.PlayerFinder.DTO.playerProfile;

import com.example.PlayerFinder.models.PlayerProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerProfileMapper {

    PlayerProfile toEntity(CreatePlayerProfileRequest dto);

    PlayerProfileResponse toResponse(PlayerProfile entity);
}
