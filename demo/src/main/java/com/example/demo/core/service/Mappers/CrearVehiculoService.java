package com.example.demo.core.service.Mappers;


import org.springframework.stereotype.Service;

import com.example.demo.core.domain.entity.Vehiculo;
import com.example.demo.core.port.in.CrearVehiculoUseCase;
import com.example.demo.core.port.out.VehiculoRepositoryPort;

@Service
public class CrearVehiculoService implements CrearVehiculoUseCase {

    private final VehiculoRepositoryPort repository;

    public CrearVehiculoService(VehiculoRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Vehiculo ejecutar(Vehiculo vehiculo) {
        return repository.guardar(vehiculo);
    }
}
