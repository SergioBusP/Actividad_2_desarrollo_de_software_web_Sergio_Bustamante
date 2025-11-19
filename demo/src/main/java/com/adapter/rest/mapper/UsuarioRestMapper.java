package com.adapter.rest.mapper;

import com.adapter.rest.dto.UsuarioDto;
import com.example.demo.core.domain.entity.Usuario;

public class UsuarioRestMapper {

    public static UsuarioDto toDto(Usuario usuario) {
        UsuarioDto dto = new UsuarioDto();
        dto.setId(usuario.getId().value());
        dto.setNombre(usuario.getNombre().value());
        dto.setEmail(usuario.getEmail());
        dto.setActivo(usuario.isActivo());
        dto.setFechaCreacion(usuario.getFechaCreacion());
        dto.setFechaActualizacion(usuario.getFechaActualizacion());
        return dto;
    }
}