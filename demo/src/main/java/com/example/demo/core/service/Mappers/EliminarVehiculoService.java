package com.example.demo.core.service.Mappers;


import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.core.port.in.EliminarVehiculoUseCase;
import com.example.demo.core.port.out.VehiculoRepositoryPort;

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
