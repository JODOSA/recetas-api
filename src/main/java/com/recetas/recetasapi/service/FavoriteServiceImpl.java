package com.recetas.recetasapi.service;

import com.recetas.recetasapi.entity.Favorite;
import com.recetas.recetasapi.repository.FavoriteRepository;
import com.recetas.recetasapi.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class FavoriteServiceImpl extends BaseServiceImpl<Favorite, Long> implements FavoriteService {
    public FavoriteServiceImpl(FavoriteRepository favoriteRepository) {
        super(favoriteRepository);
    }
}
