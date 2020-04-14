package com.underbell.oauth2.common.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.data.mongodb")
@Getter
@Setter
public class MongoDbProperty {
    private String url;
    private String database;
}
