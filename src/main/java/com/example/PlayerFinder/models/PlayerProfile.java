package com.example.PlayerFinder.models;

import com.example.PlayerFinder.Enums.Availability;
import com.example.PlayerFinder.Enums.Category;
import com.example.PlayerFinder.Enums.Position;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fName;
    private String lName;
    private Integer ageInYears;
    private String city;

    @Enumerated(EnumType.STRING)
    private Position primaryPosition;

    @ElementCollection(targetClass = Position.class)
    @CollectionTable(
            name = "player_secondary_positions",
            joinColumns = @JoinColumn(name = "player_id")
    )
    @Column(name = "position", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Position> secondaryPositions = new HashSet<>();

    @ElementCollection(targetClass = Category.class)
    @CollectionTable(
            name = "player_preferred_categories",
            joinColumns = @JoinColumn(name = "player_id")
    )
    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Category> preferredCategories = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Availability availability;

    @Column(length = 500)
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;
}

