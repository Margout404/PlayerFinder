package com.example.PlayerFinder.services;


import com.example.PlayerFinder.DTO.teamProfile.CreateTeamProfileRequest;
import com.example.PlayerFinder.DTO.teamProfile.TeamProfileMapper;
import com.example.PlayerFinder.DTO.teamProfile.TeamProfileResponse;
import com.example.PlayerFinder.models.TeamProfile;
import com.example.PlayerFinder.models.User;
import com.example.PlayerFinder.repositories.TeamProfileRepository;
import com.example.PlayerFinder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamProfileService {

    @Autowired
    TeamProfileRepository teamProfileRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    TeamProfileMapper mapper;

    public TeamProfileResponse createTeamProfile(CreateTeamProfileRequest dto){
        TeamProfile teamProfile= mapper.toEntity(dto);
        User user = userRepository.findById(dto.userId()).orElseThrow(()-> new RuntimeException("User not found"));
        teamProfile.setUser(user);
        TeamProfile saved= teamProfileRepository.save(teamProfile);
        return mapper.toResponse(saved);
    }
    public TeamProfileResponse getTeamByUserId(Long userId){
        TeamProfile teamProfile= teamProfileRepository
                .findByUserId(userId)
                .orElseThrow(()-> new RuntimeException("Team profile not found"));
        return mapper.toResponse(teamProfile);

    }
}
