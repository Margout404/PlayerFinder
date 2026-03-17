package com.example.PlayerFinder.models;

import com.example.PlayerFinder.Enums.Category;
import com.example.PlayerFinder.Enums.Position;
import com.example.PlayerFinder.Enums.RequestStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents a recruitment request created by a TeamProfile.
 * <p>
 * A PlayerRequest acts as a job posting where a team defines:
 *  - desired position
 *  - category
 *  - age range
 * <p>
 * Players can submit Applications to an OPEN request.
 * <p>
 * Request lifecycle:
 *  - OPEN
 *  - CLOSED
 *  - CANCELLED
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PlayerRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private TeamProfile team;

    @Enumerated(EnumType.STRING)
    private Position position;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Integer minAge;
    private Integer maxAge;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestStatus status = RequestStatus.OPEN;

    private LocalDateTime createdAt = LocalDateTime.now();


}
