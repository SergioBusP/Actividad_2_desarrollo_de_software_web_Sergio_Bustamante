package com.core.service.Mappers;

import com.core.port.in.ActualizarUsuarioUseCase;
import com.core.port.out.UsuarioRepository;
import com.core.domain.entity.Usuario;
import org.springframework.stereotype.Service;

@Service
public class ActualizarUsuarioService implements ActualizarUsuarioUseCase {

    private final UsuarioRepository repository;

    public ActualizarUsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario actualizar(Long id,
            String nuevoNombre,
            String nuevoEmail) {

        Usuario usuario = repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (nuevoNombre != null)
            usuario.actualizarNombre(nuevoNombre);

        if (nuevoEmail != null)
            usuario.actualizarEmail(nuevoEmail);

        repository.guardar(usuario);

        return usuario;
    }
}
