package com.recetas.recetasapi.service;

import com.recetas.recetasapi.entity.Category;
import com.recetas.recetasapi.service.base.BaseService;

import java.util.Optional;

public interface CategoryService extends BaseService<Category, Long> {
    Optional<Category> findBySlug(String slug);
    boolean existsBySlug(String slug);
}
