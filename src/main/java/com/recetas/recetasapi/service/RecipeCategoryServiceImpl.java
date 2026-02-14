package com.recetas.recetasapi.service;

import com.recetas.recetasapi.entity.RecipeCategory;
import com.recetas.recetasapi.repository.RecipeCategoryRepository;
import com.recetas.recetasapi.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RecipeCategoryServiceImpl extends BaseServiceImpl<RecipeCategory, Long> implements RecipeCategoryService {
    public RecipeCategoryServiceImpl(RecipeCategoryRepository recipeCategoryRepository) {
        super(recipeCategoryRepository);
    }
}
