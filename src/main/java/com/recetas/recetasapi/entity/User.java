package com.recetas.recetasapi.entity;

import com.recetas.recetasapi.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El username no puede estar vacío")
    @Size(min = 3, max = 50, message = "El username debe tener entre 3 y 50 caracteres")
    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "Formato de email inválido")
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, message = "La contraseña debe tener mínimo 8 caracteres")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
    @Column(nullable = false, length = 50)
    private String firstName;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(max = 50, message = "El apellido no puede superar los 50 caracteres")
    @Column(nullable = false, length = 50)
    private String lastName;

    @NotNull(message = "El rol no puede ser nulo")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private UserRole role; // = UserRole.USER;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
