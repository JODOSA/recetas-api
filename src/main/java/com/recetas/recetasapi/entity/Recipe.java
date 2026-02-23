package com.recetas.recetasapi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.recetas.recetasapi.enums.Difficulty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import com.recetas.recetasapi.entity.Rating;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="recetas")

public class Recipe {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la receta no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min = 10, max = 2000, message = "La descripción debe tener entre 10 y 2000 caracteres")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @NotNull(message = "El tiempo de preparación no puede ser nulo")
    @Min(value = 1, message = "El tiempo de preparación debe ser al menos 1 minuto")
    @Column(nullable = false)
    private Integer preparationTime;

    @NotNull(message = "El tiempo de cocinado no puede ser nulo")
    @Min(value = 0, message = "El tiempo de cocinado no puede ser negativo")
    @Column(nullable = false)
    private Integer cookingTime;

    @NotNull(message = "El número de porciones no puede ser nulo")
    @Min(value = 1, message = "Debe haber al menos 1 porción")
    @Max(value = 100, message = "No puede superar las 100 porciones")
    @Column(nullable = false)
    private Integer servings;

    @NotNull(message = "La dificultad no puede ser nula")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Difficulty difficulty;

    @NotNull(message = "El campo Publico no puede ser nulo")
    @Column(nullable = false)
    private Boolean isPublic = true;

    @Size(max = 255, message = "La URL de imagen no puede superar 255 caracteres")
    @Column(length = 255)
    private String imageUrl;


    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Ingredient> ingredients = new ArrayList<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Step> steps = new ArrayList<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Favorite> favorites = new ArrayList<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rating> ratings = new ArrayList<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeCategory> recipeCategories = new ArrayList<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeTag> recipeTags = new ArrayList<>();

}
