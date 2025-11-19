package com.example.demo.adapter.databases.sql.repository;

import com.example.demo.core.port.out.EliminarUsuarioRepositoryPort;
import org.springframework.stereotype.Repository;

@Repository
public class EliminarUsuarioRepositoryAdapter implements EliminarUsuarioRepositoryPort {

    private final UsuarioJpaRepository jpaRepository;

    public EliminarUsuarioRepositoryAdapter(UsuarioJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @SuppressWarnings("null")
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}