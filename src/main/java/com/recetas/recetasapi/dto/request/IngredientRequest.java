package com.recetas.recetasapi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientRequest {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puedo superar 100 caracteres")
    private String name;

    @NotBlank(message = "La cantidad es obligatoria")
    @Size(max = 50, message = "La cantidad no puede superar 50 caracteres")
    private String quantity;

    @NotNull(message = "La receta es obligatoria")
    private Long recipeId;
}
