package com.mclods.taco_cloud_spring_jdbc.services;

import com.mclods.taco_cloud_spring_jdbc.domain.TacoIngredient;

public interface TacoIngredientService {
    TacoIngredient saveTacoIngredient(TacoIngredient tacoIngredient);
}
