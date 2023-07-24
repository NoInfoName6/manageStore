package org.example.mongodb;

import org.example.mongodb.entity.CouriersSettings;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoConfig.class)
public class CouriersSettingsDaoTest {
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
    @Order(1)
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
        assertNotNull(couriersSettingsDao);
        assertNotNull(couriersSettingsDao.template);
    }
    @Test
    @Order(10)
    public void insert() {
        for (int i=0; i<type.length; i++){
            CouriersSettings couriersSettings = CouriersSettings.builder()
                    .type(type[i])
                    .salary_coef(salary_coef[i])
                    .rating_coef(rating_coef[i])
                    .max_order_weight(max_order_weight[i])
                    .max_order_amount(max_order_amount[i])
                    .max_day_regions(max_day_regions[i])
                    .time_one_order_delivery(time_one_order_delivery[i])
                    .time_next_couple_order_delivery(time_next_couple_order_delivery[i])
                    .first_order_delivery_coef(first_order_delivery_coef[i])
                    .next_orders_delivery_coef(next_order_delivery_coef[i])
                    .build();
            CouriersSettings back = couriersSettingsDao.insert(couriersSettings);
            assertNotNull(back,"Ecxpected not Null, Bro ;)");
        }
    }

    @Test
    @Order(20)
    public void findAll() {
        List<CouriersSettings> couriersSettings = couriersSettingsDao.findAll();
        assertNotNull(couriersSettings);
    }

    @Test
    @Order(30)
    public void findByType() {
        CouriersSettings settings = couriersSettingsDao.findByType("AUTO");
        assertNotNull(settings);

        settings = couriersSettingsDao.findByType("AUTO2");
        assertNull(settings);
    }

    @Test
    @Order(40)
    public void findAndModify() {
        HashMap<String, String> map = new HashMap<>();
        map.put("max_order_amount", "7");
        map.put("max_day_regions", "3");

        CouriersSettings settings = couriersSettingsDao.findAndModify("AUTO", map);
        assertNotNull(settings);

        settings = couriersSettingsDao.findAndModify("AUTO2", map);
        assertNull(settings);
    }

    @Test
    @Order(50)
    public void removeAll() {
        for (String s : type) {
            assertTrue(couriersSettingsDao.delete(s));
        }
        //insert();
    }
}
