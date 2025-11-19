package com.example.demo.core.domain.exception;

public final class ColorNoPermitidoException extends ExcepcionDominio {

	private static final long serialVersionUID = 1L;

	public ColorNoPermitidoException(String color) {
        super("El color '" + color + "' no está permitido en el sistema");
    }
}
