package com.recetas.recetasapi.service.base;

import com.recetas.recetasapi.entity.Favorite;
import com.recetas.recetasapi.repository.FavoriteRepository;
import com.recetas.recetasapi.service.FavoriteService;

public class FavoriteServiceImpl extends BaseServiceImpl<Favorite, Long> implements FavoriteService {
    public FavoriteServiceImpl(FavoriteRepository favoriteRepository) {
        super(favoriteRepository);
    }
}
