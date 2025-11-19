package com.example.demo.core.port.in;

import com.example.demo.core.domain.entity.Usuario;

public interface RegistrarUsuarioUseCase {

    Usuario crearNuevo(String nombre,
            String email,
            String plainPassword);
}