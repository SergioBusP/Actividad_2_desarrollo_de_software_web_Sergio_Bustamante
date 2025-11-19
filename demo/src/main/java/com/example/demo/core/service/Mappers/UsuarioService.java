package com.core.service.Mappers;

import com.core.port.in.*;
import com.core.domain.entity.Usuario;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final RegistrarUsuarioUseCase registrarUsuarioUseCase;
    private final ActualizarUsuarioUseCase actualizarUsuarioUseCase;
    private final ObtenerUsuarioUseCase obtenerUsuarioUseCase;
    private final EliminarUsuarioUseCase eliminarUsuarioUseCase;
    private final ListarUsuariosUseCase listarUsuariosUseCase;

    public UsuarioService(
            RegistrarUsuarioUseCase registrarUsuarioUseCase,
            ActualizarUsuarioUseCase actualizarUsuarioUseCase,
            ObtenerUsuarioUseCase obtenerUsuarioUseCase,
            EliminarUsuarioUseCase eliminarUsuarioUseCase,
            ListarUsuariosUseCase listarUsuariosUseCase
    ) {
        this.registrarUsuarioUseCase = registrarUsuarioUseCase;
        this.actualizarUsuarioUseCase = actualizarUsuarioUseCase;
        this.obtenerUsuarioUseCase = obtenerUsuarioUseCase;
        this.eliminarUsuarioUseCase = eliminarUsuarioUseCase;
        this.listarUsuariosUseCase = listarUsuariosUseCase;
    }

    // -------------------------------------
    // CRUD
    // -------------------------------------

    public Usuario crearUsuario(String nombre, String email, String password) {
        return registrarUsuarioUseCase.crearNuevo(nombre, email, password);
    }

    public Usuario actualizarUsuario(Long id, String nombre, String email) {
        return actualizarUsuarioUseCase.actualizar(id, nombre, email);
    }

    public Usuario obtenerPorId(Long id) {
        return obtenerUsuarioUseCase.obtener(id);
    }

    public void eliminarUsuario(Long id) {
        eliminarUsuarioUseCase.eliminar(id);
    }

    public List<Usuario> listarUsuarios() {
        return listarUsuariosUseCase.listar();
    }
}