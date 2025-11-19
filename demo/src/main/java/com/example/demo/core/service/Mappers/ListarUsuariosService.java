package com.core.service.Mappers;

import com.core.port.in.ListarUsuariosUseCase;
import com.core.port.out.UsuarioRepository;
import com.core.domain.entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarUsuariosService implements ListarUsuariosUseCase {

    private final UsuarioRepository repository;

    public ListarUsuariosService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Usuario> listar() {
        return repository.listar();
    }
}
