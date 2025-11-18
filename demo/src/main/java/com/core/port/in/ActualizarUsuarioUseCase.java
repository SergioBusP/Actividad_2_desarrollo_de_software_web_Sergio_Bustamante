package com.core.port.in;

import com.core.domain.entity.Usuario;

public interface ActualizarUsuarioUseCase {

    Usuario actualizar(Long id,
            String nuevoNombre,
            String nuevoEmail);
}