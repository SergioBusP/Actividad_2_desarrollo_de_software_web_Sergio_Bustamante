package com.example.demo.core.port.in;

import java.util.UUID;

import com.example.demo.core.domain.entity.Vehiculo;

public interface ActualizarVehiculoUseCase {
    Vehiculo ejecutar(UUID id, Vehiculo vehiculo);
}
