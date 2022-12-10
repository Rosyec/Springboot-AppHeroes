package com.example.backendjavaheroes.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Usuario {
    @Id
    private String id;
    private String email;
    private String usuario;
    
    public Usuario(String email) {
        this.email = email;
    }

    public Usuario() {
    }

    public Usuario(String id, String email, String usuario) {
        this.id = id;
        this.email = email;
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
