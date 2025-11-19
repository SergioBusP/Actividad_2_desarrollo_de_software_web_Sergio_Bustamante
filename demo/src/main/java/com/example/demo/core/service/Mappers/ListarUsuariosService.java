package com.example.demo.core.service.Mappers;

import org.springframework.stereotype.Service;

import com.example.demo.core.domain.entity.Usuario;
import com.example.demo.core.port.in.ListarUsuariosUseCase;
import com.example.demo.core.port.out.UsuarioRepository;

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
