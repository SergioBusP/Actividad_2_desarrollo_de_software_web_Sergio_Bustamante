package com.example.demo.core.domain.event;

import java.time.Instant;

import com.example.demo.core.domain.valueObject.UserId;

public record UsuarioRenombrado(UserId id, Instant fecha) {}
