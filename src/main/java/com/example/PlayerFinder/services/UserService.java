package com.example.PlayerFinder.services;

import com.example.PlayerFinder.DTO.user.UserCreateDTO;
import com.example.PlayerFinder.DTO.user.UserMapper;
import com.example.PlayerFinder.DTO.user.UserResponse;
import com.example.PlayerFinder.models.User;
import com.example.PlayerFinder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserMapper mapper;

    @Autowired
    UserRepository repository;

    public UserResponse createUser(UserCreateDTO dto){
        User user= mapper.toEntity(dto);

        User saved= repository.save(user);
        return mapper.toResponse(saved);
    }

    public UserResponse getUserByEmail(String email){
        User user= repository.findByEmail(email).orElseThrow(()-> new RuntimeException("User with this email not found "+ email));
        return mapper.toResponse(user);
    }

}
