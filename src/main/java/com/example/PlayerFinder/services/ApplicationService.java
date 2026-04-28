package com.example.PlayerFinder.services;

import com.example.PlayerFinder.DTO.application.ApplicationMapper;
import com.example.PlayerFinder.DTO.application.CreateApplicationRequest;
import com.example.PlayerFinder.DTO.application.CreateApplicationResponse;
import com.example.PlayerFinder.DTO.genericDTO.DeleteResponse;
import com.example.PlayerFinder.Enums.ApplicationStatus;
import com.example.PlayerFinder.ErrorHandling.Exceptions.AlreadyAppliedException;
import com.example.PlayerFinder.ErrorHandling.Exceptions.ForbiddenException;
import com.example.PlayerFinder.ErrorHandling.Exceptions.NotFoundException;
import com.example.PlayerFinder.models.Application;
import com.example.PlayerFinder.models.PlayerProfile;
import com.example.PlayerFinder.models.PlayerRequest;
import com.example.PlayerFinder.models.User;
import com.example.PlayerFinder.repositories.ApplicationRepository;
import com.example.PlayerFinder.repositories.PlayerRequestRepository;
import com.example.PlayerFinder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ApplicationService {

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PlayerRequestRepository playerRequestRepository;

    @Autowired
    ApplicationMapper applicationMapper;

    public CreateApplicationResponse createApplication(CreateApplicationRequest dto, String email){
        User user= userRepository.findByEmail(email).orElseThrow(
                ()-> new NotFoundException("User not found"));

        PlayerProfile playerProfile= user.getPlayerProfile();

        if (playerProfile == null) {
            throw new NotFoundException("User has no player profile");
        }

        PlayerRequest playerRequest= playerRequestRepository.findById(dto.playerRequestId())
                .orElseThrow(()-> new NotFoundException("This PlayerRequest does not exist"));

        Application application= new Application();
        application.setPlayer(playerProfile);
        application.setRequest(playerRequest);
        application.setStatus(ApplicationStatus.PENDING);

        if (applicationRepository.existsByPlayerAndRequest(playerProfile,playerRequest)){
            throw new AlreadyAppliedException("You already applied to this request");
        }

        Application saved= applicationRepository.save(application);

        return applicationMapper.toResponse(saved,playerRequest.getTeam().getTeamName());

    }

    public DeleteResponse deleteApplication(Long applicationId, String email){

        Application application= applicationRepository.findById(applicationId).orElseThrow(
                ()->new NotFoundException("Application with id :"+ applicationId +" not found"));

        if(application.getPlayer().getUser().getEmail().equals(email)) {

            applicationRepository.delete(application);

            String name = application.getPlayer().getFirstName() + " " + application.getPlayer().getLastName() + " application to " + application.getRequest().getTeam().getTeamName() + " deleted";

            String info = "Application with id : " + applicationId.toString() + " deleted";


            return new DeleteResponse(name, info, LocalDateTime.now());
        } else {
            throw new ForbiddenException("You are not allowed to delete this application");

        }
    }
}
