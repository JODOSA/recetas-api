package com.recetas.recetasapi.repository;

import com.recetas.recetasapi.entity.Recipe;
import com.recetas.recetasapi.enums.Difficulty;
import com.recetas.recetasapi.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RecipeRepository extends BaseRepository<Recipe,Long> {
    List<Recipe> findByDifficulty(Difficulty difficulty);
    List<Recipe> findByAuthorId(Long authorId);
    List<Recipe> findByIsPublic(Boolean isPublic);
}
