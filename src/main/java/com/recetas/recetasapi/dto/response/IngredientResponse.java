package com.recetas.recetasapi.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientResponse {

    private Long id;
    private String name;
    private String quantity;
    private Long recipeId;
}
