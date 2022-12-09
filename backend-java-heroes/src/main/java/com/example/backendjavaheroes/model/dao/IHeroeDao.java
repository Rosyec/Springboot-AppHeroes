package com.example.backendjavaheroes.model.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.backendjavaheroes.model.entity.Heroe;

public interface IHeroeDao extends MongoRepository<Heroe, String>{

    public List<Heroe> findBySuperheroLikeIgnoreCase(String superhero);
}
