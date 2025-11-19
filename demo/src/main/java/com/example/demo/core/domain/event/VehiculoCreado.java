package com.core.domain.event;

import java.time.Instant;
import com.core.domain.entity.*;
import com.core.domain.valueObject.Placa;

import java.util.UUID;

public class VehiculoCreado implements EventoDominio {
	private final UUID idVehiculo;
    private final Placa placa;
    private final Categoria categoria;
    private final Instant ocurridoEn;

    public VehiculoCreado(UUID idVehiculo, Placa placa, Categoria categoria) {
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.categoria = categoria;
        this.ocurridoEn = Instant.now();
    }

    public UUID getIdVehiculo() { return idVehiculo; }
    public Placa getPlaca() { return placa; }
    public Categoria getCategoria() { return categoria; }
	
	@Override
	public Instant ocurridoEn() {
		return ocurridoEn;
	}
	
	@Override
    public String toString() {
        return "VehiculoCreado{" +
                "idVehiculo=" + idVehiculo +
                ", placa=" + placa +
                ", categoria=" + categoria +
                ", ocurridoEn=" + ocurridoEn +
                '}';
    }
}