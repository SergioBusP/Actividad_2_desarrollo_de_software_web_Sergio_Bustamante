package com.example.demo.core.port.in;

import com.example.demo.core.domain.entity.Usuario;

public interface ActualizarUsuarioUseCase {

    Usuario actualizar(Long id,
            String nuevoNombre,
            String nuevoEmail);
}