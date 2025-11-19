package com.example.demo.core.service.Mappers;

import com.example.demo.core.port.in.EliminarUsuarioUseCase;
import com.example.demo.core.port.out.EliminarUsuarioRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class EliminarUsuarioService implements EliminarUsuarioUseCase {

    private final EliminarUsuarioRepositoryPort repository;

    public EliminarUsuarioService(EliminarUsuarioRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}