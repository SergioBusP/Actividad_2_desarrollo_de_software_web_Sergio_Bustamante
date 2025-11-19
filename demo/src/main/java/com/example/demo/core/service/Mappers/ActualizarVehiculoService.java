package com.core.service.Mappers;

import com.core.port.in.ActualizarVehiculoUseCase;
import com.core.port.out.VehiculoRepositoryPort;
import com.core.domain.entity.Vehiculo;

import java.util.UUID;

import org.springframework.stereotype.Service;

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
