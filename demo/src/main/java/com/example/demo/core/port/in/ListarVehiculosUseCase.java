package com.core.port.in;

import com.core.domain.entity.Vehiculo;
import java.util.List;

public interface ListarVehiculosUseCase {
    List<Vehiculo> ejecutar();
}