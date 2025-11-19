package com.example.demo.core.service.Mappers;


import org.springframework.stereotype.Service;

import com.example.demo.core.domain.entity.Usuario;
import com.example.demo.core.domain.exception.PasswordInvalidaException;
import com.example.demo.core.port.in.LoginUsuarioUseCase;
import com.example.demo.core.port.out.SessionRepositoryPort;
import com.example.demo.core.port.out.TokenServicePort;
import com.example.demo.core.port.out.UsuarioRepository;

@Service
public class LoginService implements LoginUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;
    private final TokenServicePort tokenService;
    private final SessionRepositoryPort sessionRepository;

    public LoginService(
            UsuarioRepository usuarioRepository,
            TokenServicePort tokenService,
            SessionRepositoryPort sessionRepository
    ) {
        this.usuarioRepository = usuarioRepository;
        this.tokenService = tokenService;
        this.sessionRepository = sessionRepository;
    }

    @Override
    public String login( String email,
            String password) {

        Usuario usuario = usuarioRepository.buscarPorEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!usuario.isActivo()) {
            throw new RuntimeException("El usuario está inactivo. No puede iniciar sesión.");
        }

        try {
            usuario.validarPassword(password);
        } catch (PasswordInvalidaException ex) {
            throw new RuntimeException("Credenciales inválidas.");
        }

        String token = tokenService.generarToken(usuario.getNombre().value());

        sessionRepository.crearSesion(usuario.getId().value(), token);

        return token;
    }
}
