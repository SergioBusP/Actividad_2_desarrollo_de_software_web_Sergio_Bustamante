package com.core.service.Mappers;

import com.core.port.in.ObtenerVehiculoUseCase;
import com.core.port.out.VehiculoRepositoryPort;
import com.core.domain.entity.Vehiculo;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ObtenerVehiculoService implements ObtenerVehiculoUseCase {

    private final VehiculoRepositoryPort repository;

    public ObtenerVehiculoService(VehiculoRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Vehiculo ejecutar(UUID id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Vehículo no encontrado"));
    }
}

