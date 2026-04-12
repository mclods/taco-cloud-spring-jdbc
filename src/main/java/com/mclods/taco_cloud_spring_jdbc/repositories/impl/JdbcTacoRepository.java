package com.mclods.taco_cloud_spring_jdbc.repositories.impl;

import com.mclods.taco_cloud_spring_jdbc.domain.Ingredient;
import com.mclods.taco_cloud_spring_jdbc.domain.Taco;
import com.mclods.taco_cloud_spring_jdbc.domain.TacoIngredient;
import com.mclods.taco_cloud_spring_jdbc.repositories.TacoRepository;
import com.mclods.taco_cloud_spring_jdbc.services.TacoIngredientService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class JdbcTacoRepository implements TacoRepository {
    private final JdbcTemplate jdbcTemplate;
    private final TacoIngredientService tacoIngredientService;

    public JdbcTacoRepository(JdbcTemplate jdbcTemplate, TacoIngredientService tacoIngredientService) {
        this.jdbcTemplate = jdbcTemplate;
        this.tacoIngredientService = tacoIngredientService;
    }

    @Override
    public Taco save(int orderId, Taco taco) {
        taco.setCreationDate(LocalDateTime.now());

        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory("INSERT INTO " +
                "taco(name, creation_date, taco_order_id) VALUES (?, ?, ?)");
        pscf.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                List.of(
                        taco.getName(),
                        taco.getCreationDate(),
                        orderId
                )
        );

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(psc, keyHolder);

        int tacoId = keyHolder.getKey().intValue();
        taco.setId(tacoId);

        // Save the taco ingredients
        List<Ingredient> ingredients = taco.getIngredients();
        for(Ingredient ingredient : ingredients) {
            tacoIngredientService.saveTacoIngredient(new TacoIngredient(taco.getId(), ingredient.getId()));
        }


        return taco;
    }
}