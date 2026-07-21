package com.recetas.recetasapi.service;

import com.recetas.recetasapi.entity.Ingredient;
import com.recetas.recetasapi.entity.Recipe;
import com.recetas.recetasapi.repository.IngredientRepository;
import com.recetas.recetasapi.service.base.BaseServiceImpl;
import com.recetas.recetasapi.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.recetas.recetasapi.repository.RecipeRepository;
import com.recetas.recetasapi.dto.response.IngredientResponse;
import com.recetas.recetasapi.dto.request.IngredientRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl extends BaseServiceImpl<Ingredient, Long> implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository, RecipeRepository recipeRepository) {

        super(ingredientRepository);
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
    }

    private IngredientResponse toResponse(Ingredient ingredient){
        IngredientResponse response = new IngredientResponse();
        response.setId(ingredient.getId());
        response.setName(ingredient.getName());
        response.setQuantity(ingredient.getQuantity());
        response.setRecipeId(ingredient.getRecipe().getId());  // Clave 3
        return response;
    }

    private Ingredient toEntity(IngredientRequest request){
        Recipe recipe = recipeRepository.findById(request.getRecipeId())
                .orElseThrow(() -> new ResourceNotFoundException("No existe una receta con el id: "
                + request.getRecipeId()));

        Ingredient ingredient = new Ingredient();
        ingredient.setName(request.getName());
        ingredient.setQuantity(request.getQuantity());
        ingredient.setRecipe(recipe);
        return ingredient;
    }

    @Override
    @Transactional(readOnly = true)
    public List<IngredientResponse> findAllDto() {
        return findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public IngredientResponse findByIdDto(Long id) {
        Ingredient ingredient = findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe un ingrediente con el id: " + id));
        return toResponse(ingredient);
    }

    @Override
    @Transactional(readOnly = true)
    public List<IngredientResponse> findByNameDto(String name) {
        return ingredientRepository.findByNameContainingIgnoreCase(name).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<IngredientResponse> findByRecipeIdDto(Long recipeId) {
        return ingredientRepository.findByRecipeId(recipeId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public IngredientResponse createDto(IngredientRequest request) {
        Ingredient ingredient = toEntity(request);
        Ingredient saved = save(ingredient);
        return toResponse(saved);
    }

    @Override
    @Transactional
    public IngredientResponse updateDto(Long id, IngredientRequest request) {
        Ingredient existing = findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe un ingrediente con el id: " + id));

        Recipe recipe = recipeRepository.findById(request.getRecipeId())
                .orElseThrow(() -> new ResourceNotFoundException("No existe una receta con el id: " + request.getRecipeId()));

        existing.setName(request.getName());
        existing.setQuantity(request.getQuantity());
        existing.setRecipe(recipe);

        return toResponse(save(existing));
    }
}
