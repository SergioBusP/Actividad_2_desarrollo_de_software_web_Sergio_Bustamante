package com.example.demo.core.domain.entity;

import java.util.Objects;

public class Categoria {
    private final String tipo;
    private String descripcion;

    public Categoria(String tipo, String descripcion) {
        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException("El tipo de categoría no puede ser nulo o vacío");
        }
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getTipo() { return tipo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria)) return false;
        Categoria that = (Categoria) o;
        return Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo);
    }
}
