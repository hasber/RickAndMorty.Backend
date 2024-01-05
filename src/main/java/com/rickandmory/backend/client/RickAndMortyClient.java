package com.rickandmory.backend.client;

import com.rickandmory.backend.core.characters.domain.Root;

public interface RickAndMortyClient {

     Root GetCharacters();

     Root getByGeder(String gender);

     Root getBySpecie(String specie);

}
