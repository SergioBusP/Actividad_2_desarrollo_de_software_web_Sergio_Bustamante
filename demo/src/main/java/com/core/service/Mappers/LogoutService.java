package com.core.service.Mappers;

import com.core.port.in.LogoutUseCase;
import com.core.port.out.SessionRepositoryPort;
import com.core.port.out.UsuarioRepository;
import com.core.domain.entity.Usuario;
import org.springframework.stereotype.Service;

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