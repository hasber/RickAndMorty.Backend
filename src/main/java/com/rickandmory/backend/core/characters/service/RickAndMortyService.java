package com.rickandmory.backend.core.characters.service;

import com.rickandmory.backend.core.characters.domain.FavoritesDTO;

public interface RickAndMortyService {
    String getAllCharacters() throws Exception;

    String getByGeder(String gender) throws Exception;

    String getBySpecie(String specie) throws Exception;

    void setFavorite(FavoritesDTO favoritesDTO) throws Exception;

}
