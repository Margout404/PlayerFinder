package com.example.PlayerFinder.repositories;

import com.example.PlayerFinder.models.TeamProfile;
import com.example.PlayerFinder.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeamProfileRepository extends JpaRepository<TeamProfile, Long> {
    Optional<TeamProfile> findByUserId(Long userId);

    List<TeamProfile> findByCity(String city);

    Long user(User user);
}
