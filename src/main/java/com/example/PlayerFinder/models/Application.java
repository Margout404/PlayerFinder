package com.example.PlayerFinder.models;

import com.example.PlayerFinder.Enums.ApplicationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;


/**
 * Represents a player's application to a specific PlayerRequest.
 * <p>
 * This entity connects:
 *  - a PlayerProfile
 *  - a PlayerRequest
 * <p>
 * Business rule:
 *  A player can apply only once per request
 *  (enforced via unique constraint on player_id + request_id).
 * <p>
 * Application lifecycle:
 *  - PENDING
 *  - ACCEPTED
 *  - REJECTED
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"player_id", "request_id"})
        }
)
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private PlayerProfile player;

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private PlayerRequest request;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status = ApplicationStatus.PENDING;

    private LocalDateTime createdAt = LocalDateTime.now();
}

