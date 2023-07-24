package org.example.mongodb;

import org.example.mongodb.entity.CouriersSettings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoConfig.class)
public class MongoConfigTest {
    private final String[] type = new String[]{"AUTO","BIKE","FOOT"};
    private final int[] salary_coef = new int[]{4,3,2};
    private final int[] rating_coef = new int[]{1,2,3};
    private final int[] max_order_weight = new int[]{40,20,10};
    private final int[] max_order_amount = new int[]{7,4,2};
    private final int[] max_day_regions = new int[]{3,2,1};
    private final int[] time_one_order_delivery = new int[]{8,12,25};
    private final int[] time_next_couple_order_delivery = new int[]{4,8,10};
    private final int[] first_order_delivery_coef = new int[]{100,100,100};
    private final int[] next_order_delivery_coef = new int[]{80,80,80};
    @Autowired
    CouriersSettingsDao couriersSettingsDao;
    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
        assertNotNull(couriersSettingsDao);
        assertNotNull(couriersSettingsDao.template);
    }


}