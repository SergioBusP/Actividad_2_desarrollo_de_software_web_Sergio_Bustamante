package com.adapter.rest.controller;

import com.adapter.rest.dto.UsuarioDto;
import com.adapter.rest.dto.UsuarioRegistroRequest;
import com.adapter.rest.dto.LoginRequest;
import com.adapter.rest.mapper.UsuarioRestMapper;
import com.core.port.in.ActualizarUsuarioUseCase;
import com.core.port.in.EliminarUsuarioUseCase;
import com.core.port.in.ListarUsuariosUseCase;
import com.core.port.in.LoginUsuarioUseCase;
import com.core.port.in.ObtenerUsuarioUseCase;
import com.core.port.in.RegistrarUsuarioUseCase;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final RegistrarUsuarioUseCase registrarUsuario;
    private final ObtenerUsuarioUseCase obtenerUsuario;
    private final LoginUsuarioUseCase loginUsuario;
    private final ListarUsuariosUseCase listarUsuarios;
    private final ActualizarUsuarioUseCase actualizarUsuario;
    private final EliminarUsuarioUseCase eliminarUsuario;

    public UsuarioController(
            RegistrarUsuarioUseCase registrarUsuario,
            ObtenerUsuarioUseCase obtenerUsuario,
            LoginUsuarioUseCase loginUsuario,
            ListarUsuariosUseCase listarUsuarios,
            ActualizarUsuarioUseCase actualizarUsuario,
            EliminarUsuarioUseCase eliminarUsuario) {
        this.registrarUsuario = registrarUsuario;
        this.obtenerUsuario = obtenerUsuario;
        this.loginUsuario = loginUsuario;
        this.listarUsuarios = listarUsuarios;
        this.actualizarUsuario = actualizarUsuario;
        this.eliminarUsuario = eliminarUsuario;
    }

    @PostMapping("/registrar")
    public ResponseEntity<UsuarioDto> registrar(@RequestBody UsuarioRegistroRequest request) {
        var usuario = registrarUsuario.registrar(request.getNombre(), request.getEmail(), request.getPassword());
        return ResponseEntity.ok(UsuarioRestMapper.toDto(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        var token = loginUsuario.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(token);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(UsuarioRestMapper.toDto(obtenerUsuario.obtener(id)));
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(
                listarUsuarios.listar().stream().map(UsuarioRestMapper::toDto).toList()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> actualizar(
            @PathVariable Long id,
            @RequestBody UsuarioRegistroRequest request
    ) {
        var usuario = actualizarUsuario.actualizar(id, request.getNombre(), request.getEmail());
        return ResponseEntity.ok(UsuarioRestMapper.toDto(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        eliminarUsuario.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
