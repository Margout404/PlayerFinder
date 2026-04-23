package com.example.PlayerFinder.repositories;


import com.example.PlayerFinder.models.Application;
import com.example.PlayerFinder.models.PlayerProfile;
import com.example.PlayerFinder.models.PlayerRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long> {

    boolean existsByPlayerAndRequest(PlayerProfile player, PlayerRequest request);
}
