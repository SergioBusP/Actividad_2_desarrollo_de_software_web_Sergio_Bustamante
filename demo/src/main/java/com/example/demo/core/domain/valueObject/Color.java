package com.example.demo.core.domain.valueObject;

import java.util.Objects;
import java.util.Set;

import com.example.demo.core.domain.exception.*;

public final class Color {
	private String valor;
	
	private static final Set<String> COLORES_VALIDOS = Set.of(
            "blanco", "negro", "rojo", "azul", "gris", "verde", "amarillo", "plateado"
    );
	
	public Color(String valor) {
		if (valor == null || valor.isBlank()) {
			throw new IllegalArgumentException("El color no puede ser nulo o vacío");
		}
		String normalizado = valor.trim().toLowerCase();

        if (!COLORES_VALIDOS.contains(normalizado)) {
            throw new ColorNoPermitidoException(normalizado);
        }

        this.valor = normalizado;
	}
	
	public String getValor() {
		return valor;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Color)) return false;
        Color color = (Color) o;
        return Objects.equals(valor, color.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
