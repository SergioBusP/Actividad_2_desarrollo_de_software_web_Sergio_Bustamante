package com.core.domain.event;

import com.core.domain.valueObject.UserId;
import java.time.Instant;

public record UsuarioRolAsignado(UserId id, String rol, Instant fecha) {}

