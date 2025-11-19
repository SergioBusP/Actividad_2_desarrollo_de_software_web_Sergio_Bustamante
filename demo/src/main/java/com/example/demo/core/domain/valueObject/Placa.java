package com.example.demo.core.domain.valueObject;

import java.util.Objects;
import java.util.regex.Pattern;

public final class Placa {
	private final String valor;

    private static final Pattern PATRON_PLACA = Pattern.compile("^[A-Z]{3}[0-9]{3}$");

    public Placa(String valor) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("La placa no puede ser nula ni vacía");
        }
        String normalizado = valor.trim().toUpperCase();

        if (!PATRON_PLACA.matcher(normalizado).matches()) {
            throw new IllegalArgumentException("Formato de placa inválido: " + valor);
        }

        this.valor = normalizado;
    }

    public String getValor() { return valor; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Placa)) return false;
        Placa placa = (Placa) o;
        return Objects.equals(valor, placa.valor);
    }

    @Override
    public int hashCode() { return Objects.hash(valor); }

    @Override
    public String toString() { return valor; }
}
