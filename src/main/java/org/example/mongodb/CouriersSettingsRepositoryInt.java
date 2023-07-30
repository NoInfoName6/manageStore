package org.example.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "couriersSettings", path = "couriersSettings")
public interface CouriersSettingsRepositoryInt extends MongoRepository<CouriersSettings, String> {

    List<CouriersSettings> findByType(@Param("type") String type);
}
