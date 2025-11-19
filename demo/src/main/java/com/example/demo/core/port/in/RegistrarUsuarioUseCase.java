package com.core.port.in;

import com.core.domain.entity.Usuario;

public interface RegistrarUsuarioUseCase {

    Usuario crearNuevo(String nombre,
            String email,
            String plainPassword);
}