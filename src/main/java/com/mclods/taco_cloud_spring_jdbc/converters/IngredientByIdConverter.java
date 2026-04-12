package com.mclods.taco_cloud_spring_jdbc.converters;

import com.mclods.taco_cloud_spring_jdbc.domain.Ingredient;
import com.mclods.taco_cloud_spring_jdbc.services.IngredientService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private final IngredientService ingredientService;

    public IngredientByIdConverter(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientService.findIngredientById(id).orElse(null);
    }
}
