package org.example.mongodb;

import org.example.mongodb.entity.CouriersSettings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CouriersSettingsDaoTest {
    @Autowired
    CouriersSettingsDao couriersSettingsDao;
    @Test
    void insert() {
    }

    @Test
    void delete() {
    }

    @Test
    void findAll() {
        List<CouriersSettings> couriersSettings = couriersSettingsDao.findAll();
        assertNotNull(couriersSettings);
    }

    @Test
    void findByType() {
        CouriersSettings settings = couriersSettingsDao.findByType("AUTO");
        assertNotNull(settings);

        settings = couriersSettingsDao.findByType("AUTO2");
        assertNull(settings);
    }

    @Test
    void findAndModify() {
        HashMap<String, String> map = new HashMap<>();
        map.put("max_order_amount", "7");
        map.put("max_day_regions", "3");

        CouriersSettings settings = couriersSettingsDao.findAndModify("AUTO", map);
        assertNotNull(settings);

        settings = couriersSettingsDao.findAndModify("AUTO2", map);
        assertNull(settings);
    }
}