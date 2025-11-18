package com.core.port.in;

import com.core.domain.exception.UsuarioNoEncontradoException;
import com.core.port.out.UsuarioRepository;

public class EliminarUsuarioUseCase {

    private final UsuarioRepository repository;

    public EliminarUsuarioUseCase(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void eliminar(Long id) {
        repository.buscarPorId(id)
                .orElseThrow(() -> new UsuarioNoEncontradoException());

        repository.eliminar(id);
    }
}
