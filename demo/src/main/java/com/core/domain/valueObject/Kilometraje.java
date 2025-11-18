package com.core.domain.valueObject;

import java.util.Objects;
import com.core.domain.exception.*;

public final class Kilometraje {
	private final int valor;

    public Kilometraje(int valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("El kilometraje no puede ser negativo");
        }
        this.valor = valor;
    }

    public int getValor() { return valor; }

    public Kilometraje incrementar(int adicional) {
        if (adicional < 0) {
            throw new KilometrajeInvalidoException();
        }
        return new Kilometraje(this.valor + adicional);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kilometraje)) return false;
        Kilometraje that = (Kilometraje) o;
        return valor == that.valor;
    }

    @Override
    public int hashCode() { return Objects.hash(valor); }

    @Override
    public String toString() { return valor + " km"; }
}
