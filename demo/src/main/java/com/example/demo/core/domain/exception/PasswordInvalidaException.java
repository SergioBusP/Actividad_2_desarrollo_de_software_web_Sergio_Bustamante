package com.example.demo.core.domain.exception;

public class PasswordInvalidaException extends RuntimeException {
    public PasswordInvalidaException(String mensaje) {
            super(mensaje);
        }

    public PasswordInvalidaException() {
        }
}
