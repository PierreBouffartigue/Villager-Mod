package fr.ynov.villager.bdd;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoConnexion {

    public static MongoClient initMongo() {
        return MongoClients.create("mongodb://villager:villager@127.0.0.1:27017/villager");
    }
}
