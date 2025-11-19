package com.core.service.Mappers;


import com.core.port.in.CrearVehiculoUseCase;
import com.core.port.out.VehiculoRepositoryPort;
import com.core.domain.entity.Vehiculo;
import org.springframework.stereotype.Service;

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
