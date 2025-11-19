package com.example.demo.core.domain.event;

import java.time.Instant;

import com.example.demo.core.domain.valueObject.*;

public class KilometrajeActualizado implements EventoDominio {
	
	private final Placa placa;
    private final int kilometrajeAnterior;
    private final int kilometrajeNuevo;
    private final Instant ocurridoEn;

    public KilometrajeActualizado(Placa placa, int kilometrajeAnterior, int kilometrajeNuevo) {
        if (kilometrajeNuevo < kilometrajeAnterior) {
            throw new IllegalArgumentException("El kilometraje nuevo no puede ser menor al anterior");
        }
        this.placa = placa;
        this.kilometrajeAnterior = kilometrajeAnterior;
        this.kilometrajeNuevo = kilometrajeNuevo;
        this.ocurridoEn = Instant.now();
    }

    public Placa getPlaca() { return placa; }
    public int getKilometrajeAnterior() { return kilometrajeAnterior; }
    public int getKilometrajeNuevo() { return kilometrajeNuevo; }

    @Override
    public Instant ocurridoEn() { return ocurridoEn; }

    @Override
    public String toString() {
        return "KilometrajeActualizado{" +
                "placa=" + placa +
                ", kilometrajeAnterior=" + kilometrajeAnterior +
                ", kilometrajeNuevo=" + kilometrajeNuevo +
                ", ocurridoEn=" + ocurridoEn +
                '}';
    }
}
