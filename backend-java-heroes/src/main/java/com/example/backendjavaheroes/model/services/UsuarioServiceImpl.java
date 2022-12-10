package com.example.backendjavaheroes.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.backendjavaheroes.model.dao.IUsuarioDao;
import com.example.backendjavaheroes.model.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return this.usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findUsuarioByEmail(Usuario usuario) {
        return this.usuarioDao.findByEmail( usuario.getEmail() ).orElse( new Usuario("", "", "") );
    }

    @Override
    @Transactional
    public Usuario saveUsuario(Usuario usuario) {
        return this.usuarioDao.save( usuario );
    }

    @Override
    @Transactional
    public Usuario updateUsuario(Usuario usuario) {
        Usuario u = this.findUsuarioByEmail(usuario);
        if ( u == null ) {
            return this.usuarioDao.save( usuario );
        } else {
            u.setId( usuario.getId() );
            u.setEmail( usuario.getEmail() );
            u.setUsuario( usuario.getUsuario() );
            return this.usuarioDao.save( u );
        }
    }

    @Override
    @Transactional
    public void deleteUsuario(Usuario usuario) {
        this.usuarioDao.delete(usuario);        
    }
    
}
