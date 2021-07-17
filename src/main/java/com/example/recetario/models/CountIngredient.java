package com.example.recetario.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CountIngredient {

    @Embeddable
    class CountIngredientKey implements Serializable {

        @Column(name = "ingredient_id")
        private Long ingredientId;

        @Column(name = "unit_id")
        private Long unitId;
    }

    @EmbeddedId
    CountIngredientKey id;

    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @ManyToOne
    @MapsId("unitId")
    @JoinColumn(name = "unit_id")
    private Unit unit;

    private float count;

    public CountIngredient(Ingredient ingredient, Unit unit, float count) {
        this.ingredient = ingredient;
        this.unit = unit;
        this.count = count;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public float getCount() {
        return count;
    }

    public void setCount(float count) {
        this.count = count;
    }
}
