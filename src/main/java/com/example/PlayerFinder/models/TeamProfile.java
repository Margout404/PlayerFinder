package com.example.PlayerFinder.models;

import com.example.PlayerFinder.Enums.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TeamProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    private String teamName;

    private String city;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String division;

    private String homeGround;

    @Column(length = 500)
    private String description;

}
