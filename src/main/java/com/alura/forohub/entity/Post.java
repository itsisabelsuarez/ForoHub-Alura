package com.alura.forohub.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @Lob
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}

