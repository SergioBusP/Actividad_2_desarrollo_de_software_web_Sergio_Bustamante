package com.adapter.databases.sql.mappers;

import com.adapter.databases.sql.entity.UsuarioJpaEntity;
import com.example.demo.core.domain.entity.Usuario;
import com.example.demo.core.domain.valueObject.*;

public class UsuarioJpaMapper {

    public static Usuario toDomain(UsuarioJpaEntity entity) {
        return new Usuario(
                new UserId(entity.getId()),
                new UserName(entity.getNombre()),
                entity.getEmail(),
                entity.getPassword(),
                entity.getFechaCreacion(),
                entity.getFechaActualizacion(),
                entity.getActivo()
        );
    }

    public static UsuarioJpaEntity toEntity(Usuario domain) {
        UsuarioJpaEntity entity = new UsuarioJpaEntity();
        entity.setId(domain.getId().value());
        entity.setNombre(domain.getNombre().value());
        entity.setEmail(domain.getEmail());
        entity.setPassword(domain.getPasswordHash());
        entity.setActivo(domain.isActivo());
        entity.setFechaCreacion(domain.getFechaCreacion());
        entity.setFechaActualizacion(domain.getFechaActualizacion());
        return entity;
    }
}
