package com.tcaputi.back.easyfoodmanaging.ingredient.mapper;

import com.tcaputi.back.easyfoodmanaging.ingredient.model.Ingredient;
import com.tcaputi.back.easyfoodmanaging.ingredient.model.IngredientDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IngredientMapper {

    IngredientDto toDto(Ingredient ingredient);

    Ingredient toEntity(IngredientDto ingredientDto);
}
