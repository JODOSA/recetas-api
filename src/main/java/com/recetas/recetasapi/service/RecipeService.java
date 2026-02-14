package com.recetas.recetasapi.service;

import com.recetas.recetasapi.entity.Recipe;
import com.recetas.recetasapi.enums.Difficulty;
import com.recetas.recetasapi.service.base.BaseService;

import java.util.List;
import java.util.Optional;

public interface RecipeService extends BaseService<Recipe, Long> {

    List<Recipe> findByDifficulty(Difficulty difficulty);
    List<Recipe> findByAuthorId(Long authorId);
    List<Recipe> findByIsPublic(Boolean isPublic);
}
