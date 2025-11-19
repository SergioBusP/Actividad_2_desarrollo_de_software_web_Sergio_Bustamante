package com.example.demo.core.service.Mappers;

import org.springframework.stereotype.Service;

import com.example.demo.core.domain.entity.Usuario;
import com.example.demo.core.domain.entity.Usuario.UsuarioRegistradoResult;
import com.example.demo.core.domain.service.PasswordHasher;
import com.example.demo.core.domain.service.PasswordStrengthEvaluator;
import com.example.demo.core.domain.valueObject.UserId;
import com.example.demo.core.domain.valueObject.UserName;
import com.example.demo.core.port.in.RegistrarUsuarioUseCase;
import com.example.demo.core.port.out.UsuarioRepository;

@Service
public class RegistrarUsuarioService implements RegistrarUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;
    private final PasswordHasher hasher;
    private final PasswordStrengthEvaluator evaluator;

    public RegistrarUsuarioService(
            UsuarioRepository usuarioRepository,
            PasswordHasher hasher,
            PasswordStrengthEvaluator evaluator
    ) {
        this.usuarioRepository = usuarioRepository;
        this.hasher = hasher;
        this.evaluator = evaluator;
    }

    @Override
    public Usuario crearNuevo(String Nombre,
            String email,
            String plainPassword) {

        UserName nombre = new UserName(Nombre);

        UsuarioRegistradoResult resultado = Usuario.registrar(
                new UserId((long) Math.random()),
                nombre,
                email,
                plainPassword,
                hasher,
                evaluator
        );

        Usuario usuario = usuarioRepository.guardar(resultado.usuario());

        return usuario;
    }
}
