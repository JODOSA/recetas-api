package com.recetas.recetasapi.controller;

import com.recetas.recetasapi.entity.Ingredient;
import com.recetas.recetasapi.service.IngredientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        List<Ingredient> ingredients = ingredientService.findAll();
        return ResponseEntity.ok(ingredients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable Long id) {
        return ingredientService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ingredient> createIngredient(@Valid @RequestBody Ingredient ingredient) {
        Ingredient savedIngredient = ingredientService.save(ingredient);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedIngredient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable Long id, @Valid @RequestBody Ingredient ingredient) {
        if (!ingredientService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ingredient.setId(id);
        Ingredient updateIngredient = ingredientService.save(ingredient);
        return ResponseEntity.ok(updateIngredient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredientById(@PathVariable Long id) {
        if (!ingredientService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ingredientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
