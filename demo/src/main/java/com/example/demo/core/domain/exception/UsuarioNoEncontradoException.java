package com.example.demo.core.domain.exception;

public class UsuarioNoEncontradoException extends RuntimeException {
    public UsuarioNoEncontradoException(String mensaje) {
            super(mensaje);
        }

    public UsuarioNoEncontradoException() {
        }
}