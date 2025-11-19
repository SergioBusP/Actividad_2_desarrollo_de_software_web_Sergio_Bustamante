package com.core.service.Mappers;


import com.core.port.in.EliminarVehiculoUseCase;
import com.core.port.out.VehiculoRepositoryPort;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class EliminarVehiculoService implements EliminarVehiculoUseCase {

    private final VehiculoRepositoryPort repository;

    public EliminarVehiculoService(VehiculoRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public void ejecutar(UUID id) {
        repository.eliminarPorId(id);
    }
}
