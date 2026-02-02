package com.recetas.recetasapi.service;

import com.recetas.recetasapi.entity.Recipe;
import com.recetas.recetasapi.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public List<Recipe> getAllRecipes(){
        return recipeRepository.findAll();
    }

    public Optional<Recipe> getRecipeById(Long id){
        return recipeRepository.findById(id);
    }

    public Recipe createRecipe(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(Long id, Recipe recipeDetails){
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found with id: " + id));

        recipe.setName(recipeDetails.getName());
        recipe.setDescription(recipeDetails.getDescription());
        recipe.setPreparationTime(recipeDetails.getPreparationTime());
        recipe.setCookingTime(recipeDetails.getCookingTime());
        recipe.setServings(recipeDetails.getServings());

        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long id){
        recipeRepository.deleteById(id);
    }
}
