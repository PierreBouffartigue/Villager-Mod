package fr.ynov.villager.bdd;


import redis.clients.jedis.JedisPool;

public class JedisConnexion {

    public static JedisPool initJedis() {
        return new JedisPool("127.0.0.1", 6379);
        /**
         Jedis j = jedisPool.getResource();

         try {
         j.select(0); //select db
         j.set("abc", "def");
         String value = j.get("abc");

         } finally {
         assert j != null;
         j.close();
         }

         onDisable();
         }

         public static void onDisable() {
         jedisPool.close();
         }
         **/
    }
}
