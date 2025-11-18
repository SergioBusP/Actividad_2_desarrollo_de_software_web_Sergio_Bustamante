package com.core.domain.exception;

public abstract class ExcepcionDominio extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ExcepcionDominio(String mensaje) {
        super(mensaje);
    }
}

