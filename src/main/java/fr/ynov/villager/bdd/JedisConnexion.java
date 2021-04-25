package fr.ynov.villager.bdd;


import redis.clients.jedis.JedisPool;

public class JedisConnexion {

    public static JedisPool initJedis() {
        return new JedisPool("127.0.0.1", 6379);
    }
}
