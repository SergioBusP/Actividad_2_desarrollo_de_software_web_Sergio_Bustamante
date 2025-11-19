package com.example.demo.core.domain.event;

import java.time.Instant;

import com.example.demo.core.domain.valueObject.UserId;

public record UsuarioRolAsignado(UserId id, String rol, Instant fecha) {}

