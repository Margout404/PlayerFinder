package com.example.PlayerFinder.DTO.playerRequest;

import com.example.PlayerFinder.models.PlayerRequest;
import org.mapstruct.Mapper;

@Mapper
public class PlayerRequestMapper {

    public PlayerRequestResponse toResponse(PlayerRequest p){
        return new PlayerRequestResponse(
                p.getId(),
                p.getTeam().getTeamName(),
                p.getPosition().name(),
                p.getCategory().name(),
                p.getTeam().getCity(),
                p.getMinAge(),
                p.getMaxAge()
        );
    }
}
