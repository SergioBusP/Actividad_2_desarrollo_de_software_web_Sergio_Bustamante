package com.core.port.in;

import com.core.domain.entity.Usuario;
import com.core.domain.entity.Usuario.UsuarioRegistradoResult;
import com.core.domain.exception.UsuarioYaExisteException;
import com.core.port.out.UsuarioRepository;
import com.core.domain.service.PasswordHasher;
import com.core.domain.service.PasswordStrengthEvaluator;
import com.core.domain.valueObject.*;

public class RegistrarUsuarioUseCase {

    private final UsuarioRepository repository;
    private final PasswordHasher hasher;
    private final PasswordStrengthEvaluator strengthEvaluator;

    public RegistrarUsuarioUseCase(
            UsuarioRepository repository,
            PasswordHasher hasher,
            PasswordStrengthEvaluator strengthEvaluator) {
        this.repository = repository;
        this.hasher = hasher;
        this.strengthEvaluator = strengthEvaluator;
    }

    public Usuario registrar(String nombre, String email, String password) {

        repository.buscarPorEmail(email).ifPresent(u -> {
            throw new UsuarioYaExisteException(email);
        });

        strengthEvaluator.validate(password);

        UsuarioRegistradoResult nuevo = Usuario.registrar(
                new UserId((long) Math.random()),
                new UserName(nombre),
                email,
                password,
                hasher,
                strengthEvaluator
            );

        return repository.guardar(nuevo.usuario());
    }
}
