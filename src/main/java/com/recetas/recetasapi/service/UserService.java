package com.recetas.recetasapi.service;

import com.recetas.recetasapi.entity.User;
import com.recetas.recetasapi.service.base.BaseService;

import java.util.Optional;

public interface UserService extends BaseService<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

    boolean existByUsername(String username);
    boolean existByEmail(String email);
}
