package com.example.recetario.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;

    public Ingredient(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
