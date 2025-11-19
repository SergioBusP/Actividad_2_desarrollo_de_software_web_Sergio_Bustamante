package com.core.domain.exception;

public final class MotorInvalidoException extends ExcepcionDominio {

	private static final long serialVersionUID = 1L;

	public MotorInvalidoException(String detalle) {
        super("Motor inválido: " + detalle);
    }
}
