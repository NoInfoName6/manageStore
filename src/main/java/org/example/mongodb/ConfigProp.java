package org.example.mongodb;

import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "kvv.spring.data.mongodb")
@ConfigurationPropertiesScan
@Data
public class ConfigProp {
    String uri;
    String dbName;
    String collectionOne;
    int maxPoolSize;
}
