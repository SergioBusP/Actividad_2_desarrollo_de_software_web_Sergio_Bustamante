package com.core.port.in;

import com.core.domain.entity.Usuario;

public interface LoginUsuarioUseCase {

    Usuario login( String email,
            String password);
}
