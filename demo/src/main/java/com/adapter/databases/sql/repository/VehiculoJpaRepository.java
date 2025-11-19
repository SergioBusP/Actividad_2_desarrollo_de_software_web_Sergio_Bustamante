package com.adapter.databases.sql.repository;

import com.adapter.databases.sql.entity.VehiculoJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

import java.util.Optional;

public interface VehiculoJpaRepository extends JpaRepository<VehiculoJpaEntity, UUID> {

    Optional<VehiculoJpaEntity> findByPlaca(String placa);
}
