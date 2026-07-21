package com.recetas.recetasapi.service;

import com.recetas.recetasapi.dto.request.IngredientRequest;
import com.recetas.recetasapi.dto.response.IngredientResponse;
import com.recetas.recetasapi.entity.Ingredient;
import com.recetas.recetasapi.service.base.BaseService;

import java.util.List;

public interface IngredientService extends BaseService<Ingredient, Long> {

    List<IngredientResponse> findAllDto();
    IngredientResponse findByIdDto(Long id);
    List<IngredientResponse> findByNameDto(String name);
    List<IngredientResponse> findByRecipeIdDto(Long recipeId);
    IngredientResponse createDto(IngredientRequest request);
    IngredientResponse updateDto(Long id, IngredientRequest request);
}
