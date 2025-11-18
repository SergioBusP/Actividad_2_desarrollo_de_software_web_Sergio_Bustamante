package com.core.domain.event;

import com.core.domain.valueObject.UserId;
import java.time.Instant;

public record UsuarioRenombrado(UserId id, Instant fecha) {}
