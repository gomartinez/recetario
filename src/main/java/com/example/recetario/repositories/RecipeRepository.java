package com.example.recetario.repositories;

import com.example.recetario.models.Recipe;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    List<Recipe> findByName(String name);

    List<Recipe> findByNameContaining(String name);

    Recipe findById(long id);
}
