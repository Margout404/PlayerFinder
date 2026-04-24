package com.example.PlayerFinder.services;

import com.example.PlayerFinder.DTO.playerProfile.CreatePlayerProfileRequest;
import com.example.PlayerFinder.DTO.playerProfile.PlayerProfileMapper;
import com.example.PlayerFinder.DTO.playerProfile.PlayerProfileResponse;
import com.example.PlayerFinder.Enums.Category;
import com.example.PlayerFinder.Enums.Position;
import com.example.PlayerFinder.ErrorHandling.Exceptions.NotFoundException;
import com.example.PlayerFinder.models.PlayerProfile;
import com.example.PlayerFinder.models.User;
import com.example.PlayerFinder.repositories.PlayerProfileRepository;
import com.example.PlayerFinder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PlayerService {

    @Autowired
    PlayerProfileRepository playerProfileRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PlayerProfileMapper mapper;

    public PlayerProfileResponse createPlayerProfile(CreatePlayerProfileRequest dto){
        PlayerProfile playerProfile= mapper.toEntity(dto);

        User user = userRepository.findById(dto.userId()).orElseThrow(
                ()-> new NotFoundException("User not found"));

        playerProfile.setUser(user);
        System.out.println(dto.firstName());
        System.out.println(dto.lastName());

        PlayerProfile saved= playerProfileRepository.save(playerProfile);
        return mapper.toResponse(saved);
    }
    public PlayerProfileResponse getPlayerByUserId(Long id){
        PlayerProfile playerProfile= playerProfileRepository.findByUserId(id).orElseThrow(
                ()->new NotFoundException("No player found"));
        return mapper.toResponse(playerProfile);
    }

    public Page<PlayerProfileResponse> searchPlayers(
            Position position,
            Category category,
            String city,
            Pageable pageable
    ){
        Page<PlayerProfile> playerProfilePage= playerProfileRepository.searchPlayers(position,category,city,pageable);

        return playerProfilePage.map(mapper::toResponse);
    }


}
