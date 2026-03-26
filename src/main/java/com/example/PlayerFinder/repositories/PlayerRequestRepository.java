package com.example.PlayerFinder.repositories;

import com.example.PlayerFinder.Enums.Category;
import com.example.PlayerFinder.Enums.Position;
import com.example.PlayerFinder.models.PlayerRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRequestRepository extends JpaRepository<PlayerRequest, Long> {

    @Query("""
                SELECT p FROM PlayerRequest p
                WHERE
                    (:position IS NULL OR p.position = :position)
                AND
                    (:category IS NULL OR p.category = :category)
                AND
                    (:city IS NULL OR
                        LOWER(p.team.city) LIKE LOWER(CONCAT('%', :city, '%')))
                AND
                    (:minAge IS NULL OR p.minAge >= :minAge)
                AND
                    (:maxAge IS NULL OR p.maxAge <= :maxAge)
            """)
    Page<PlayerRequest> searchPlayerRequests(
            @Param("position") Position position,
            @Param("category") Category category,
            @Param("city") String city,
            @Param("minAge") Integer minAge,
            @Param("maxAge") Integer maxAge,
            Pageable pageable
    );
}
