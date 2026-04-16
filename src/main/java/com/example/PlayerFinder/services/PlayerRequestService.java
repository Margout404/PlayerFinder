package com.example.PlayerFinder.services;

import com.example.PlayerFinder.DTO.playerRequest.CreatePlayerRequest;
import com.example.PlayerFinder.DTO.playerRequest.PlayerRequestMapper;
import com.example.PlayerFinder.DTO.playerRequest.PlayerRequestResponse;
import com.example.PlayerFinder.Enums.Category;
import com.example.PlayerFinder.Enums.Position;
import com.example.PlayerFinder.models.PlayerRequest;
import com.example.PlayerFinder.models.TeamProfile;
import com.example.PlayerFinder.models.User;
import com.example.PlayerFinder.repositories.PlayerRequestRepository;
import com.example.PlayerFinder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PlayerRequestService {

    @Autowired
    PlayerRequestRepository playerRequestRepository;

    @Autowired
    PlayerRequestMapper playerRequestMapper;
    @Autowired
    private UserRepository userRepository;

    public Page<PlayerRequestResponse> getPlayerRequests(Position position,
                                                         Category category,
                                                         String city,
                                                         Integer minAge,
                                                         Integer maxAge,
                                                         Pageable pageable) {
        Page<PlayerRequest> playerRequestsPage = playerRequestRepository.searchPlayerRequests(position, category, city, minAge, maxAge, pageable);

        return playerRequestsPage.map(playerRequestMapper::toResponse);
    }

    public PlayerRequestResponse createPlayerRequest(CreatePlayerRequest dto, String email){
        User user= userRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("No User Found"));

        TeamProfile teamProfile= user.getTeamProfile();


        PlayerRequest playerRequest= playerRequestMapper.toEntity(dto);


        playerRequest.setTeam(teamProfile);

        System.out.println("USER: " + user.getEmail());
        System.out.println("TEAM PROFILE: " + user.getTeamProfile());

        if (user.getTeamProfile() == null) {
            throw new RuntimeException("Authenticated user has no TeamProfile");
        }
        PlayerRequest saved = playerRequestRepository.save(playerRequest);
        return playerRequestMapper.toResponse(saved);
    }
}
