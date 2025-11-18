package com.core.service.Mappers;


import com.core.port.in.LoginUsuarioUseCase;
import com.core.port.out.SessionRepositoryPort;
import com.core.port.out.TokenServicePort;
import com.core.port.out.UsuarioRepository;
import com.core.domain.entity.Usuario;
import com.core.domain.exception.PasswordInvalidaException;
import org.springframework.stereotype.Service;

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
    public Usuario login( String email,
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

        String token = tokenService.generarToken(usuario.getId().value());

        sessionRepository.crearSesion(usuario.getId().value(), token);

        return usuario;
    }
}
