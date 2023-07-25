package org.example.services;

import org.example.mongodb.entity.CouriersSettings;

import java.util.HashMap;
import java.util.List;

public interface CouriersSettingsService {
    List<CouriersSettings> getAllTypeOfCouriersSetting();
    CouriersSettings getByType(String type);
    CouriersSettings insertCSNewType(CouriersSettings couriersSettings);
    CouriersSettings updateExistCS (String type, HashMap<String, String> map);
    boolean deleteByType (String type);
}
