package com.mclods.taco_cloud_spring_jdbc.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Taco {
    private int id;

    @NotNull
    @Size(min = 5, message = "Taco name must be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "You must choose at least one ingredient")
    private List<Ingredient> ingredients;

    private LocalDateTime creationDate;
}
