package com.example.PlayerFinder.models;

import com.example.PlayerFinder.Enums.InviteStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;


/**
 * Represents an invitation sent from a TeamProfile to a PlayerProfile.
 *
 * This enables two-way recruitment interaction.
 *
 * Business rule:
 *  A team can invite a player only once
 *  (unique constraint on team_id + player_id).
 *
 * Invite lifecycle:
 *  - PENDING
 *  - ACCEPTED
 *  - REJECTED
 *  - CANCELLED
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"team_id", "player_id"})
        }
)
public class PlayerInvite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private TeamProfile team;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private PlayerProfile player;

    @Enumerated(EnumType.STRING)
    @Column(
            nullable = false
    )
    private InviteStatus status = InviteStatus.PENDING;

    private LocalDateTime createdAt = LocalDateTime.now();
}
