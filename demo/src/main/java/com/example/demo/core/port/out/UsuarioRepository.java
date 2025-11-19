package com.example.demo.core.port.out;

import java.util.List;
import java.util.Optional;

import com.example.demo.core.domain.entity.Usuario;

public interface UsuarioRepository {

    Usuario guardar(Usuario usuario);

    Optional<Usuario> buscarPorId(Long id);

    Optional<Usuario> buscarPorEmail(String email);

    List<Usuario> listar();

    void eliminar(Long id);
}
