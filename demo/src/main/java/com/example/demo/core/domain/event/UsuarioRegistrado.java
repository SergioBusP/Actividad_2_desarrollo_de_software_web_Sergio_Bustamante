package com.core.domain.event;

import com.core.domain.valueObject.UserId;
import java.time.Instant;

public record UsuarioRegistrado(UserId id, String email, Instant fecha) {}

