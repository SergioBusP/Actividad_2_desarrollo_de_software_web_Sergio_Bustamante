package com.core.domain.exception;

public final class KilometrajeInvalidoException extends ExcepcionDominio {

	private static final long serialVersionUID = 1L;

	public KilometrajeInvalidoException() {
		super("No se puede asignar un kilometraje menor al actual.");
	}
}