package com.core.port.in;

import com.core.domain.entity.Usuario;
import com.core.domain.exception.UsuarioNoEncontradoException;
import com.core.port.out.UsuarioRepository;

public class ActualizarUsuarioUseCase {

    private final UsuarioRepository repository;

    public ActualizarUsuarioUseCase(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario actualizar(Long id, String nuevoNombre, String nuevoEmail) {

        Usuario usuario = repository.buscarPorId(id)
                .orElseThrow(() -> new UsuarioNoEncontradoException());

        usuario.actualizarNombre(nuevoNombre);
        usuario.actualizarEmail(nuevoEmail);

        return repository.guardar(usuario);
    }
}