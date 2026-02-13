package com.recetas.recetasapi.service;

import com.recetas.recetasapi.entity.Tag;
import com.recetas.recetasapi.service.base.BaseService;

import java.util.Optional;

public interface TagService extends BaseService<Tag, Long> {
    Optional<Tag> findByName(String name);
}
