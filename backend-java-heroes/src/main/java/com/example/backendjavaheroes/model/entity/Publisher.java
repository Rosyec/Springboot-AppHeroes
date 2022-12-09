package com.example.backendjavaheroes.model.entity;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Publisher {
    DC_COMICS, MARVEL_COMICS;

    @JsonValue
    public String toValue() {
        switch (this) {
            case DC_COMICS: return "DC Comics";
            case MARVEL_COMICS: return "Marvel Comics";
        }
        return null;
    }

    @JsonCreator
    public static Publisher forValue(String value) throws IOException {
        if (value.equals("DC Comics")) return DC_COMICS;
        if (value.equals("Marvel Comics")) return MARVEL_COMICS;
        throw new IOException("Cannot deserialize Publisher");
    }

    
    
}
