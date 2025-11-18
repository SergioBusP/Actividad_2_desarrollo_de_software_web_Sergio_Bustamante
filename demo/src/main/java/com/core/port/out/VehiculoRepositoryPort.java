package com.core.port.out;


import com.core.domain.entity.Vehiculo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface VehiculoRepositoryPort {

    Vehiculo guardar(Vehiculo vehiculo);

    Optional<Vehiculo> buscarPorId(UUID id);

    Optional<Vehiculo> buscarPorPlaca(String placa);

    List<Vehiculo> listar();

    Vehiculo actualizar(Vehiculo vehiculo);

    void eliminarPorId(UUID id);
}
