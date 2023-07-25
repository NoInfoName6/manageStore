package org.example.controllers;

import org.example.mongodb.entity.CouriersSettings;
import org.example.services.CouriersSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/couriersSettings")
public class CouriersSettingsController {
    @Autowired
    CouriersSettingsService couriersSettingsService;
    @GetMapping()
    ResponseEntity<List<CouriersSettings>> getAllTypeCouriersSetting(){
        return new ResponseEntity<>(couriersSettingsService.getAllTypeOfCouriersSetting(),HttpStatus.OK);
    }
    @PostMapping()
    ResponseEntity<CouriersSettings> insertCSNewType (@RequestBody CouriersSettings couriersSettings){
        return new ResponseEntity<>(couriersSettingsService.insertCSNewType(couriersSettings), HttpStatus.CREATED);
    }
    @DeleteMapping("/{type}")
    ResponseEntity<Boolean> deleteCSByType (@PathVariable String type){
        return new ResponseEntity<>(couriersSettingsService.deleteByType(type), HttpStatus.FOUND);
    }

    @PostMapping("/{type}")
    ResponseEntity<CouriersSettings>updateExistCSByType (@PathVariable String type, @RequestBody HashMap<String,String> map){
        return new ResponseEntity<>(couriersSettingsService.updateExistCS(type,map), HttpStatus.FOUND);
    }
}
