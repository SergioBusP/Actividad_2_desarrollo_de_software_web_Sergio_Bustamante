package com.core.domain.valueObject;

import java.util.Objects;

public final class Capacidad {
	private final int numPuestos;
    private final int numPuertas;

    public Capacidad(int numPuestos, int numPuertas) {
        if (numPuestos < 1) {
            throw new IllegalArgumentException("El vehículo debe tener al menos un puesto");
        }
        if (numPuertas < 0) {
            throw new IllegalArgumentException("El número de puertas no puede ser negativo");
        }
        this.numPuestos = numPuestos;
        this.numPuertas = numPuertas;
    }

    public int getNumPuestos() { return numPuestos; }
    public int getNumPuertas() { return numPuertas; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Capacidad)) return false;
        Capacidad that = (Capacidad) o;
        return numPuestos == that.numPuestos &&
               numPuertas == that.numPuertas;
    }

    @Override
    public int hashCode() { return Objects.hash(numPuestos, numPuertas); }

    @Override
    public String toString() {
        return numPuestos + " puestos, " + numPuertas + " puertas";
    }
}