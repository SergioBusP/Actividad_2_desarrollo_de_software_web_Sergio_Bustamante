package com.example.demo.core.port.out;

public interface SessionRepositoryPort {

    void crearSesion(Long userId, String token);

    void eliminarSesion(Long userId);

    boolean sesionActiva(Long userId);

    String obtenerToken(Long userId);
}
