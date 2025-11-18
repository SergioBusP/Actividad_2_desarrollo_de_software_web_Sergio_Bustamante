package com.core.port.out;

import com.core.domain.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {

    Usuario guardar(Usuario usuario);

    Optional<Usuario> buscarPorId(Long id);

    Optional<Usuario> buscarPorEmail(String email);

    List<Usuario> listar();

    void eliminar(Long id);
}
