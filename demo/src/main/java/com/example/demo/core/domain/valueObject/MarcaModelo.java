package com.example.demo.core.domain.valueObject;

import java.util.Objects;

public final class MarcaModelo {
	private final String marca;
    private final String modelo;
    private final String version;

    public MarcaModelo(String marca, String modelo, String version) {
        if (marca == null || marca.isBlank()) {
            throw new IllegalArgumentException("La marca no puede ser nula o vacía");
        }
        if (modelo == null || modelo.isBlank()) {
            throw new IllegalArgumentException("El modelo no puede ser nulo o vacío");
        }

        this.marca = marca.trim();
        this.modelo = modelo.trim();
        this.version = (version == null || version.isBlank()) ? "Base" : version.trim();
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getVersion() { return version; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MarcaModelo)) return false;
        MarcaModelo that = (MarcaModelo) o;
        return Objects.equals(marca, that.marca) &&
               Objects.equals(modelo, that.modelo) &&
               Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() { return Objects.hash(marca, modelo, version); }

    @Override
    public String toString() {
        return marca + " " + modelo + " " + version;
    }
}
