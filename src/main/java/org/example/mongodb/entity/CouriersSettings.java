package org.example.mongodb.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.bson.types.ObjectId;
import org.example.models.CouriersSettingsModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//@Document("courier_params") //"#{@environment.getProperty('kvv.spring.data.mongodb.collections.first')}"
@Data
@NoArgsConstructor
//@AllArgsConstructor
//@SuperBuilder
public class CouriersSettings extends CouriersSettingsModel {
    //@Id
    //ObjectId _id;
    /*String type;
    int salary_coef;
    int rating_coef;
    double max_order_weight;
    int max_order_amount;
    int max_day_regions;
    int time_one_order_delivery;
    int time_next_couple_order_delivery;
    int first_order_delivery_coef;
    int next_orders_delivery_coef;*/
    @Override
    public String toString(){
        return super.toString();
    }
}
