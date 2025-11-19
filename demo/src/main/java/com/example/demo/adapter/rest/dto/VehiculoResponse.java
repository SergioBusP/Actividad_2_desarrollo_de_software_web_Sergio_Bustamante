package com.example.demo.adapter.rest.dto;

import java.util.UUID;

public record VehiculoResponse(
        UUID id,
        String placa,
        String marca,
        String modelo,
        String version,
        String color,
        Integer numPuestos,
        Integer numPuertas,
        String combustible,
        Integer kilometros,
        Integer cilindraje,
        String categoria
) { }
