package com.recetas.recetasapi.repository;

import com.recetas.recetasapi.entity.User;
import com.recetas.recetasapi.repository.base.BaseRepository;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
