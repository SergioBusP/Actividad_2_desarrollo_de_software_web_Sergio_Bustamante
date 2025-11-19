package com.example.demo.entrypoint;

import com.example.demo.core.service.Mappers.LoginService;
import com.example.demo.core.service.Mappers.LogoutService;
import com.example.demo.core.service.Mappers.UsuarioService;
import com.example.demo.entrypoint.Dto.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final LoginService loginService;
    private final LogoutService logoutService;

    public UsuarioController(UsuarioService usuarioService, LoginService loginService, LogoutService logoutService) {
        this.usuarioService = usuarioService;
        this.loginService = loginService;
        this.logoutService = logoutService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody RegistrarUsuarioRequest request) {
        usuarioService.crearUsuario(
                request.getNombre(),
                request.getEmail(),
                request.getPassword()
        );
        return ResponseEntity.ok(new MensajeResponse("Usuario registrado correctamente"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        String token = loginService.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/logout/{id}")
    public ResponseEntity<?> logout(@PathVariable Long id) {
        logoutService.logout(id);
        return ResponseEntity.ok(new MensajeResponse("Sesión cerrada correctamente"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obtenerPorId(id));
    }
}
