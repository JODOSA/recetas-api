package com.recetas.recetasapi.service;

import com.recetas.recetasapi.entity.Tag;
import com.recetas.recetasapi.repository.TagRepository;
import com.recetas.recetasapi.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TagServiceImpl extends BaseServiceImpl<Tag, Long> implements TagService {
    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        super(tagRepository);
        this.tagRepository = tagRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Tag> findByName(String name) {
        return tagRepository.findByName(name);
    }
}
