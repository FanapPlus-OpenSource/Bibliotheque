package com.emami.bibliotheque.repositories;

import com.emami.bibliotheque.restaurant.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
