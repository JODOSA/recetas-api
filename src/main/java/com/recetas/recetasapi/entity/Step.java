package com.recetas.recetasapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "steps")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El número de paso no puede ser nulo")
    @Min(value = 1, message = "El número de paso debe ser al menos 1")
    @Column(nullable = false)
    private Integer stepNumber;

    @NotBlank(message = "La descripción del paso no puede estar vacía")
    @Size(min = 5, max = 1000, message = "La descripción debe tener entre 5 y 1000 caracteres")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Size(max = 255, message = "La URL de imagen no puede superar 255 caracteres")
    @Column(length = 255)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    @JsonBackReference
    private Recipe recipe;
}
