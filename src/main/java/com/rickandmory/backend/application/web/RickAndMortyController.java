package com.rickandmory.backend.application.web;

import com.rickandmory.backend.core.characters.domain.FavoritesDTO;
import com.rickandmory.backend.core.characters.service.RickAndMortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RickAndMortyController {

    @Autowired
    private RickAndMortyService rickAndMortyServiceInterface;

    @GetMapping(value = "/characters", produces = MediaType.APPLICATION_JSON_VALUE)
    public String characters() throws Exception {
        return rickAndMortyServiceInterface.getAllCharacters();
    }

    @GetMapping(value = "/charactersByGender", produces = MediaType.APPLICATION_JSON_VALUE)
    public String charactersByGender(
            @RequestHeader("gender") String gender
    ) throws Exception {
        return rickAndMortyServiceInterface.getByGeder(gender);
    }

    @GetMapping(value = "/charactersBySpecie", produces = MediaType.APPLICATION_JSON_VALUE)
    public String charactersBySpecie(
            @RequestHeader("species") String species
    ) throws Exception {
        return rickAndMortyServiceInterface.getBySpecie(species);
    }

    @PostMapping(value = "/favorite", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> favorite(
            @RequestBody FavoritesDTO favoritesDTO
    ) throws Exception {
        try {
            rickAndMortyServiceInterface.setFavorite(favoritesDTO);
            return new ResponseEntity<>("Favorito modificado con exito", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
