package com.recetas.recetasapi.controller;

import com.recetas.recetasapi.entity.Favorite;
import com.recetas.recetasapi.service.FavoriteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

@GetMapping
    public ResponseEntity<List<Favorite>> getAllFavorites() {
        List<Favorite> favorites = favoriteService.findAll();
        return ResponseEntity.ok(favorites);
}

@GetMapping("/{id}")
    public ResponseEntity<Favorite> getFavoriteById(@PathVariable Long id) {
        return favoriteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
}

@PostMapping
    public ResponseEntity<Favorite> createFavorite(@RequestBody Favorite favorite) {
        Favorite savedFavorite = favoriteService.save(favorite);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFavorite);
}

@PutMapping("/{id}")
    public ResponseEntity<Favorite> updateFavorite(@PathVariable Long id, @RequestBody Favorite favorite) {
        if (!favoriteService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        favorite.setId(id);
        Favorite updateFavorite = favoriteService.save(favorite);
        return ResponseEntity.ok(updateFavorite);
}

@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavoriteById(@PathVariable Long id) {
        if (!favoriteService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        favoriteService.deleteById(id);
        return ResponseEntity.noContent().build();
}

}
