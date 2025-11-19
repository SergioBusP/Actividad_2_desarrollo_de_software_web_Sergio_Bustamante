package com.example.demo.core.service.Mappers;

import org.springframework.stereotype.Service;

import com.example.demo.core.domain.entity.Vehiculo;
import com.example.demo.core.port.in.ListarVehiculosUseCase;
import com.example.demo.core.port.out.VehiculoRepositoryPort;

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