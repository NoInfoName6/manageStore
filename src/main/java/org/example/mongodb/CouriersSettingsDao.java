package org.example.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.example.mongodb.entity.CouriersSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CouriersSettingsDao {
    @Autowired
    ConfigProp properties;
    //@Autowired
    //MongoClient client;
    @Autowired
    MongoTemplate template;

    //CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
    //CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

    public CouriersSettings insert(CouriersSettings settings){
        return template.insert(settings, properties.collectionOne);
    }

    public boolean delete(String type){
        Query query = new Query();
        query.addCriteria(Criteria.where("type").is(type));
        return template.remove(query, CouriersSettings.class, properties.collectionOne).wasAcknowledged();
    }
    public List<CouriersSettings> findAll() {
        /*MongoDatabase database = client.getDatabase(properties.getDbName()).withCodecRegistry(pojoCodecRegistry);
        MongoCollection<CouriersSettings> collection = database.getCollection(properties.collectionOne, CouriersSettings.class);
        List<CouriersSettings> list = new ArrayList<>();
        collection.find().into(list);
        return list;*/
        return template.findAll(CouriersSettings.class, properties.collectionOne);
    }

    public CouriersSettings findByType(String type){
        Query query = new Query();
        query.addCriteria(Criteria.where("type").is(type));
        return template.findOne(query, CouriersSettings.class, properties.collectionOne);
    }

    public CouriersSettings findAndModify (String type, HashMap<String,String> map){
        Query query = new Query();
        query.addCriteria(Criteria.where("type").is(type));
        Update update = new Update();
        for (Map.Entry<String ,String> entry : map.entrySet()){
            update.set(entry.getKey(), entry.getValue());
        }
        return template.findAndModify(query, update, CouriersSettings.class, properties.collectionOne);
    }
}
