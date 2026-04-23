package com.example.PlayerFinder.DTO.application;

import com.example.PlayerFinder.models.Application;
import org.springframework.stereotype.Component;

@Component
public class ApplicationMapper {

    public CreateApplicationResponse toResponse(Application application, String teamName){
        return new CreateApplicationResponse(
                application.getId(),
                application.getPlayer().getFirstName()+ " "+application.getPlayer().getLastName(),
                application.getRequest().getId(),
                application.getStatus(),
                application.getCreatedAt(),
                teamName
        );
    }
}
