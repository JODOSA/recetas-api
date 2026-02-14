package com.recetas.recetasapi.service;

import com.recetas.recetasapi.entity.RecipeTag;
import com.recetas.recetasapi.repository.RecipeTagRepository;
import com.recetas.recetasapi.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RecipeTagServiceImpl extends BaseServiceImpl<RecipeTag, Long> implements RecipeTagService {
    public RecipeTagServiceImpl(RecipeTagRepository recipeTagRepository) {
        super(recipeTagRepository);
    }
}
