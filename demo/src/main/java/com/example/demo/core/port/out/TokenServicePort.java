package com.example.demo.core.port.out;

public interface TokenServicePort {

    String generarToken(String username);

    String validarToken(String token);
}