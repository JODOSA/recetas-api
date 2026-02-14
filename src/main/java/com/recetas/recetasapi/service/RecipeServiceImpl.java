package com.recetas.recetasapi.service;

import com.recetas.recetasapi.entity.Recipe;
import com.recetas.recetasapi.enums.Difficulty;
import com.recetas.recetasapi.repository.RecipeRepository;
import com.recetas.recetasapi.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecipeServiceImpl extends BaseServiceImpl<Recipe, Long> implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        super(recipeRepository);
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Recipe> findByDifficulty(Difficulty difficulty) {
        return recipeRepository.findByDifficulty(difficulty);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Recipe> findByAuthorId(Long authorId) {
        return recipeRepository.findByAuthorId(authorId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Recipe> findByIsPublic(Boolean isPublic) {
        return recipeRepository.findByIsPublic(isPublic);
    }
}
