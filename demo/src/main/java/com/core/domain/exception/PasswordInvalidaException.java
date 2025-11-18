package com.core.domain.exception;

public class PasswordInvalidaException extends RuntimeException {
    public PasswordInvalidaException(String mensaje) {
            super(mensaje);
        }

    public PasswordInvalidaException() {
        }
}
