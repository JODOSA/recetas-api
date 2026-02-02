package com.recetas.recetasapi.repository;

import com.recetas.recetasapi.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long>{
    
}
