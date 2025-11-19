package com.example.demo.adapter.persistance;

import com.example.demo.core.domain.entity.Session;
import com.example.demo.core.port.out.SessionRepositoryPort;
import org.springframework.stereotype.Repository;

@Repository
public class SessionRepositoryAdapter implements SessionRepositoryPort {

    public void save(Session session) {
        // Aquí implementas la lógica real,
        // por ahora puedes dejarlo vacío si aún no tienes persistencia.
        System.out.println("Sesión guardada: " + session);
    }

    @Override
    public void crearSesion(Long userId, String token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearSesion'");
    }

    @Override
    public void eliminarSesion(Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarSesion'");
    }

    @Override
    public boolean sesionActiva(Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sesionActiva'");
    }

    @Override
    public String obtenerToken(Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerToken'");
    }
}
