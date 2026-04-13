package com.mclods.taco_cloud_spring_jdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("taco_ingredient")
public class TacoIngredient {
    @Column("taco_id")
    private int tacoId;

    @Column("ingredient_id")
    private String ingredientId;
}
