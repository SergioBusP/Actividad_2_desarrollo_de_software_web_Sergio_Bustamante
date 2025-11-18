package com.core.domain.exception;

public class UsuarioYaExisteException extends RuntimeException {
    public UsuarioYaExisteException(String mensaje) {
            super(mensaje);
        }

    public UsuarioYaExisteException() {
        }
}
