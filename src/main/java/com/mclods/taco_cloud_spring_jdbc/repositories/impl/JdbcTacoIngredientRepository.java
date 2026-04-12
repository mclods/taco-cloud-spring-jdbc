package com.mclods.taco_cloud_spring_jdbc.repositories.impl;

import com.mclods.taco_cloud_spring_jdbc.domain.TacoIngredient;
import com.mclods.taco_cloud_spring_jdbc.repositories.TacoIngredientRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTacoIngredientRepository implements TacoIngredientRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTacoIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public TacoIngredient save(TacoIngredient tacoIngredient) {
        jdbcTemplate.update("INSERT INTO taco_ingredient(taco_id, ingredient_id) VALUES (?, ?)",
                tacoIngredient.getTacoId(), tacoIngredient.getIngredientId());

        return tacoIngredient;
    }
}