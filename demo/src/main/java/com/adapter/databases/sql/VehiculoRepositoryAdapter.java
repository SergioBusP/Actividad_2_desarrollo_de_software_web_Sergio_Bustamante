package com.adapter.databases.sql;

import org.springframework.stereotype.Component;
import com.adapter.databases.sql.entity.*;
import com.adapter.databases.sql.mappers.*;
import com.adapter.databases.sql.repository.*;
import com.example.demo.core.domain.entity.Vehiculo;
import com.example.demo.core.port.out.VehiculoRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class VehiculoRepositoryAdapter implements VehiculoRepositoryPort {

    private final VehiculoJpaRepository repository;

    public VehiculoRepositoryAdapter(VehiculoJpaRepository repository) {
        this.repository = repository;
    }

    @SuppressWarnings("null")
    @Override
    public Vehiculo guardar(Vehiculo vehiculo) {
        VehiculoJpaEntity entity = VehiculoJpaMapper.toJpaEntity(vehiculo);
        return VehiculoJpaMapper.toDomain(repository.save(entity));
    }

    @SuppressWarnings("null")
    @Override
    public Optional<Vehiculo> buscarPorId(UUID id) {
        return repository.findById(id).map(VehiculoJpaMapper::toDomain);
    }

    @Override
    public Optional<Vehiculo> buscarPorPlaca(String placa) {
        return repository.findByPlaca(placa).map(VehiculoJpaMapper::toDomain);
    }

    @Override
    public List<Vehiculo> listar() {
        return repository.findAll().stream()
                .map(VehiculoJpaMapper::toDomain)
                .toList();
    }

    @Override
    public Vehiculo actualizar(Vehiculo vehiculo) {
        return guardar(vehiculo);
    }

    @SuppressWarnings("null")
    @Override
    public void eliminarPorId(UUID id) {
        repository.deleteById(id);
    }
}
