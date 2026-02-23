package com.recetas.recetasapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recipe_tags", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"recipe_id", "tag_id"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La receta no puede ser nula")
    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

    @NotNull(message = "El tag no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;
}
