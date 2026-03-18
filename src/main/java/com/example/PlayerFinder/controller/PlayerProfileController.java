package com.example.PlayerFinder.controller;

import com.example.PlayerFinder.DTO.playerProfile.CreatePlayerProfileRequest;
import com.example.PlayerFinder.DTO.playerProfile.PlayerProfileResponse;
import com.example.PlayerFinder.Enums.Category;
import com.example.PlayerFinder.Enums.Position;
import com.example.PlayerFinder.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/player-profiles")
public class PlayerProfileController {

    @Autowired
    PlayerService playerService;

    @PostMapping("/createPlayerProfile")
    public PlayerProfileResponse create(@RequestBody CreatePlayerProfileRequest request){
        return playerService.createPlayerProfile(request);
    }

    @GetMapping("/getByUserId/{id}")
    public PlayerProfileResponse getByUserId(@PathVariable Long id){
        return playerService.getPlayerByUserId(id);
    }

    @GetMapping("/search")
    public Page<PlayerProfileResponse> searchPlayers(
            @RequestParam(required = false) Position position,
            @RequestParam(required = false) Category category,
            @RequestParam(required = false) String city,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        Pageable pageable = PageRequest.of(page, size);

        return playerService.searchPlayers(position, category, city, pageable);
    }
}
