package com.tcaputi.back.easyfoodmanaging.recipe.model;

import com.tcaputi.back.easyfoodmanaging.ingredient.model.Ingredient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Recipe recipe;

    @ManyToOne
    private Ingredient ingredient;

    private Double amountRequired; // en grammes ou millilitres

}

