package com.example.backendjavaheroes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendjavaheroes.model.entity.Usuario;
import com.example.backendjavaheroes.model.services.IUsuarioService;

@RestController
@RequestMapping("/api-u")
@CrossOrigin(origins = {"http://localhost:4200", "*"})
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<Usuario> buscarTodos(){
        return this.usuarioService.findAll();
    }

    @GetMapping("/usuarios/{email}")
    public Usuario buscarPorEmail(@PathVariable String email){
        return this.usuarioService.findUsuarioByEmail( new Usuario(email) );
    }

    @PostMapping("/usuarios")
    public Usuario guardar(@RequestBody Usuario usuario){
        return this.usuarioService.saveUsuario(usuario);
    }

    @PutMapping("/usuarios")
    public Usuario actualizar(@RequestBody Usuario usuario){
        return this.usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    public void eliminar(@PathVariable String id){
        this.usuarioService.deleteUsuario( new Usuario(id) );
    }


    
}
