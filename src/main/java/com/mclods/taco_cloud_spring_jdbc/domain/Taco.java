package com.mclods.taco_cloud_spring_jdbc.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("taco")
public class Taco {
    @Id
    @Column("id")
    private int id;

    @NotNull
    @Size(min = 5, message = "Taco name must be at least 5 characters long")
    @Column("name")
    private String name;

    @Column("creation_date")
    private LocalDateTime creationDate;

    @NotNull
    @Size(min = 1, message = "You must choose at least one ingredient")
    private List<Ingredient> ingredients = new ArrayList<>();
}
