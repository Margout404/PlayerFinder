package com.example.PlayerFinder.DTO.user;

import com.example.PlayerFinder.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserCreateDTO dto);

    UserResponse toResponse(User entity);
}
