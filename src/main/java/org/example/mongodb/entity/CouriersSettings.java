package org.example.mongodb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//@Document("courier_params") //"#{@environment.getProperty('kvv.spring.data.mongodb.collections.first')}"
@Data
@NoArgsConstructor
public class CouriersSettings {
    //@Id
    ObjectId _id;
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
