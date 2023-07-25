package org.example.services;

import org.example.mongodb.CouriersSettingsDao;
import org.example.mongodb.entity.CouriersSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CouriersSettingsServiceImpl implements  CouriersSettingsService{
    @Autowired
    CouriersSettingsDao couriersSettingsDao;
    @Override
    public List<CouriersSettings> getAllTypeOfCouriersSetting() {

        return couriersSettingsDao.findAll();
        }

    @Override
    public CouriersSettings getByType(String type) {
        return couriersSettingsDao.findByType(type);
    }

    @Override
    public CouriersSettings insertCSNewType(CouriersSettings couriersSettings) {
        return couriersSettingsDao.insert(couriersSettings);
    }

    @Override
    public CouriersSettings updateExistCS(String type, HashMap<String, String> map) {
        return couriersSettingsDao.findAndModify(type, map);
    }

    @Override
    public boolean deleteByType(String type) {
        return couriersSettingsDao.delete(type);
    }
}

