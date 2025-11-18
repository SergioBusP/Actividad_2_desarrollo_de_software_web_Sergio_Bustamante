package com.core.domain.entity;

import com.core.domain.event.*;
import com.core.domain.exception.*;
import com.core.domain.service.PasswordHasher;
import com.core.domain.service.PasswordStrengthEvaluator;
import com.core.domain.valueObject.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Usuario {

    private UserId id;
    private UserName nombre;
    private String email;
    private PasswordHash passwordHash;
    private Instant fechaCreacion;
    private Instant fechaActualizacion;
    private boolean activo;

    private List<Rol> roles = new ArrayList<>();

    public Usuario(
            UserId id,
            UserName nombre,
            String email,
            PasswordHash passwordHash,
            Instant fechaCreacion,
            Instant fechaActualizacion,
            boolean activo
    ) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.passwordHash = passwordHash;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.activo = activo;
    }

    // ---------- Getters ----------
    public UserId getId() { return id; }
    public UserName getNombre() { return nombre; }
    public String getEmail() { return email; }
    public PasswordHash getPasswordHash() { return passwordHash; }
    public Instant getFechaCreacion() { return fechaCreacion; }
    public Instant getFechaActualizacion() { return fechaActualizacion; }
    public boolean isActivo() { return activo; }
    public List<Rol> getRoles() { return List.copyOf(roles); }

    // ---------- Métodos de dominio ----------

    public UsuarioRenombrado actualizarNombre(String nuevoNombre) {
        if (!Pattern.matches("^[a-zA-Z0-9_]{3,20}$", nuevoNombre)) {
            throw new UsernameInvalidoException("El nombre de usuario '" + nuevoNombre + "' no es válido");
        }

        this.nombre = new UserName(nuevoNombre);
        this.fechaActualizacion = Instant.now();

        return new UsuarioRenombrado(id, fechaActualizacion);
    }

    public void actualizarEmail(String nuevoEmail) {
        this.email = nuevoEmail;
        this.fechaActualizacion = Instant.now();
    }

    public UsuarioReactivado activar() {
        if (this.activo) {
            throw new UsuarioYaActivoException();
        }

        this.activo = true;
        this.fechaActualizacion = Instant.now();

        return new UsuarioReactivado(id, fechaActualizacion);
    }

    public void validarPassword(String passwordPlano) {
        if (!passwordHash.verify(passwordPlano)) {
            throw new PasswordInvalidaException();
        }
    }

    public UsuarioDesactivado desactivar() {
        if (!this.activo) {
            throw new UsuarioYaInactivoException();
        }

        this.activo = false;
        this.fechaActualizacion = Instant.now();

        return new UsuarioDesactivado(id, fechaActualizacion);
    }

    public UserPasswordChanged cambiarPassword(PasswordHash nuevoPassword) {
        this.passwordHash = nuevoPassword;
        this.fechaActualizacion = Instant.now();

        return new UserPasswordChanged(id, fechaActualizacion);
    }

    // ---------- Factory estática de registro ----------

    public static UsuarioRegistradoResult registrar(
            UserId id,
            UserName nombre,
            String email,
            String plainPassword,
            PasswordHasher hasher,
            PasswordStrengthEvaluator evaluator
    ) {
        evaluator.validate(plainPassword);

        PasswordHash hash = PasswordHash.from(hasher.hash(plainPassword));
        Instant now = Instant.now();

        Usuario usuario = new Usuario(
                id,
                nombre,
                email,
                hash,
                now,
                now,
                true
        );

        UsuarioRegistrado evento = new UsuarioRegistrado(id, email, now);

        return new UsuarioRegistradoResult(usuario, evento);
    }

    // ---------- Roles ----------
    public UsuarioRolAsignado asignarRol(Rol rol) {

        boolean existe = roles.stream().anyMatch(r -> r.equals(rol));

        if (!existe) {
            roles.add(rol);
        }

        this.fechaActualizacion = Instant.now();

        return new UsuarioRolAsignado(id, rol.value(), fechaActualizacion);
    }

    // Resultado para factory registrar()
    public record UsuarioRegistradoResult(Usuario usuario, UsuarioRegistrado evento) {}
}

