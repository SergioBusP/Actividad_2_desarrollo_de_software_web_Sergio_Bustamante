package com.example.demo.core.service.Mappers;

import java.util.UUID;
import org.springframework.stereotype.Service;

import com.example.demo.core.domain.entity.Vehiculo;
import com.example.demo.core.port.in.ObtenerVehiculoUseCase;
import com.example.demo.core.port.out.VehiculoRepositoryPort;

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

