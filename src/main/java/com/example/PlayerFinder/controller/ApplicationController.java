package com.example.PlayerFinder.controller;

import com.example.PlayerFinder.DTO.application.CreateApplicationRequest;
import com.example.PlayerFinder.DTO.application.CreateApplicationResponse;
import com.example.PlayerFinder.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @PostMapping("/createApplication")
    @PreAuthorize("hasRole('PLAYER')")
    public CreateApplicationResponse createApplication(@RequestBody CreateApplicationRequest dto,
                                                       Authentication authentication){
        return applicationService.createApplication(dto, authentication.getName());
    }
}
