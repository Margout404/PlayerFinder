package com.example.PlayerFinder.controller;

import com.example.PlayerFinder.DTO.teamProfile.CreateTeamProfileRequest;
import com.example.PlayerFinder.DTO.teamProfile.TeamProfileResponse;
import com.example.PlayerFinder.services.TeamProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/team-profiles")
public class TeamProfileController {

    @Autowired
    TeamProfileService service;

    @PostMapping
    public TeamProfileResponse create(@RequestBody CreateTeamProfileRequest request){
        return service.createTeamProfile(request);
    }

    @GetMapping("/by-user/{userId}")
    public TeamProfileResponse getTeamByUserId(@PathVariable Long userId){
        return service.getTeamByUserId(userId);
    }
}
