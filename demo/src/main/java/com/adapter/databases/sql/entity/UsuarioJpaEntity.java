package com.adapter.databases.sql.entity;

import jakarta.persistence.*;

import java.time.Instant;

import com.core.domain.valueObject.PasswordHash;

@Entity
@Table(name = "usuarios")
public class UsuarioJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private PasswordHash password;
    private boolean activo;

    private Instant fechaCreacion;
    private Instant fechaActualizacion;

    public long getId() {return id;}
    public String getNombre() {return nombre;}
    public String getEmail() {return email;}
    public PasswordHash getPassword() {return password;}
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

    public void setPassword(PasswordHash password) {
        this.password = password;
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
