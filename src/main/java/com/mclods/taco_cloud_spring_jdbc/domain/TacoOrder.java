package com.mclods.taco_cloud_spring_jdbc.domain;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("taco_order")
public class TacoOrder {
    @Id
    @Column("id")
    private int id;

    @NotBlank(message = "Delivery Name is required")
    @Column("delivery_name")
    private String deliveryName;

    @NotBlank(message = "Delivery Street is required")
    @Column("delivery_street")
    private String deliveryStreet;

    @NotBlank(message = "Delivery City is required")
    @Column("delivery_city")
    private String deliveryCity;

    @NotBlank(message = "Delivery State is required")
    @Column("delivery_state")
    private String deliveryState;

    @NotBlank(message = "Delivery Zip is required")
    @Column("delivery_zip")
    private String deliveryZip;

    @CreditCardNumber(message = "Not a valid credit card number")
    @Column("cc_number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\\\/])([2-9][0-9])$", message = "Must be formatted MM/YY")
    @Column("cc_expiration")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    @Column("cc_cvv")
    private String ccCVV;

    @Column("order_date")
    private LocalDateTime orderDate;

    private final List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        tacos.add(taco);
    }
}
