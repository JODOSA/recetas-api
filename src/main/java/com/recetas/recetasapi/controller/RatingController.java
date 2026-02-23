package com.recetas.recetasapi.controller;

import com.recetas.recetasapi.entity.Rating;
import com.recetas.recetasapi.service.RatingService;
import com.recetas.recetasapi.service.RecipeService;
import com.recetas.recetasapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> ratings = ratingService.findAll();
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable Long id) {
        return ratingService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Rating> createRating(@Valid @RequestBody Rating rating) {
        Rating savedRating = ratingService.save(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRating);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rating> updateRating(@PathVariable Long id, @Valid @RequestBody Rating rating) {
        if (!ratingService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        rating.setId(id);
        Rating updateRating = ratingService.save(rating);
        return ResponseEntity.ok(updateRating);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable Long id) {
        if (!ratingService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ratingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/recipe/{recipeId}")
    public ResponseEntity<List<Rating>> getRatingsByRecipeId(@PathVariable Long recipeId) {
        List<Rating> ratings = ratingService.findByRecipeId(recipeId);
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable Long userId) {
        List<Rating> ratings = ratingService.findByUserId(userId);
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/recipe/{recipeId}/average")
    public ResponseEntity<Double> getAverageRating(@PathVariable Long recipeId) {
        Double average = ratingService.calculateAverageRating(recipeId);
        return ResponseEntity.ok(average != null ? average : 0.0);
    }
}
