package com.mclods.taco_cloud_spring_jdbc.repositories;

import com.mclods.taco_cloud_spring_jdbc.domain.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository {
    List<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
