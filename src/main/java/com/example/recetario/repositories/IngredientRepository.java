package com.example.recetario.repositories;

import com.example.recetario.models.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    List<Ingredient> findByName(String name);

    List<Ingredient> findByNameContaining(String name);

    Ingredient findById(long id);
}
