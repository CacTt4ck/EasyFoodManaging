package com.tcaputi.back.easyfoodmanaging.ingredient.repository;

import com.tcaputi.back.easyfoodmanaging.ingredient.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    Optional<Ingredient> findByEan13(String ean13);
    Optional<List<Ingredient>> findByNameContaining(String name);

}
