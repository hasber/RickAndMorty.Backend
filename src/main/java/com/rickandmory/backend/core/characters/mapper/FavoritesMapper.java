package com.rickandmory.backend.core.characters.mapper;

import com.rickandmory.backend.core.characters.domain.FavoritesDTO;
import com.rickandmory.backend.core.characters.model.Favorites;
import org.springframework.stereotype.Component;

@Component
public class FavoritesMapper {

    public Favorites  dtoToEntity(FavoritesDTO favoritesDTO) {
        return Favorites.builder()
                .idCharacter(favoritesDTO.getIdCharacter())
                .name(favoritesDTO.getName())
                .status(favoritesDTO.getStatus())
                .build();
    }

    public FavoritesDTO entityToDto(Favorites favorites ) {
        return FavoritesDTO.builder()
                .idCharacter(favorites.getIdCharacter())
                .name(favorites.getName())
                .status(favorites.getStatus())
                .build();
    }
}
