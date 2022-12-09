package com.example.backendjavaheroes.model.services;

import java.util.List;

import com.example.backendjavaheroes.model.entity.Heroe;

public interface IHeroeService {
    public List<Heroe> findAll();
    public Heroe findHeroeById(Heroe heroe);
    public List<Heroe> findByNombre(String q);
    public Heroe saveHeroe(Heroe heroe);
    public Heroe updateHeroe(Heroe heroe);
    public void deleteHeroe(Heroe heroe);
}
