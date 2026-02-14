package com.recetas.recetasapi.repository;

import com.recetas.recetasapi.entity.Rating;
import com.recetas.recetasapi.entity.User;
import com.recetas.recetasapi.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingRepository extends BaseRepository<Rating, Long> {
    List<Rating> findByRecipeId(Long recipeId);
    List<Rating> findByUserId(Long userId);

    @Query("SELECT AVG(r.stars) FROM Rating r WHERE r.recipe.id = :recipeId")
    Double calculateAverageRating(@Param("recipeId") Long recipeId);
    
}
