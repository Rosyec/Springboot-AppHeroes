package com.example.backendjavaheroes.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document
public class Heroe {
    
    @Id
    private String id;

    private String superhero;
    private Publisher publisher;
    private String alterEgo;
    private String firstAppearance;
    private String characters;
    private String imgURL;

    public Heroe(String id) {
        this.id = id;
    }

    public Heroe() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSuperhero() {
        return superhero;
    }

    public void setSuperhero(String superhero) {
        this.superhero = superhero;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @JsonProperty("alter_ego")
    public String getAlterEgo() {
        return alterEgo;
    }

    @JsonProperty("alter_ego")
    public void setAlterEgo(String alterEgo) {
        this.alterEgo = alterEgo;
    }

    @JsonProperty("first_appearance")
    public String getFirstAppearance() {
        return firstAppearance;
    }

    @JsonProperty("first_appearance")
    public void setFirstAppearance(String firstAppearance) {
        this.firstAppearance = firstAppearance;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    @JsonProperty("img_url")
    public String getImgURL() {
        return imgURL;
    }

    @JsonProperty("img_url")
    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

}
