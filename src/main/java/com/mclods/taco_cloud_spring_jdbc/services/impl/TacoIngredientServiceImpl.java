package com.mclods.taco_cloud_spring_jdbc.services.impl;

import com.mclods.taco_cloud_spring_jdbc.domain.TacoIngredient;
import com.mclods.taco_cloud_spring_jdbc.repositories.TacoIngredientRepository;
import com.mclods.taco_cloud_spring_jdbc.services.TacoIngredientService;
import org.springframework.stereotype.Service;

@Service
public class TacoIngredientServiceImpl implements TacoIngredientService {
    private final TacoIngredientRepository tacoIngredientRepository;

    public TacoIngredientServiceImpl(TacoIngredientRepository tacoIngredientRepository) {
        this.tacoIngredientRepository = tacoIngredientRepository;
    }

    @Override
    public TacoIngredient saveTacoIngredient(TacoIngredient tacoIngredient) {
        return tacoIngredientRepository.save(tacoIngredient);
    }
}
