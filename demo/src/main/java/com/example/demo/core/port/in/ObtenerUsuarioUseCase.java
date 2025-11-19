package com.example.demo.core.port.in;

import com.example.demo.core.domain.entity.Usuario;

public interface ObtenerUsuarioUseCase {

    Usuario obtener(Long id);
}
