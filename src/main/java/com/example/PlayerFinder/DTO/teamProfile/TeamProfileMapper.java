package com.example.PlayerFinder.DTO.teamProfile;

import com.example.PlayerFinder.models.TeamProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamProfileMapper {

    TeamProfile toEntity(CreateTeamProfileRequest dto);

    TeamProfileResponse toResponse(TeamProfile entity);
}
