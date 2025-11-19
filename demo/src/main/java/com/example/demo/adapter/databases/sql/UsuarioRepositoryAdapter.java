package com.example.demo.adapter.databases.sql;

import com.example.demo.adapter.databases.sql.entity.UsuarioJpaEntity;
import com.example.demo.adapter.databases.sql.mappers.UsuarioJpaMapper;
import com.example.demo.adapter.databases.sql.repository.UsuarioJpaRepository;
import com.example.demo.core.domain.entity.Usuario;
import com.example.demo.core.port.out.UsuarioRepository;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UsuarioRepositoryAdapter implements UsuarioRepository {

    private final UsuarioJpaRepository repository;

    public UsuarioRepositoryAdapter(UsuarioJpaRepository repository) {
        this.repository = repository;
    }

    @SuppressWarnings("null")
    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioJpaEntity entity = UsuarioJpaMapper.toEntity(usuario);
        return UsuarioJpaMapper.toDomain(repository.save(entity));
    }

    @SuppressWarnings("null")
    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return repository.findById(id)
                .map(UsuarioJpaMapper::toDomain);
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        return repository.findByEmail(email)
                .map(UsuarioJpaMapper::toDomain);
    }

    @Override
    public List<Usuario> listar() {
        return repository.findAll().stream()
                .map(UsuarioJpaMapper::toDomain)
                .toList();
    }

    @SuppressWarnings("null")
    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
