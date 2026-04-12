package com.mclods.taco_cloud_spring_jdbc.repositories;

import com.mclods.taco_cloud_spring_jdbc.domain.TacoIngredient;

public interface TacoIngredientRepository {
    TacoIngredient save(TacoIngredient tacoIngredient);
}
