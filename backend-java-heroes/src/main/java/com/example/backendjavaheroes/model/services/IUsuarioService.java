package com.example.backendjavaheroes.model.services;

import java.util.List;

import com.example.backendjavaheroes.model.entity.Usuario;

public interface IUsuarioService {
    public List<Usuario> findAll();
    public Usuario findUsuarioByEmail(Usuario usuario);
    public Usuario saveUsuario(Usuario usuario);
    public Usuario updateUsuario(Usuario usuario);
    public void deleteUsuario(Usuario usuario);
    
}
