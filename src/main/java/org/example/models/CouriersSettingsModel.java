package org.example.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class CouriersSettingsModel {
    String type;
    int salary_coef;
    int rating_coef;
    double max_order_weight;
    int max_order_amount;
    int max_day_regions;
    int time_one_order_delivery;
    int time_next_couple_order_delivery;
    int first_order_delivery_coef;
    int next_orders_delivery_coef;
}
