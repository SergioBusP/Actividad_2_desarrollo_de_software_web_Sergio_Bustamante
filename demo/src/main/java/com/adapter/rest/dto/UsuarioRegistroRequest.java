package com.adapter.rest.dto;

public class UsuarioRegistroRequest {
    private String nombre;
    private String email;
    private String password;
    

    public String getNombre() {return nombre;}
    public String getEmail() {return email;}
    public String getPassword() {return password;}

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
