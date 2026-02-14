package com.recetas.recetasapi.service;

import com.recetas.recetasapi.entity.Step;
import com.recetas.recetasapi.repository.StepRepository;
import com.recetas.recetasapi.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class StepServiceImpl extends BaseServiceImpl<Step, Long> implements StepService {
    public StepServiceImpl(StepRepository stepRepository) {
        super(stepRepository);
    }
}
