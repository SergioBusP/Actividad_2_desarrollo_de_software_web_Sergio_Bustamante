package com.core.port.in;

import com.core.domain.entity.Vehiculo;
import java.util.UUID;

public interface ActualizarVehiculoUseCase {
    Vehiculo ejecutar(UUID id, Vehiculo vehiculo);
}
