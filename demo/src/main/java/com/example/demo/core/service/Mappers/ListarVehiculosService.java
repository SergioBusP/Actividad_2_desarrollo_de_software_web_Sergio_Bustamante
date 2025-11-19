package com.core.service.Mappers;

import com.core.port.in.ListarVehiculosUseCase;
import com.core.port.out.VehiculoRepositoryPort;
import com.core.domain.entity.Vehiculo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarVehiculosService implements ListarVehiculosUseCase {

    private final VehiculoRepositoryPort repository;

    public ListarVehiculosService(VehiculoRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<Vehiculo> ejecutar() {
        return repository.listar();
    }
}