package com.mclods.taco_cloud_spring_jdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TacoIngredient {
    private int tacoId;

    private String ingredientId;
}
