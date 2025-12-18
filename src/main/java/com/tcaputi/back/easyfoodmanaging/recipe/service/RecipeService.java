package com.tcaputi.back.easyfoodmanaging.recipe.service;

import com.tcaputi.back.easyfoodmanaging.ingredient.model.Ingredient;
import com.tcaputi.back.easyfoodmanaging.ingredient.service.IngredientService;
import com.tcaputi.back.easyfoodmanaging.recipe.exception.NotEnoughIngredientException;
import com.tcaputi.back.easyfoodmanaging.recipe.model.Recipe;
import com.tcaputi.back.easyfoodmanaging.recipe.model.RecipeDto;
import com.tcaputi.back.easyfoodmanaging.recipe.model.RecipeIngredient;
import com.tcaputi.back.easyfoodmanaging.recipe.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientService ingredientService;

    @Transactional(readOnly = true)
    public Recipe getRecipe(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found with id: " + id));
    }

    public Recipe createRecipe(RecipeDto dto) {
        Recipe recipe = new Recipe();
        recipe.setName(dto.getName());
        recipe.setDescription(dto.getDescription());
        recipe.setInstructions(dto.getInstructions());

        // 1. Save empty recipe first to get an ID
        recipe = recipeRepository.save(recipe);

        // 2. Now create ingredients linked to this recipe
        Recipe finalRecipe = recipe;
        List<RecipeIngredient> ingredients = dto.getIngredients().stream()
                .map(riDto -> {
                    Ingredient ingredient = ingredientService.getIngredientById(riDto.getIngredientId());
                    return new RecipeIngredient(null, finalRecipe, ingredient, riDto.getAmountRequired());
                })
                .toList();

        recipe.setIngredients(ingredients);

        // 3. Save again with ingredients attached
        return recipeRepository.save(recipe);
    }

    @Transactional(readOnly = true)
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public void simulateRecipePreparation(Long id) {
        Recipe recipe = getRecipe(id);

        for (RecipeIngredient ri : recipe.getIngredients()) {
            Ingredient ingredient = ingredientService.getIngredientById(ri.getIngredient().getId());

            double available = ingredient.getQuantity();
            double needed = ri.getAmountRequired();

            if (available < needed) {
                throw new NotEnoughIngredientException("Not enough stock for ingredient: " + ingredient.getName());
            }
        }
    }

    public List<String> getMissingIngredients(Long id) {
        Recipe recipe = getRecipe(id);
        List<String> missing = new ArrayList<>();

        for (RecipeIngredient ri : recipe.getIngredients()) {
            Ingredient ingredient = ingredientService.getIngredientById(ri.getIngredient().getId());

            double available = ingredient.getQuantity();
            double needed = ri.getAmountRequired();

            if (available < needed) {
                missing.add(ingredient.getName());
            }
        }

        return missing;
    }

    public void prepareRecipe(Long id) {
        Recipe recipe = getRecipe(id);

        // Avant de consommer, vérifier qu'on a assez (bonne pratique !)
        simulateRecipePreparation(id);

        for (RecipeIngredient ri : recipe.getIngredients()) {
            ingredientService.consumeIngredient(ri.getIngredient().getId(), ri.getAmountRequired());
        }
    }

}
