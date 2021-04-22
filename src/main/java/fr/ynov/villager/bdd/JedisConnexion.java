package fr.ynov.villager.bdd;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisConnexion {
    public static JedisPool jedisPool;

    public static void initJedis() {
        jedisPool = new JedisPool("127.0.0.1", 6379);
        Jedis j = null;

        try {
            j = jedisPool.getResource();
            j.select(0); //select db
            j.set("abc", "def");


        } finally {
            assert j != null;
            j.close();
        }

        onDisable();
    }

    public static void onDisable() {
        jedisPool.close();
    }
}
