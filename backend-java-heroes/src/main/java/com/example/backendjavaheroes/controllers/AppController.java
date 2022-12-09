package com.example.backendjavaheroes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendjavaheroes.model.entity.Heroe;
import com.example.backendjavaheroes.model.services.HeroeServiceImpl;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "*"})//Cambiar al subir a Heroku
@RequestMapping("/api")
public class AppController {

    @Autowired
    private HeroeServiceImpl heroeServiceImpl;

    @GetMapping("/index")
    String index(Model model){
        return "index";
    }

    @GetMapping("/heroes")
    public List<Heroe> buscarTodos(){
        return this.heroeServiceImpl.findAll();
    }

    @GetMapping("/heroes/{id}")
    public Heroe buscarPorId(@PathVariable String id){
        return this.heroeServiceImpl.findHeroeById( new Heroe(id) );
    }

    @GetMapping("/buscar")
    public List<Heroe> buscarPorNombre(@RequestParam String q){
        return this.heroeServiceImpl.findByNombre(q);
    }

    @PostMapping("/heroes")
    public Heroe guardar(@RequestBody Heroe heroe){
        return this.heroeServiceImpl.saveHeroe( heroe );
    }

    @PutMapping("/heroes/")
    public Heroe actualizar(@RequestBody Heroe heroe){
        return this.heroeServiceImpl.updateHeroe( heroe );
    }

    @DeleteMapping("/heroes/{id}")
    public void eliminar(@PathVariable String id){
        this.heroeServiceImpl.deleteHeroe( new Heroe(id) );
    }
}
