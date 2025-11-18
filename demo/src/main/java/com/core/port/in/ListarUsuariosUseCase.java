package com.core.port.in;

import com.core.domain.entity.Usuario;
import com.core.port.out.UsuarioRepository;

import java.util.List;

public class ListarUsuariosUseCase {

    private final UsuarioRepository repository;

    public ListarUsuariosUseCase(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listar() {
        return repository.listar();
    }
}
