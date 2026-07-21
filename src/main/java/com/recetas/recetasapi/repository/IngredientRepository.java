package com.recetas.recetasapi.repository;

import com.recetas.recetasapi.entity.Ingredient;
import com.recetas.recetasapi.repository.base.BaseRepository;

import java.util.List;

public interface IngredientRepository extends BaseRepository<Ingredient, Long> {

    List<Ingredient> findByRecipeId(Long recipeId);
    List<Ingredient> findByNameContainingIgnoreCase(String name);

}
