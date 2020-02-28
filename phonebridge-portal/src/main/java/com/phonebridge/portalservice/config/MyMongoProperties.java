package com.phonebridge.portalservice.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "mongodb")
public class MyMongoProperties {

    private MongoProperties primary = new MongoProperties();
}