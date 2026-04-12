package com.mclods.taco_cloud_spring_jdbc.services;

import com.mclods.taco_cloud_spring_jdbc.domain.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientService {
    List<Ingredient> findAllIngredients();

    Optional<Ingredient> findIngredientById(String id);

    Ingredient saveIngredient(Ingredient ingredient);
}
