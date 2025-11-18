package com.core.service.Mappers;

import com.core.port.in.ObtenerUsuarioUseCase;
import com.core.port.out.UsuarioRepository;
import com.core.domain.entity.Usuario;
import org.springframework.stereotype.Service;

@Service
public class ObtenerUsuarioService implements ObtenerUsuarioUseCase {

    private final UsuarioRepository repository;

    public ObtenerUsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario obtener(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
