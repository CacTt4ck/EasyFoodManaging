package com.tcaputi.back.easyfoodmanaging.recipe.repository;

import com.tcaputi.back.easyfoodmanaging.recipe.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
