package com.example.demo.core.service.Mappers;

import org.springframework.stereotype.Service;

import com.example.demo.core.domain.entity.Usuario;
import com.example.demo.core.port.in.LogoutUseCase;
import com.example.demo.core.port.out.SessionRepositoryPort;
import com.example.demo.core.port.out.UsuarioRepository;

@Service
public class LogoutService implements LogoutUseCase {

    private final UsuarioRepository usuarioRepository;
    private final SessionRepositoryPort sessionRepository;

    public LogoutService(UsuarioRepository usuarioRepository,
                         SessionRepositoryPort sessionRepository) {
        this.usuarioRepository = usuarioRepository;
        this.sessionRepository = sessionRepository;
    }

    @Override
    public void logout(Long userId) {
        Usuario usuario = usuarioRepository.buscarPorId(userId).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con id: " + userId));

        sessionRepository.eliminarSesion(userId);

    }
}