package com.core.port.in;

import com.core.domain.entity.Usuario;
import com.core.domain.exception.CredencialesInvalidasException;
import com.core.port.out.UsuarioRepository;
import com.core.domain.service.PasswordHasher;
import com.core.port.out.TokenServicePort;

public class LoginUsuarioUseCase {

    private final UsuarioRepository repository;
    private final PasswordHasher hasher;
    private final TokenServicePort tokenGenerator;

    public LoginUsuarioUseCase(
            UsuarioRepository repository,
            PasswordHasher hasher,
            TokenServicePort tokenGenerator) {
        this.repository = repository;
        this.hasher = hasher;
        this.tokenGenerator = tokenGenerator;
    }

    public String login(String email, String password) {

        Usuario usuario = repository.buscarPorEmail(email)
                .orElseThrow(CredencialesInvalidasException::new);

        if (!hasher.verify(password, usuario.getPasswordHash().value())) {
            throw new CredencialesInvalidasException();
        }

        return tokenGenerator.generarToken(usuario.getId().value());
    }
}
