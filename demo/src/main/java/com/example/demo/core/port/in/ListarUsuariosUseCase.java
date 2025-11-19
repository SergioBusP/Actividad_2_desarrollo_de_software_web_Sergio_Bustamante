package com.example.demo.core.port.in;

import java.util.List;

import com.example.demo.core.domain.entity.Usuario;

public interface ListarUsuariosUseCase {

    List<Usuario> listar();
}
