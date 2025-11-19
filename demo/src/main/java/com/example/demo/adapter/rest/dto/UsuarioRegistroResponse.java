package com.example.demo.adapter.rest.dto;


import java.time.Instant;

public record UsuarioRegistroResponse(
        Long id,
        String nombre,
        String email,
        boolean activo,
        Instant fechaCreacion,
        Instant fechaActualizacion
) {}