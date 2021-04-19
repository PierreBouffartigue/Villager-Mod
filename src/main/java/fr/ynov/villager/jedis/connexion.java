package fr.ynov.villager.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class connexion {
    public static JedisPool jedisPool;

    public connexion() {
        jedisPool = new JedisPool("90.120.184.220", 6379);
        Jedis j = null;

        try {
            j = jedisPool.getResource();
            //j.auth("mdp");

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
