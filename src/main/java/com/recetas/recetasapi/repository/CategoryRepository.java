package com.recetas.recetasapi.repository;

import com.recetas.recetasapi.repository.base.BaseRepository;
import com.recetas.recetasapi.entity.Category;

import java.util.Optional;


public interface CategoryRepository extends BaseRepository<Category, Long> {
    Optional<Category> findBySlug(String slug);
    boolean existsBySlug(String slug);
}
