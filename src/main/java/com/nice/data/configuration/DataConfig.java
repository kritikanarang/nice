package com.nice.data.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;


@Component
@PropertySource(value = { "classpath:application.properties" })
@EnableMongoRepositories(basePackages = { "com.nice.data.repo" })
public class DataConfig extends AbstractMongoConfiguration{

	@Value("${spring.data.mongodb.database}")
	private String database;

	@Value("${spring.data.mongodb.uri}")
	private String mongoUri;
	
	@Autowired
	private MongoProperties mongoProperties;


	@Override
	protected String getDatabaseName() {
		mongoProperties.setDatabase(database);
		mongoProperties.setUri(mongoUri);
		return mongoProperties.getDatabase();
	}


	@Override
	public MongoClient mongoClient() {
		return new MongoClient();
	}

}