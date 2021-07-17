package com.example.recetario;

import com.example.recetario.models.Recipe;
import com.example.recetario.repositories.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RecetarioApplication {

	private static final Logger log = LoggerFactory.getLogger(RecetarioApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RecetarioApplication.class);
	}

	@Bean
	public CommandLineRunner demo(RecipeRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Recipe("Pan de centeno", "Pan con harina de Centeno"));
			repository.save(new Recipe("Torta de rictota", "Torta de ricota clasica"));
			repository.save(new Recipe("Pan de tortuga", "Pan de tortuga"));
			repository.save(new Recipe("Cheescake de dulce de leche", ""));
			repository.save(new Recipe("Donas", ""));

			// fetch all customers
			log.info("Recipes found with findAll():");
			log.info("-------------------------------");
			for (Recipe recipe : repository.findAll()) {
				log.info(recipe.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Recipe recipe = repository.findByName("Donas").get(0);
			log.info("Recipe found with findByName(Donas):");
			log.info("--------------------------------");
			log.info(recipe.toString());
			log.info("");

			// fetch customers by last name
			log.info("Recipes found with findByName('Pan'):");
			log.info("--------------------------------------------");
			repository.findByNameContaining("Pan").forEach(receta -> {
				log.info(receta.toString());
			});
			log.info("");


		};
	}

}
