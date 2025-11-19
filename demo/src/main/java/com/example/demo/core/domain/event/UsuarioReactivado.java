package com.example.demo.core.domain.event;

import java.time.Instant;

import com.example.demo.core.domain.valueObject.UserId;

public record UsuarioReactivado(UserId id, Instant fecha) {}
