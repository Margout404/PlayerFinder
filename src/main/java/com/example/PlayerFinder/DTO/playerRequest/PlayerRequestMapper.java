package com.example.PlayerFinder.DTO.playerRequest;

import com.example.PlayerFinder.Enums.RequestStatus;
import com.example.PlayerFinder.models.PlayerRequest;
import org.springframework.stereotype.Component;

@Component
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
    public PlayerRequest toEntity(CreatePlayerRequest dto){
        PlayerRequest playerRequest= new PlayerRequest();

        playerRequest.setCategory(dto.category());
        playerRequest.setStatus(RequestStatus.OPEN);
        playerRequest.setMinAge(dto.minAge());
        playerRequest.setMaxAge(dto.maxAge());
        playerRequest.setPosition(dto.position());

        return playerRequest;
    }
}
