package com.recetas.recetasapi.service;

import com.recetas.recetasapi.entity.Ingredient;
import com.recetas.recetasapi.repository.IngredientRepository;
import com.recetas.recetasapi.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl extends BaseServiceImpl<Ingredient, Long> implements IngredientService {
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        super(ingredientRepository);
    }
}
