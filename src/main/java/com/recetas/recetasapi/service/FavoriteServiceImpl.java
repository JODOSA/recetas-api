package com.recetas.recetasapi.service;

import com.recetas.recetasapi.entity.Favorite;
import com.recetas.recetasapi.repository.FavoriteRepository;
import com.recetas.recetasapi.service.base.BaseServiceImpl;

public class FavoriteServiceImpl extends BaseServiceImpl<Favorite, Long> implements FavoriteService {
    public FavoriteServiceImpl(FavoriteRepository favoriteRepository) {
        super(favoriteRepository);
    }
}
