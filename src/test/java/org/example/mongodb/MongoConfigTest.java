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
public class MongoConfigTest {
    @Autowired
    CouriersSettingsDao couriersSettingsDao;
    @Test
    @Order(12)
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
        assertNotNull(couriersSettingsDao);
        assertNotNull(couriersSettingsDao.template);
    }


}