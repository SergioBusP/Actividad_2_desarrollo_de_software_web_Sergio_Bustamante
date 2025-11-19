package com.example.demo.core.service.Mappers;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.core.domain.entity.Vehiculo;
import com.example.demo.core.port.in.ActualizarVehiculoUseCase;
import com.example.demo.core.port.out.VehiculoRepositoryPort;

@Service
public class ActualizarVehiculoService implements ActualizarVehiculoUseCase {

    private final VehiculoRepositoryPort repository;

    public ActualizarVehiculoService(VehiculoRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Vehiculo ejecutar(UUID id, Vehiculo nuevoVehiculo) {
        var actual = repository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Vehículo no encontrado"));

        actual.registrarKilometraje(nuevoVehiculo.getKilometraje().getValor());
        actual.cambiarCategoria(nuevoVehiculo.getCategoria());
        return repository.actualizar(actual);
    }
}
