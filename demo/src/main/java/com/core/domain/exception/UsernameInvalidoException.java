package com.core.domain.exception;

public class UsernameInvalidoException extends RuntimeException {
    public UsernameInvalidoException(String mensaje) {
            super(mensaje);
        }
    
    public UsernameInvalidoException() {
        }
}
