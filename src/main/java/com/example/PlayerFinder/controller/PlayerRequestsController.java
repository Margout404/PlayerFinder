package com.example.PlayerFinder.controller;

import com.example.PlayerFinder.DTO.playerRequest.PlayerRequestResponse;
import com.example.PlayerFinder.Enums.Category;
import com.example.PlayerFinder.Enums.Position;
import com.example.PlayerFinder.services.PlayerRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/PlayerRequests")
public class PlayerRequestsController {

    @Autowired
    PlayerRequestService playerRequestService;

    @GetMapping
    public Page<PlayerRequestResponse> searchPlayerRequests(@RequestParam(required = false) Position position,
                                                            @RequestParam(required = false) Category category,
                                                            @RequestParam(required = false) String city,
                                                            @RequestParam(required = false) Integer minAge,
                                                            @RequestParam(required = false) Integer maxAge,
                                                            @RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);

        return playerRequestService.getPlayerRequests(position, category, city, pageable);

    }


}
