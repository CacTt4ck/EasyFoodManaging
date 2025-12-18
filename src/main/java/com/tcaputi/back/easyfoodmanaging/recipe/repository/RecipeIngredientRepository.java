package com.tcaputi.back.easyfoodmanaging.recipe.repository;

import com.tcaputi.back.easyfoodmanaging.recipe.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
}
