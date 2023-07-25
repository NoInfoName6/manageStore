package org.example.mongodb.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//@Document("courier_params") //"#{@environment.getProperty('kvv.spring.data.mongodb.collections.first')}"
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CouriersSettings {
    @NotBlank
    String type;
    @PositiveOrZero
    int salary_coef;
    @PositiveOrZero
    int rating_coef;
    @PositiveOrZero
    double max_order_weight;
    @PositiveOrZero
    int max_order_amount;
    @PositiveOrZero
    int max_day_regions;
    @PositiveOrZero
    int time_one_order_delivery;
    @PositiveOrZero
    int time_next_couple_order_delivery;
    @PositiveOrZero
    @Max(value = 100)
    int first_order_delivery_coef;
    @PositiveOrZero
    @Max(value = 100)
    int next_orders_delivery_coef;
}
