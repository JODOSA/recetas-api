package com.recetas.recetasapi.controller;

import com.recetas.recetasapi.entity.Recipe;
import com.recetas.recetasapi.enums.Difficulty;
import com.recetas.recetasapi.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> recipes = recipeService.findAll();
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        return recipeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe savedRecipe = recipeService.save(recipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRecipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        if (!recipeService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        recipe.setId(id);
        Recipe updateRecipe = recipeService.save(recipe);
        return ResponseEntity.ok(updateRecipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipeById(@PathVariable Long id) {
        if (!recipeService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        recipeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/difficulty/{difficulty}")
    public ResponseEntity<List<Recipe>> getRecipeByDifficulty(@PathVariable Difficulty difficulty) {
        List<Recipe> recipes = recipeService.findByDifficulty(difficulty);
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<Recipe>> getRecipeByAuthorId(@PathVariable Long authorId) {
        List<Recipe> recipes = recipeService.findByAuthorId(authorId);
        return ResponseEntity.ok(recipes);
    }
    
    @GetMapping("/public/{isPublic}")
    public ResponseEntity<List<Recipe>> getRecipeIsPublic(@PathVariable Boolean isPublic) {
        List<Recipe> recipes = recipeService.findByIsPublic(isPublic);
        return ResponseEntity.ok(recipes);
    }
}
