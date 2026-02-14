package com.recetas.recetasapi.service;

import com.recetas.recetasapi.entity.Rating;
import com.recetas.recetasapi.service.base.BaseService;

import java.util.List;

public interface RatingService extends BaseService<Rating, Long> {
    List<Rating> findByRecipeId(Long recipeId);
    List<Rating> findByUserId(Long userId);

    Double calculateAverageRating(Long recipeId);
}
