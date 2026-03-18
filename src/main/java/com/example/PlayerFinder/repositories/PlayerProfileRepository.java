package com.example.PlayerFinder.repositories;

import com.example.PlayerFinder.Enums.Category;
import com.example.PlayerFinder.Enums.Position;
import com.example.PlayerFinder.models.PlayerProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerProfileRepository extends JpaRepository<PlayerProfile, Long> {

    @Query("""
        SELECT p FROM PlayerProfile p
        WHERE
            (:position IS NULL OR
                p.primaryPosition = :position OR
                :position MEMBER OF p.secondaryPositions)
        AND
            (:category IS NULL OR
                :category MEMBER OF p.preferredCategories)
        AND
            (:city IS NULL OR
                LOWER(p.city) LIKE LOWER(CONCAT('%', :city, '%')))
    """)
    Page<PlayerProfile> searchPlayers(
            @Param("position") Position position,
            @Param("category") Category category,
            @Param("city") String city,
            Pageable pageable
    );

    Optional<PlayerProfile> findByUserId(Long userId);

    List<PlayerProfile> findByCity(String city);

    String city(String city);
}
