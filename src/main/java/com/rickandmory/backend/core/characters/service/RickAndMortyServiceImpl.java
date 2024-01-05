package com.rickandmory.backend.core.characters.service;

import com.google.gson.Gson;
import com.rickandmory.backend.client.RickAndMortyClient;
import com.rickandmory.backend.core.characters.domain.FavoritesDTO;
import com.rickandmory.backend.core.characters.mapper.FavoritesMapper;
import com.rickandmory.backend.repository.FavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RickAndMortyServiceImpl implements RickAndMortyService {

    @Autowired
    private RickAndMortyClient rickAndMortyClient;

    @Autowired
    private FavoritesRepository favoritesRepository;

    @Autowired
    private FavoritesMapper favoritesMapper;

    @Override
    public String getAllCharacters() throws Exception {
        Gson gson = new Gson();
        try {
            var data = rickAndMortyClient.GetCharacters().results;
            var favorites = favoritesRepository.findAll();
            data.stream()
                    .filter(result -> favorites.stream().anyMatch(favorite -> favorite.getIdCharacter().equals(String.valueOf(result.id))))
                    .forEach(result -> result.isFavorite = true);
            return gson.toJson(data);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public String getByGeder(String gender) throws Exception {
        Gson gson = new Gson();
        try {
            var data = rickAndMortyClient.getByGeder(gender).results;
            var favorites = favoritesRepository.findAll();
            data.stream()
                    .filter(result -> favorites.stream().anyMatch(favorite -> favorite.getIdCharacter().equals(String.valueOf(result.id))))
                    .forEach(result -> result.isFavorite = true);
            return gson.toJson(data);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public String getBySpecie(String specie) throws Exception {
        Gson gson = new Gson();
        try {
            var data = rickAndMortyClient.getBySpecie(specie).results;
            var favorites = favoritesRepository.findAll();
            data.stream()
                    .filter(result -> favorites.stream().anyMatch(favorite -> favorite.getIdCharacter().equals(String.valueOf(result.id))))
                    .forEach(result -> result.isFavorite = true);
            return gson.toJson(data);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public void setFavorite(FavoritesDTO favoritesDTO) throws Exception {
        try {
            var data = favoritesMapper.dtoToEntity(favoritesDTO);
            var exist = favoritesRepository.existsByIdCharacter(data.getIdCharacter());
            if (exist) {
                var dataExist = favoritesRepository.findByIdCharacter(data.getIdCharacter());
                favoritesRepository.delete(dataExist);
            }else {
                favoritesRepository.save(data);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
