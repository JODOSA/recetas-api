package com.recetas.recetasapi.service;

import com.recetas.recetasapi.entity.Rating;
import com.recetas.recetasapi.repository.RatingRepository;
import com.recetas.recetasapi.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RatingServiceImpl extends BaseServiceImpl<Rating, Long> implements RatingService {
    private final RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        super(ratingRepository);
        this.ratingRepository = ratingRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rating> findByRecipeId(Long recipeId) {
        return ratingRepository.findByRecipeId(recipeId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rating> findByUserId(Long userId){
        return ratingRepository.findByUserId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public Double calculateAverageRating(Long recipeId) {
        return ratingRepository.calculateAverageRating(recipeId);
    }
}
