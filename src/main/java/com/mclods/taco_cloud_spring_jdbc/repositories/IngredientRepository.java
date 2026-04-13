package com.mclods.taco_cloud_spring_jdbc.repositories;

import com.mclods.taco_cloud_spring_jdbc.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
