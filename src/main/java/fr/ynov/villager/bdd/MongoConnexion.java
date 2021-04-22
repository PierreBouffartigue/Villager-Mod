package fr.ynov.villager.bdd;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnexion {
    MongoClient client = MongoClients.create("127.0.0.1");
    MongoDatabase database = client.getDatabase("villager");

}
