package com.rickandmory.backend.core.characters.service;

import com.google.gson.Gson;
import com.rickandmory.backend.client.RickAndMortyClient;
import com.rickandmory.backend.core.characters.domain.Result;
import com.rickandmory.backend.core.characters.domain.Root;
import com.rickandmory.backend.core.characters.model.Favorites;
import com.rickandmory.backend.repository.FavoritesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RickAndMortyServiceImplTest {

    @Mock
    private RickAndMortyClient rickAndMortyClient;

    @Mock
    private FavoritesRepository favoritesRepository;

    @InjectMocks
    private RickAndMortyServiceImpl rickAndMortyService;

    private Gson gson;

    @BeforeEach
    public void setUp() {
        gson = new Gson();
    }

    @Test
    public void testGetAllCharactersWhenCharactersAndFavoritesExistThenReturnJsonString() throws Exception {
        // Arrange
        Root root = new Root();
        ArrayList<Result> results = new ArrayList<>();
        Result result = new Result();
        result.id = 1;
        results.add(result);
        root.results = results;

        List<Favorites> favorites = new ArrayList<>();
        Favorites favorite = new Favorites();
        favorite.setIdCharacter("1");
        favorites.add(favorite);

        when(rickAndMortyClient.GetCharacters()).thenReturn(root);
        when(favoritesRepository.findAll()).thenReturn(favorites);

        // Act
        String actual = rickAndMortyService.getAllCharacters();

        // Assert
        String expected = gson.toJson(root.results);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAllCharactersWhenCharactersExistButNoFavoritesThenReturnJsonString() throws Exception {
        // Arrange
        Root root = new Root();
        ArrayList<Result> results = new ArrayList<>();
        Result result = new Result();
        result.id = 1;
        results.add(result);
        root.results = results;

        when(rickAndMortyClient.GetCharacters()).thenReturn(root);
        when(favoritesRepository.findAll()).thenReturn(new ArrayList<>());

        // Act
        String actual = rickAndMortyService.getAllCharacters();

        // Assert
        String expected = gson.toJson(root.results);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAllCharactersWhenNoCharactersThenReturnJsonString() throws Exception {
        // Arrange
        Root root = new Root();
        root.results = new ArrayList<>();

        when(rickAndMortyClient.GetCharacters()).thenReturn(root);
        when(favoritesRepository.findAll()).thenReturn(new ArrayList<>());

        // Act
        String actual = rickAndMortyService.getAllCharacters();

        // Assert
        String expected = gson.toJson(root.results);
        assertEquals(expected, actual);
    }
}