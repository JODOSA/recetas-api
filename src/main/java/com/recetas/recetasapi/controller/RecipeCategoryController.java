package com.recetas.recetasapi.controller;

import com.recetas.recetasapi.entity.RecipeCategory;
import com.recetas.recetasapi.service.RecipeCategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe-categories")
public class RecipeCategoryController {

    private final RecipeCategoryService recipeCategoryService;

    public RecipeCategoryController(RecipeCategoryService recipeCategoryService) {
        this.recipeCategoryService = recipeCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<RecipeCategory>> getAllRecipesByCategory() {
        List<RecipeCategory> recipeCategories = recipeCategoryService.findAll();
        return ResponseEntity.ok(recipeCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeCategory> getRecipeByCategoryId(@PathVariable Long id) {
        return recipeCategoryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RecipeCategory> createRecipeCategory(@Valid @RequestBody RecipeCategory recipeCategory) {
        RecipeCategory saveCategory = recipeCategoryService.save(recipeCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeCategory> updateRecipeCategory(@PathVariable Long id, @Valid @RequestBody RecipeCategory recipeCategory) {
        if (!recipeCategoryService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        recipeCategory.setId(id);
        RecipeCategory updateRecipeCategory = recipeCategoryService.save(recipeCategory);
        return ResponseEntity.ok(updateRecipeCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipeByCategory(@PathVariable Long id) {
        if (!recipeCategoryService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        recipeCategoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
