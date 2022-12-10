package com.example.backendjavaheroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClients;

@SpringBootApplication
public class BackendJavaHeroesApplication {

	
ConnectionString connectionString = new ConnectionString("mongodb+srv://root:admin@cluster0.mfzggdc.mongodb.net/?retryWrites=true&w=majority");
MongoClientSettings settings = MongoClientSettings.builder()
        .applyConnectionString(connectionString)
        .serverApi(ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build())
        .build();
MongoClient mongoClient = MongoClients.create(settings);
MongoDatabase database = mongoClient.getDatabase("test");


	public static void main(String[] args) {
		SpringApplication.run(BackendJavaHeroesApplication.class, args);
	}

}
