package com.mclods.taco_cloud_spring_jdbc.domain;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TacoOrder {
    private int id;

    @NotBlank(message = "Delivery Name is required")
    private String deliveryName;

    @NotBlank(message = "Delivery Street is required")
    private String deliveryStreet;

    @NotBlank(message = "Delivery City is required")
    private String deliveryCity;

    @NotBlank(message = "Delivery State is required")
    private String deliveryState;

    @NotBlank(message = "Delivery Zip is required")
    private String deliveryZip;

    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\\\/])([2-9][0-9])$", message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    private LocalDateTime orderDate;

    private final List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        tacos.add(taco);
    }
}
