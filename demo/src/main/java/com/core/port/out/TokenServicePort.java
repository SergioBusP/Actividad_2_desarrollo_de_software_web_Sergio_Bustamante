package com.core.port.out;

public interface TokenServicePort {

    String generarToken(Long userId);

    boolean validarToken(String token);

    Long obtenerUserIdDesdeToken(String token);
}