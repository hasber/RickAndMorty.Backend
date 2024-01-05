package com.rickandmory.backend.repository;

import com.rickandmory.backend.core.characters.model.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
    boolean existsByIdCharacter(String idCharacter);
    Favorites findByIdCharacter(String idCharacter);
}
