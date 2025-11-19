package com.example.demo.core.domain.exception;

public class UsuarioYaActivoException extends RuntimeException {
    public UsuarioYaActivoException(String mensaje) {
            super(mensaje);
        }

    public UsuarioYaActivoException() {
        }
}
