package com.core.port.in;

import com.core.domain.entity.Usuario;

public interface ObtenerUsuarioUseCase {

    Usuario obtener(Long id);
}
