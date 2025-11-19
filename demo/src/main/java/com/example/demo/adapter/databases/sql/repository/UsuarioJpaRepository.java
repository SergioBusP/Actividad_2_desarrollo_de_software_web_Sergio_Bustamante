package com.example.demo.adapter.databases.sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.adapter.databases.sql.entity.UsuarioJpaEntity;

import java.util.Optional;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioJpaEntity, Long> {
    Optional<UsuarioJpaEntity> findByEmail(String email);
}
