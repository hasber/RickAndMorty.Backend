package com.rickandmory.backend.core.characters.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "favorites")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idCharacter", nullable = false)
    private String idCharacter;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "status", nullable = false)
    private String status;

}
