package com.tcaputi.back.easyfoodmanaging.ingredient.service;

import com.tcaputi.back.easyfoodmanaging.ingredient.exception.IngredientException;
import com.tcaputi.back.easyfoodmanaging.ingredient.model.Ingredient;
import com.tcaputi.back.easyfoodmanaging.ingredient.openfoodfacts.OpenFoodFactsService;
import com.tcaputi.back.easyfoodmanaging.ingredient.repository.IngredientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;
    private final OpenFoodFactsService openFoodFactsService;

    public Page<Ingredient> getAllIngredients(Pageable pageable) {
        return ingredientRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Ingredient getIngredientById(Long id) {
        return ingredientRepository.findById(id).orElseThrow(() -> new IngredientException("Ingredient not found for id: [" + id + "]"));
    }

    @Transactional(readOnly = true)
    public Ingredient getIngredientByEan13(String ean13) {
        return ingredientRepository.findByEan13(ean13).orElseThrow(() -> new IngredientException("Ingredient not found for ean13: [" + ean13 + "]"));
    }

    @Transactional(readOnly = true)
    public List<Ingredient> searchIngredientsByName(String name) {
        return ingredientRepository.findByNameContaining(name).orElseThrow(() -> new IngredientException("No ingredients found for name: [" + name + "]"));
    }

    public Ingredient addIngredient(Ingredient ingredient) {
        if (ingredient.getEan13() != null) {
            // Adds ingredient; merges quantity if EAN matches
            return ingredientRepository.findByEan13(ingredient.getEan13())
                    .map(existing -> {
                        log.info("Adding quantity [{}] to existing ingredient [{}]", ingredient.getQuantity(), existing.getName());
                        existing.setQuantity(existing.getQuantity() + ingredient.getQuantity());
                        return ingredientRepository.save(existing);
                    })
                    .orElseGet(() -> {
                        log.info("Fetching ingredient from OpenFoodFacts for EAN: [{}]", ingredient.getEan13());
                        Optional<Ingredient> fromOpenFoodFacts = openFoodFactsService.fetchIngredientFromOpenFoodFacts(ingredient.getEan13());
                        return fromOpenFoodFacts.map(ingredientRepository::save)
                    .orElseGet(() -> ingredientRepository.save(ingredient));
                    });
        } else {
            return ingredientRepository.save(ingredient);
        }
    }

    @Transactional
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }

    @Transactional
    public Ingredient updateIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }
}
