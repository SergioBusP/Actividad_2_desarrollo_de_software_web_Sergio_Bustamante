package com.core.port.in;

import com.core.domain.entity.Usuario;
import com.core.domain.exception.UsuarioNoEncontradoException;
import com.core.port.out.UsuarioRepository;

public class ObtenerUsuarioUseCase {

    private final UsuarioRepository repository;

    public ObtenerUsuarioUseCase(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario obtener(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new UsuarioNoEncontradoException());
    }
}
