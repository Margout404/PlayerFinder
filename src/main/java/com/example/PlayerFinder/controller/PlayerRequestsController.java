package com.example.PlayerFinder.controller;

import com.example.PlayerFinder.DTO.playerRequest.CreatePlayerRequest;
import com.example.PlayerFinder.DTO.playerRequest.PlayerRequestMapper;
import com.example.PlayerFinder.DTO.playerRequest.PlayerRequestResponse;
import com.example.PlayerFinder.Enums.Category;
import com.example.PlayerFinder.Enums.Position;
import com.example.PlayerFinder.services.PlayerRequestService;
import com.example.PlayerFinder.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/PlayerRequests")
public class PlayerRequestsController {

    @Autowired
    PlayerRequestService playerRequestService;
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public Page<PlayerRequestResponse> searchPlayerRequests(@RequestParam(required = false) Position position,
                                                            @RequestParam(required = false) Category category,
                                                            @RequestParam(required = false) String city,
                                                            @RequestParam(required = false) Integer minAge,
                                                            @RequestParam(required = false) Integer maxAge,
                                                            @RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);

        return playerRequestService.getPlayerRequests(position, category, city,minAge,maxAge, pageable);

    }

    @PostMapping
    @PreAuthorize("hasRole('TEAM')")
    public PlayerRequestResponse createPlayerRequest(@RequestBody CreatePlayerRequest dto, Authentication authentication){
        return playerRequestService.createPlayerRequest(dto,authentication.getName());
    }


}
