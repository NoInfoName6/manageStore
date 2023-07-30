package org.example.mongodb;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.rest.core.annotation.RestResource;


//@Document("courier_params") //"#{@environment.getProperty('kvv.spring.data.mongodb.collections.first')}"
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Document (collection = "courier_params2")
@RestResource(rel = "couriersSettings", path = "couriersSettings")
public class CouriersSettings {
    //@Id
    //@Null
    //String _id;
    @NotBlank
    String type;
    @Id
    @Null
    String type_name;
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

    public void setType(String type){
        this.type = type;
        type_name = type;
    }
}
