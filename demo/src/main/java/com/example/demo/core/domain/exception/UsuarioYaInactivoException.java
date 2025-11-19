package com.example.demo.core.domain.exception;

public class UsuarioYaInactivoException extends RuntimeException {
    public UsuarioYaInactivoException(String mensaje) {
            super(mensaje);
        }

    public UsuarioYaInactivoException() {
        }
}
