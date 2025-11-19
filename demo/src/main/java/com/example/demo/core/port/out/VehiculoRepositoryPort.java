package com.example.demo.core.port.out;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.core.domain.entity.Vehiculo;


public interface VehiculoRepositoryPort {

    Vehiculo guardar(Vehiculo vehiculo);

    Optional<Vehiculo> buscarPorId(UUID id);

    Optional<Vehiculo> buscarPorPlaca(String placa);

    List<Vehiculo> listar();

    Vehiculo actualizar(Vehiculo vehiculo);

    void eliminarPorId(UUID id);
}
