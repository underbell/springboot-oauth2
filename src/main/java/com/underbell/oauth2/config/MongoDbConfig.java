package com.underbell.oauth2.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.underbell.oauth2.common.properties.MongoDbProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.session.data.mongo.config.annotation.web.reactive.EnableMongoWebSession;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.underbell.oauth2.business.**.repository")
@EnableMongoAuditing
@EnableConfigurationProperties(MongoDbProperty.class)
@EnableMongoWebSession
public class MongoDbConfig {

    @Bean
    public MongoClient reactiveMongoClient(MongoDbProperty mongoDbProperty) {
        return MongoClients.create(mongoDbProperty.getUrl());
    }
}