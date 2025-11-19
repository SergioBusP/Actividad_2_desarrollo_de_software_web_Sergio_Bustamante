package com.example.demo.core.domain.exception;

public class CredencialesInvalidasException extends RuntimeException {
    public CredencialesInvalidasException(String mensaje) {
            super(mensaje);
        }

    public CredencialesInvalidasException() {
        }
}
