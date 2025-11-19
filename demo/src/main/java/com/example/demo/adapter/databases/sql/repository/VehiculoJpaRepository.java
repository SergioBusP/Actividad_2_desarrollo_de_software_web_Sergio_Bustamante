package com.example.demo.adapter.databases.sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.adapter.databases.sql.entity.VehiculoJpaEntity;

import java.util.*;

import java.util.Optional;

public interface VehiculoJpaRepository extends JpaRepository<VehiculoJpaEntity, UUID> {

    Optional<VehiculoJpaEntity> findByPlaca(String placa);
}
