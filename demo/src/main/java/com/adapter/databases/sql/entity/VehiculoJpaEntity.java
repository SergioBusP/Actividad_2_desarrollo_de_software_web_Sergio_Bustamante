package com.adapter.databases.sql.entity;

import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "vehiculos")
public class VehiculoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String placa;
    private String marca;
    private String modelo;
    private String version;
    private String color;
    private Integer numPuestos;
    private Integer numPuertas;
    private String combustible;
    private Integer kilometros;
    private Integer cilindraje;
    private String categoria;

    public VehiculoJpaEntity() {}

    public UUID getId() {return id;}
    public String getPlaca() {return placa;}
    public String getMarca() {return marca;}
    public String getModelo() {return modelo;}
    public String getVersion() {return version;}
    public String getColor() {return color;}
    public Integer getNumPuestos() {return numPuestos;}
    public Integer getNumPuertas() {return numPuertas;}
    public String getCombustible() {return combustible;}
    public Integer getKilometros() {return kilometros;}
    public Integer getCilindraje() {return cilindraje;}
    public String getCategoria() {return categoria;}

    public void setId(UUID id) {
        this.id = id;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNumPuestos(Integer numPuestos) {
        this.numPuestos = numPuestos;
    }

    public void setNumPuertas(Integer numPuertas) {
        this.numPuertas = numPuertas;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public void setKilometros(Integer kilometros) {
        this.kilometros = kilometros;
    }

    public void setCilindraje(Integer cilindraje) {
        this.cilindraje = cilindraje;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
