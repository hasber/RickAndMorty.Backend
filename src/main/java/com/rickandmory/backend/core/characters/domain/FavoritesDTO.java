package com.rickandmory.backend.core.characters.domain;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavoritesDTO {
    private String idCharacter;
    private String name;
    private String status;
}
