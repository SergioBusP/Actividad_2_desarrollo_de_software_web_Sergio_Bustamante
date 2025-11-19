package com.example.demo.core.port.in;

import java.util.List;

import com.example.demo.core.domain.entity.Vehiculo;

public interface ListarVehiculosUseCase {
    List<Vehiculo> ejecutar();
}