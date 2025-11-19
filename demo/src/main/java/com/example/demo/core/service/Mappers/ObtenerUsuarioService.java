package com.example.demo.core.service.Mappers;

import org.springframework.stereotype.Service;

import com.example.demo.core.domain.entity.Usuario;
import com.example.demo.core.port.in.ObtenerUsuarioUseCase;
import com.example.demo.core.port.out.UsuarioRepository;

@Service
public class ObtenerUsuarioService implements ObtenerUsuarioUseCase {

    private final UsuarioRepository repository;

    public ObtenerUsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario obtener(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
