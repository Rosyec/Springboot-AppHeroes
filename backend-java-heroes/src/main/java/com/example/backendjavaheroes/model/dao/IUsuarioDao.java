package com.example.backendjavaheroes.model.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.backendjavaheroes.model.entity.Usuario;

public interface IUsuarioDao extends MongoRepository<Usuario, String>{
    public Optional<Usuario> findByEmail(String email);
    
}
