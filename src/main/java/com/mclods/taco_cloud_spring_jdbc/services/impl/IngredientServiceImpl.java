package com.mclods.taco_cloud_spring_jdbc.services.impl;

import com.mclods.taco_cloud_spring_jdbc.domain.Ingredient;
import com.mclods.taco_cloud_spring_jdbc.repositories.IngredientRepository;
import com.mclods.taco_cloud_spring_jdbc.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findAllIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public Optional<Ingredient> findIngredientById(String id) {
        return ingredientRepository.findById(id);
    }

    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }
}
