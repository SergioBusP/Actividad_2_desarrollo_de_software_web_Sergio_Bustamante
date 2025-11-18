package com.core.port.in;

import java.util.UUID;

import com.core.domain.entity.Vehiculo;

public interface ObtenerVehiculoUseCase {
    Vehiculo ejecutar(UUID id);
}
