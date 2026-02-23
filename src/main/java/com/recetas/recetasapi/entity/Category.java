package com.recetas.recetasapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la categoría no puede estar vacío")
    @Size(max = 50, message = "El nombre no puede superar 50 caracteres")
    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Size(max = 255, message = "La descripción no puede superar los 255 caracteres")
    @Column(columnDefinition = "TEXT")
    private String description;

    @NotBlank(message = "El slug no puede estar vacío")
    @Size(max = 50, message = "El slug no puede superar 50 caracteres")
    @Column(nullable = false, unique = true, length = 50)
    private String slug;
}
