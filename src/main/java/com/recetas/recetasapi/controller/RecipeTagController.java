package com.recetas.recetasapi.controller;

import com.recetas.recetasapi.entity.RecipeTag;
import com.recetas.recetasapi.service.RecipeTagService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe-tags")
public class RecipeTagController {

    private final RecipeTagService recipeTagService;

    public RecipeTagController(RecipeTagService recipeTagService) {
        this.recipeTagService = recipeTagService;
    }

    @GetMapping
    public ResponseEntity<List<RecipeTag>> getAllRecipesTag() {
        List<RecipeTag> recipeTags = recipeTagService.findAll();
        return ResponseEntity.ok(recipeTags);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeTag> getRecipeTagById(@PathVariable Long id) {
        return recipeTagService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RecipeTag> createRecipeTag(@Valid @RequestBody RecipeTag recipeTag) {
        RecipeTag saveTag = recipeTagService.save(recipeTag);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveTag);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeTag> updateRecipeTag(@PathVariable Long id, @Valid @RequestBody RecipeTag recipeTag) {
        if (!recipeTagService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        recipeTag.setId(id);
        RecipeTag updateRecipeTag = recipeTagService.save(recipeTag);
        return ResponseEntity.ok(updateRecipeTag);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipeTag(@PathVariable Long id) {
        if (!recipeTagService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        recipeTagService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
