package com.example.backendjavaheroes.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.backendjavaheroes.model.dao.IHeroeDao;
import com.example.backendjavaheroes.model.entity.Heroe;

@Service
public class HeroeServiceImpl implements IHeroeService{

    @Autowired
    public IHeroeDao heroeDao;

    @Override
    @Transactional(readOnly = true)
    public List<Heroe> findAll() {
        return this.heroeDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Heroe findHeroeById(Heroe heroes) {
        return this.heroeDao.findById( heroes.getId() ).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Heroe> findByNombre(String q) {
        return this.heroeDao.findBySuperheroLikeIgnoreCase(q);
    }

    @Override
    @Transactional
    public Heroe saveHeroe(Heroe heroes) {
        return this.heroeDao.save( heroes );
    }

    @Override
    @Transactional
    public Heroe updateHeroe(Heroe heroes) {
        Heroe h = new Heroe();
        h = this.findHeroeById( heroes );
        if ( h == null ) {
            return this.heroeDao.save( heroes );
        } else {
            h.setAlterEgo( heroes.getAlterEgo() );
            h.setCharacters( heroes.getCharacters() );
            h.setFirstAppearance(heroes.getFirstAppearance() );
            h.setImgURL( heroes.getImgURL() );
            h.setPublisher( heroes.getPublisher() );
            h.setSuperhero( heroes.getSuperhero() );
            return this.heroeDao.save( h );
        }
    }

    @Override
    @Transactional
    public void deleteHeroe(Heroe heroes) {
        this.heroeDao.delete( heroes );        
    }
    
}
