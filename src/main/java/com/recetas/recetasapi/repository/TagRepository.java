package com.recetas.recetasapi.repository;

import com.recetas.recetasapi.entity.Tag;
import com.recetas.recetasapi.repository.base.BaseRepository;

import java.util.Optional;

public interface TagRepository extends BaseRepository<Tag, Long> {
    Optional<Tag> findByName(String name);
}
