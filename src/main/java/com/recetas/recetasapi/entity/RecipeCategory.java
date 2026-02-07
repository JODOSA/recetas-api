package com.recetas.recetasapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recipe_categories", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"recipe_id", "category_id"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
