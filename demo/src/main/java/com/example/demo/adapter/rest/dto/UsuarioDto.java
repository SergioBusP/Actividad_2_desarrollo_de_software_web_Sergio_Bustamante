package com.example.demo.adapter.rest.dto;

import java.time.Instant;

public class UsuarioDto {

    private Long id;
    private String nombre;
    private String email;
    private boolean activo;
    private Instant fechaCreacion;
    private Instant fechaActualizacion;

    public long getId() {return id;}
    public String getNombre() {return nombre;}
    public String getEmail() {return email;}
    public boolean getActivo() {return activo;}
    public Instant getFechaCreacion() {return fechaCreacion;}
    public Instant getFechaActualizacion() {return fechaActualizacion;}

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setFechaCreacion(Instant fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaActualizacion(Instant fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
